package com.udacity.course3.reviews;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.udacity.course3.reviews.entities.Product;
import com.udacity.course3.reviews.entities.Reviews;
import com.udacity.course3.reviews.mongoEntities.mongoProduct;
import com.udacity.course3.reviews.mongoEntities.mongoReviews;
import com.udacity.course3.reviews.mongoRepository.MongoReviewsRepository;
import com.udacity.course3.reviews.mongoRepository.ProductMongoRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class MongoDBTest {

    @Autowired
    MongoReviewsRepository mongoReviewsRepository;
    @Autowired
    ProductMongoRepository productMongoRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @DisplayName("given object to save"
            + "when save object using mongoDBTemplate"
            + "then object is saved")

    @Test
    public void test() {
        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("key", "value")
                .get();

        mongoTemplate.save(objectToSave, "collection");

        Assertions.assertThat(mongoTemplate.findAll(DBObject.class, "collection").equals(objectToSave));
    }

    @Test
    public void findByMongoIdTest() {

    DBObject product = BasicDBObjectBuilder.start()
            .add("productId",1)
            .add("productName","test")
            .add("reviews","").get();
    mongoTemplate.save(product,"product");

    DBObject review = BasicDBObjectBuilder.start()
            .add("reviewId", "1")
            .add("productId",1)
            .add("comments","").get();
    mongoTemplate.save(review,"reviews");

        DBObject review2 = BasicDBObjectBuilder.start()
                .add("reviewId", "2")
                .add("productId",1)
                .add("comments","").get();
        mongoTemplate.save(review2,"reviews");
    List<mongoReviews> returnList = mongoReviewsRepository.findByProductId(1);

    }
}
