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

     String contactInfo = """
             {
                 "firstName": "Test2",
                 "lastName": "Test2",
                 "birthdate": "1980-02-01",
                 "email": "test2@test.com",
                 "phone": "11111112222",
                 "street1": "111 Test st.",
                 "street2": "Apartment D",
                 "city": "Anytown",
                 "stateProvince": "NJ",
                 "postalCode": "12345",
                 "country": "USA"
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



     @Test
    public void addNewContact(){
         String token = getToken();

         Response response = RestAssured.given().auth().oauth2(token)
                 .contentType(ContentType.JSON)
                 .body(contactInfo)
                 .accept(ContentType.JSON)
                 .when().post(baseUrl2 + "/contacts");

         // verify status code
         Assert.assertEquals(201, response.statusCode());
         // print
         response.prettyPrint();

         // print first name
       String firstName =  response.body().path("firstName");
         System.out.println(firstName);
     }
}
