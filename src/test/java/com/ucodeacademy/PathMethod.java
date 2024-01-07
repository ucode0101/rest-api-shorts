package com.ucodeacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PathMethod {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";
    }

    @Test
    public void getAllProducts() {
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/products");

        // verify status code is 200
        response.then().statusCode(200);

        //response.prettyPrint();

        int productId = response.body().path("products[0].id");
        String productName = response.body().path("products[0].name");

        System.out.println("Product id: "+ productId);
        System.out.println("Product name: "+productName);

        int totalProducts = response.body().path("products.size()");
        System.out.println("Total products: "+ totalProducts);

        System.out.println("=======================================");

        // loop through response body and print each id and name
        for (int i=0; i< totalProducts; i++){
            int eachID = response.path("products["+i+"].id");
            String eachName = response.path("products["+i+"].name");
            System.out.println("Each ID: "+ eachID);
            System.out.println("Each name: "+ eachName);
        }




    }
    @Test
    public void getAllProducts2(){
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/products");

        // verify status code
        response.then().assertThat().statusCode(200);

        //response.prettyPrint();

        // store all IDs in List
        List<Integer> allIds = response.body().path("products.id");

        // store all names in List
        List<String> allNames = response.body().path("products.name");

        // store all products in List of Maps
        List<Map<String, Object>> allProducts = response.path("products");

        System.out.println("List of IDs: "+allIds);
        System.out.println("List of names: "+ allNames);
        System.out.println("List of products maps: "+allProducts);



    }
}
