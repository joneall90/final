package com.udacity.course3.reviews.mongoRepository;

import com.udacity.course3.reviews.entities.Comment;
import com.udacity.course3.reviews.mongoEntities.mongoComment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentMongoRepository extends MongoRepository<mongoComment, String> {
}
