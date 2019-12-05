package com.udacity.course3.reviews;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class MongoDBTest {

    @DisplayName("given object to save"
    + "when save object using mongoDBTemplate"
    + "then object is saved")

    @Test
    public void test(@Autowired MongoTemplate mongoTemplate){
        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("key","value")
                .get();

        mongoTemplate.save(objectToSave,"collection");

        Assertions.assertThat(mongoTemplate.findAll(DBObject.class,"collection").equals(objectToSave));
    }
}
