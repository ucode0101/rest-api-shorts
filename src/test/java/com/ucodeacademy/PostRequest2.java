package com.ucodeacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class PostRequest2 {

    // Requires token when sending request
    String baseUrl2 = "https://thinking-tester-contact-list.herokuapp.com";

     String username = """
            {
                "email": "xyz@test.com",
                "password": "testing123"
            }
            """;


     public String getToken(){
         String token = "";
         Response response = RestAssured.given().contentType(ContentType.JSON)
                 .accept(ContentType.JSON)
                 .body(username)
                 .when().post(baseUrl2 +"/users/login");

         token = response.body().path("token");
         return token;
     }

}
