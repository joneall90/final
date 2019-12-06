package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entities.Product;
import com.udacity.course3.reviews.entities.Reviews;
import com.udacity.course3.reviews.mongoEntities.mongoReviews;
import com.udacity.course3.reviews.mongoRepository.CommentMongoRepository;
import com.udacity.course3.reviews.mongoRepository.MongoReviewsRepository;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {
    @Autowired
    MongoReviewsRepository mongoReviewsRepository;

    @Autowired
    CommentMongoRepository commentMongoRepository;

    @Autowired
    ReviewsRepository reviewsRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CommentRepository commentRepository;

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<Reviews> createReviewForProduct(@PathVariable("productId") Integer productId, @RequestBody Reviews review) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            review.setProduct(product.get());
            review = reviewsRepository.save(review);
            mongoReviews mongoReview = new mongoReviews();
            mongoReview.setReviewId(review.getReviewId());
            mongoReview.setReview(review.getReview());
            mongoReview.setProductId(productId);
            try {
                // review = reviewsRepository.save(review);
                mongoReview = mongoReviewsRepository.save(mongoReview);
            } catch (Exception e){
                System.out.println(e);
            }
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public List<mongoReviews> listReviewsForProduct(@PathVariable("productId") Integer productId) {

        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            return mongoReviewsRepository.findByProductId(productId);
        }
        return Collections.emptyList();
    }
}