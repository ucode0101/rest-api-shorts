package com.ucodeacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PathVsJsonPath {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";
    }

                   // path() vs jsonPath()


    // The path() method is used to extract values from the response based on a provided path expression.
    //It is not specific to JSON and can be used with XML and HTML responses as well.
    //It uses a simple path-like syntax to navigate through the response and extract values.

    //The jsonPath() method is specifically designed for working with JSON responses.
    //It uses the JsonPath syntax to navigate through JSON structures and extract values.
    //It provides more flexible options for extracting data from JSON responses compared to the path() method
    // There are two ways of using jsonPath()
    // 1. Create an instance of JsonPath
    // 2. call jsonPath() directly

    @Test
    public void getAllProducts(){
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/products");


        Assert.assertEquals(200, response.getStatusCode());
        //response.prettyPrint();

        // 1 way create an instance
        JsonPath jsonPath = response.jsonPath();
        int id1 = jsonPath.getInt("products[0].id");

        // 2 way using jsonPath() without creating an instance
        int id2 = response.jsonPath().getInt("products[0].id");
        System.out.println(id1);
        System.out.println(id2);

        // get first product name
        String productName1 = jsonPath.getString("products[0].name");
        System.out.println(productName1);

        // get number of products
        int totalProducts = jsonPath.getList("products").size();
        System.out.println(totalProducts);




        response.prettyPrint();
    }

}
