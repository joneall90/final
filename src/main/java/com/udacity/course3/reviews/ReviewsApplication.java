package com.udacity.course3.reviews;



import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsApplication.class, args);
	}

	String uri = "mongodb://jake:jake@localhost:27017/course3";
	MongoClient mongoClient = MongoClients.create(uri);
	MongoDatabase mongoDatabase = mongoClient.getDatabase("course3");

}