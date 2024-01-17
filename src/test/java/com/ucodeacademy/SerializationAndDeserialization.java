package com.ucodeacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class SerializationAndDeserialization {

    // Jackson & Gson libraries are used for Serialization & Deserialization. You can use either one

    //Serialization is to convert Java Object into Json format when we are sending POST, PUT, or PATCH requests
    //Deserialization is to convert Json into Java Object when we get response body in JSON





    static String token;

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI  = "https://thinking-tester-contact-list.herokuapp.com";
        token = GenerateToken.loginToGetToken();


    }


    @Test
    public void addContact(){
        Map<String, Object> contactBody = new HashMap<>();

        contactBody.put("firstName","Test0101");
        contactBody.put("lastName", "Test0202");
        contactBody.put("email","test@test.com");

        Response response = given().auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(contactBody)
                .when()
                .post("/contacts");

        response.prettyPrint();
    }

    @Test
    public void getAll(){
        Response response = given().auth().oauth2(token)
                .accept(ContentType.JSON)
                .when()
                .get("/contacts");

        //response.prettyPrint();

        List<Map<String, Object>> all = response.as(List.class);
        System.out.println(all);
    }

}
