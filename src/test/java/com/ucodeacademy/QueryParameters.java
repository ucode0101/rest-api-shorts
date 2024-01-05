package com.ucodeacademy;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class QueryParameters {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";

    }

    @Test
    public void testQueryParameter(){

        Response response = given().queryParam("search","a")
                //.queryParam("limit",2)
                .when()
                .get("/products");

        response.prettyPrint();

    }


}
