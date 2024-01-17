package com.pojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class TestProductRequest {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";
    }

    @Test
    public void addProduct(){

       ProductRequestBody requestBody = new ProductRequestBody();
       requestBody.setName("super orange");
       requestBody.setPrice(4.99);

        Response response = given().contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/products");

        response.prettyPrint();

    }
    @Test
    public void getAllProduct(){

        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/products");

        response.then().statusCode(200);

       // response.prettyPrint();

        List<ProductResponseBody> allProducts = response.jsonPath().getList("products",ProductResponseBody.class);


        //System.out.println(allProducts);

        // loop through and print each id
        for (ProductResponseBody each : allProducts){
            System.out.println(each.getId());
        }
        System.out.println("========================");

        // loop and print each name
        for (ProductResponseBody each : allProducts){
            System.out.println(each.getName());

        }


    }



}
