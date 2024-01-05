package com.ucodeacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;


public class GetRequest {

    String baseUrl = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";

    @Test
    public void getAllProducts(){

       Response response = RestAssured.get(baseUrl + "/products");

       // print status code
        System.out.println("Status code: "+response.statusCode());

        // print response body
        response.prettyPrint();

    }


    @Test
    public void getAllProducts2(){
        Response response = RestAssured.get(baseUrl + "/products");
        // Verify status code
        Assert.assertEquals(200, response.statusCode());

        // Verify response body contains some String
        Assert.assertTrue(response.body().asString().contains("Pineapple"));

        response.prettyPrint();
    }



    @Test
    public void getAllProducts3(){
        // Given, Accept application/json
        // When user sends get request
        // Then status code should 200
        // Verify response body contains some String

        // first way without storing Response
//        RestAssured.given().accept(ContentType.JSON)
//                .when()
//                .get(baseUrl + "/products")
//                .then()
//                .statusCode(200)
//                .body(Matchers.containsString("Pineapple"));

         // second way, store response

        Response response = RestAssured.given().accept(ContentType.JSON)
                           .when().get(baseUrl + "/products");


        Assert.assertEquals(200, response.statusCode());

        Assert.assertTrue(response.body().asString().contains("Pineapple"));

        response.prettyPrint();






    }
}
