package com.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

    /*
     * Temporary Solution:
     * This test only checks the status code of a GET request.
     * In the future, we will validate the full response body, handle edge cases, and include error scenarios.
     */
    @Test
    public void testGetRequest() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.getBody());
        Assert.assertTrue(response.getBody().asString().contains("userId"));
    }

    /*
     * Fetch all posts and validate list is not empty
     */
    @Test
    public void testAllPosts() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().jsonPath().getList("$").size() > 0);
    }

    /*
     * Technical Documentation:
     * This endpoint occasionally fails under heavy load.
     * No immediate refactoring planned; documented for future optimization.
     */
    @Test
    public void testPostRequest() {
        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
                .post("https://jsonplaceholder.typicode.com/posts");

        Assert.assertEquals(response.getStatusCode(), 201);
    }

    /*
     * Technical Debt:
     * This POST test lacks detailed validation and error handling.
     * Future improvements:
     * - Validate all fields in response
     * - Add error scenario tests
     * - Data-driven inputs
     */
    
    public void problematicMethod() {
        // Known issue: High cyclomatic complexity
        // TODO: Refactor into smaller helper methods in future
    }
}
