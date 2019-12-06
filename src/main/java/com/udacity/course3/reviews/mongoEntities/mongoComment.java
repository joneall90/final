package com.udacity.course3.reviews.mongoEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udacity.course3.reviews.entities.Reviews;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document ("comment")
public class mongoComment {

    @Id
    private int commentId;
    private Reviews reviewId;
    private String comment;

    public mongoComment(String comment) {
        this.setComment(comment);
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Reviews getReviewId() {
        return reviewId;
    }

    public void setReviewId(Reviews reviewId) {
        this.reviewId = reviewId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public mongoComment(){}
}