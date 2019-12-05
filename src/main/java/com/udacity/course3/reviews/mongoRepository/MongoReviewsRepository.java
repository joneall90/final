package com.udacity.course3.reviews.mongoRepository;

import com.udacity.course3.reviews.entities.Product;
import com.udacity.course3.reviews.entities.Reviews;
import com.udacity.course3.reviews.mongoEntities.mongoReviews;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MongoReviewsRepository extends MongoRepository<mongoReviews,String> {
    List<mongoReviews> findByProductId(Integer productId);
}
