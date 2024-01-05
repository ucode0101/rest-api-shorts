package com.ucodeacademy;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequest {

    // Doesn't require token when sending request
    String baseUrl1 = "https://fruitshop2-predic8.azurewebsites.net/shop/v2";

    // Requires token when sending request
    String baseUrl2 = "https://thinking-tester-contact-list.herokuapp.com";


    String product = """
            
            {
                "name": "Super fruit 5",
                "price": 10.50
            }
             
            """;

    @Test
    public void sendPostRequest(){

        // Send POST request without Token

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(product)
                .when().post(baseUrl1 +"/products");

        // Verify status code
        Assert.assertEquals(201, response.getStatusCode());

        // Verify body contains product name
        Assert.assertTrue(response.body().asString().contains("Super fruit 5"));
        // print the body
        response.prettyPrint();


    }

}
