package com.ucodeacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";

    }


    @Test
    public void testPathParameter(){
        Response response = given().contentType(ContentType.JSON)
                .pathParams("productId",16)
                .when()
                .get("/products/{productId}");
        response.prettyPrint();
    }
}
