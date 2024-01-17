package com.pojo;

import com.ucodeacademy.GenerateToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;

public class EndToEndTestPOJO {

//    @BeforeClass
//    public static void setUp(){
//        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
//
//    }


    // End-to-End testing following POJO approach

    // 1. Login to generate token or use existing one

    String token = GenerateToken.loginToGetToken();
    static String contactId;

    // 2. Add a new contact (following POJO )

    Contact contact = new Contact();


//    @Test
//    public void addNewContact(){
//        contact.setFirstName("Mike12");
//        contact.setLastName("Mike34");
//        contact.setEmail("mike123@test.com");
//
//        Response response = given().auth().oauth2(token)
//                .contentType(ContentType.JSON)
//                .body(contact)
//                .when()
//                .post("https://thinking-tester-contact-list.herokuapp.com/contacts");
//
//        response.then().assertThat().statusCode(201);
//
//        contactId = response.jsonPath().getString("_id");
//        //Contact a = response.jsonPath().getList("",Contact.class);
//        //System.out.println(a);
//
//        System.out.println(contactId);
//        response.prettyPrint();
//    }
    static String id;
    @Test
    public void test1(){
        id = "123";
        System.out.println(id);
    }
    @Test
    public void test2(){
        System.out.println(id);
    }

    // 3. Get newly added contact by ID, and verify

    // 4. Update contact, and verify

    // 5. Delete contact, verify

}
