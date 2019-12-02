package com.udacity.course3.reviews.mongoRepository;

import com.udacity.course3.reviews.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository<Product, String> {

}
