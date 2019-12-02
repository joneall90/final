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

    private Product product;
    private String review;
    private List<mongoReviews> reviews = new ArrayList<>();

    public List<mongoReviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<mongoReviews> reviews) {
        this.reviews = reviews;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void Review(){}
}