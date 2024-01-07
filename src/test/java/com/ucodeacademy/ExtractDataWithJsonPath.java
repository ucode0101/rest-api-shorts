package com.ucodeacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class ExtractDataWithJsonPath {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";
    }

    @Test
    public void getAllProducts(){
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/products");

        Assert.assertEquals(200, response.getStatusCode());
        response.then().assertThat().statusCode(200);

        JsonPath jsonPath= response.jsonPath();

       // response.prettyPrint();

        // get all product ids as list
        List<Integer> allIds = jsonPath.getList("products.id");

        // get all product names as list
        List<String> allNames = jsonPath.getList("products.name");

        // get all products as list of maps
        List<Map<String, Object >> listOfMaps = jsonPath.getList("products");

        System.out.println(allIds);
        System.out.println(allNames);
        System.out.println(listOfMaps);

        System.out.println("==========================");

        response.prettyPrint();
    }

}
