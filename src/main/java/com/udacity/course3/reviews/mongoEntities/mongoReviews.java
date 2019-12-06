package com.udacity.course3.reviews.mongoEntities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udacity.course3.reviews.entities.Product;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Document ("reviews")
public class mongoReviews {
    @Id
    private int reviewId;

    private Integer productId;
    private String review;
    private List<mongoComment> comments = new ArrayList<>();

    public List<mongoComment> getComments() {
        return comments;
    }

    public void setComments(List<mongoComment> comments) {
        this.comments = comments;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void Review(){}
}