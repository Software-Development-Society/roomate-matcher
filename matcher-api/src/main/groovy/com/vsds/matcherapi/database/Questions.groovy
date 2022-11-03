package com.vsds.matcherapi.database

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

import java.lang.reflect.Array

@Document(collection = "questions")
class Questions {
    @Id
    ObjectId user_id
    @Field
    String sex
    @Field
    ArrayList<ArrayList<Integer>> responses

    Questions(String sex, ArrayList<ArrayList<Integer>> responses) {
        this.sex = sex
        this.responses = responses
    }

    Questions(){}

    Questions(ObjectId user_id, String sex, ArrayList<ArrayList<Integer>> responses) {
        this.user_id = user_id
        this.sex = sex
        this.responses = responses
    }

    @Override
    public String toString() {
        return "Questions{" +
                "user_id=" + user_id +
                ", responses=" + responses +
                '}';
    }
}
