package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entities.Comment;
import com.udacity.course3.reviews.entities.Product;
import com.udacity.course3.reviews.entities.Reviews;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;
import org.junit.jupiter.api.Assertions;
/*import org.junit.Test;
import org.junit.runner.RunWith;*/
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*@RunWith(SpringRunner.class)*/
@DataJpaTest
public class ReviewsApplicationTests {
	@Autowired
	ReviewsRepository reviewsRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CommentRepository commentRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void reviewTest(){
		productTest();
		Reviews review = new Reviews();
		review.setReview("very good");
		/*Product product = new Product();
		product.setProductId(1);
		product.setProductName("dina");*/
		Optional<Product> product = productRepository.findById(1);
		if(product.isPresent()){
			Product testProd = productRepository.findById(1).get();
			review.setProduct(testProd);
		}


		System.out.println(review.getReviewId() + "test");
		review = reviewsRepository.save(review);
		System.out.println(reviewsRepository.findById(1));
		Assertions.assertNotNull(review);

	}
	@Test
	public void productTest(){
		List<Reviews> reviews = new ArrayList<>();
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("dina");
		product.setReviews(reviews);
		product = productRepository.save(product);
		Assertions.assertNotNull(product);

	}

/*	@Test
	public void commentTest(){
		Comment comment = new Comment();
		comment.setComment("this is a comment");
		comment.setReviewId(1);
		Assert.assertNotNull("review is null", comment);

	}*/
	@Test
	public void testSaveAndGetComments(){

		reviewTest();
		Comment comment = new Comment("Very good");
		Reviews rev4Com = reviewsRepository.findById(1).get();
		comment.setReviewId(rev4Com);
		comment = commentRepository.save(comment);
		Assertions.assertNotNull(comment.getCommentId());

		Optional<Comment> savedComment = commentRepository.findById(comment.getCommentId());
		Assertions.assertTrue(savedComment.isPresent());
		Assertions.assertEquals(comment, savedComment.get());


		List<Comment> comments = commentRepository.findAll();
		Assertions.assertTrue(comments.size()>0);

		comments = commentRepository.findAllByReviewId(reviewsRepository.findById(1).get());
		Assertions.assertTrue(comments.size()>0);

	}
}