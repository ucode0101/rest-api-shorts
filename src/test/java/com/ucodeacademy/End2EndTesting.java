package com.ucodeacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class End2EndTesting {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";
    }

    File file = new File("product.json");
    File updateBody = new File("updateProduct.json");
    int productId;
    @Test
    public void endToEndTesting(){

        // 1. add new product
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(file)
                .when()
                .post("/products");

        // verify status
        response.then().assertThat().statusCode(201);

        // verify with JUnit assertion
        Assert.assertEquals(201, response.getStatusCode());

        response.prettyPrint();

        productId = response.path("id");

        // make sure the id is store
        //System.out.println(productId);

        System.out.println("==============================================");
        //2. get newly added product by id

        response = given().accept(ContentType.JSON)
                .pathParams("id", productId)
                .when()
                .get("/products/{id}");

        response.then().assertThat().statusCode(200);

        // verify body from response body
        int currentId = response.path("id");
        Assert.assertEquals(productId, currentId);

        response.prettyPrint();

        System.out.println("==================================");

        // 3. Update newly added product

        response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(updateBody)
                .when()
                .put("/products/"+productId);

        response.then().assertThat().statusCode(200);
        response.prettyPrint();

        System.out.println("==========================================");

        // 4. Delete product
        response = given()
                .when()
                .delete("/products/"+productId);
        response.then().assertThat().statusCode(200);

        // verify delete success message
        Assert.assertEquals("Deleted", response.path("success"));
        response.prettyPrint();
    }
}
