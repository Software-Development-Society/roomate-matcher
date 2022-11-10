package com.vsds.matcherapi.services


import com.vsds.matcherapi.MatcherApiApplication
import com.vsds.matcherapi.User.User
import com.vsds.matcherapi.database.MatchList
import com.vsds.matcherapi.database.Questions
import com.vsds.matcherapi.database.Users
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.aggregation.ArrayOperators.In

import java.lang.reflect.Array
import java.util.regex.Matcher

class DatabaseServices {
        static Users getUserFromId(ObjectId userId){
                for (Users dbUser: MatcherApiApplication.visableUserRepo.findAll()){
                        println("User gotten from repo :"+ dbUser.toString())
                        if (dbUser.getUserId() != null){
                                if (dbUser.getUserId() == userId){
                                        println(dbUser.toString())
                                        return dbUser
                                }
                        }
                }
                if (User.getName() == null) {
                        print "ISSUE WITH GETTING USER"
                }
        }

        static void updateUser(Users user){
                MatcherApiApplication.visableUserRepo.save(user)
        }



        static User getUser(ObjectId userId){
                Users currentUser = getUserFromId(userId)
                println("Current user" + currentUser)
                return new User(currentUser.getUserId() as String, currentUser.getFirstName() as String, currentUser.getLastName() as String,
                        currentUser.getUsername() as String, currentUser.getSex() as String, currentUser.classYear as int, currentUser.age as int, currentUser.getBio() as String)
        }




        static boolean saveFormResponses(ObjectId user_id, String sex, ArrayList<ArrayList<Integer>> formResponses) {
                Questions questionList = new Questions(user_id, sex,formResponses)
                MatcherApiApplication.visableQuestionRepo.save(questionList)
                return true

        }


        static ArrayList<ArrayList<Integer>> returnQuestions(ObjectId user_id){
                for(Questions question : MatcherApiApplication.visableQuestionRepo.findAll()){
                        if(question.getUser_id() == user_id){
                                return question.getResponses()
                        }
                }
        }


        static boolean saveUserMatches(ObjectId user_id, HashMap<ObjectId, Integer> matchList){
                MatchList matchListToSave = new MatchList(user_id, matchList)
                MatcherApiApplication.visableMatchListRepo.save(matchListToSave)
                return true;
        }

        static HashMap<ObjectId, Integer> getMatchListFromUserId(ObjectId user_id){
                for(MatchList currentMatch : MatcherApiApplication.visableMatchListRepo.findAll()){
                        if(currentMatch.getUserId() == user_id) {
                                return currentMatch.getMatchList();
                        }
                }
        }


}
