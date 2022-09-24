package com.vsds.matcherapi.Controllers


import com.vsds.matcherapi.User.User
import com.vsds.matcherapi.services.DatabaseServices
import com.vsds.matcherapi.services.UserServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MatcherLoginController {
    @GetMapping
    public String helloWorld(){
        return "hello world"
    }

    @PostMapping("/login-handling")
    public String loginHandling(String userId){


        return 'login success'


    }
    @GetMapping("/login-test")
    public String test(){
        User.setLastName("Cormier")
//        DatabaseServices.getUserFromId("1000")
        return "Test"

    }

}
