package com.udacity.course3.reviews.mongoEntities;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Document ("product")
public class mongoProduct {

    @Id
    private int productId;
    private String productName;
    private List<mongoReviews> reviews = new ArrayList<>();

    public mongoProduct() {

    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<mongoReviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<mongoReviews> reviews) {
        this.reviews = reviews;
    }

}
