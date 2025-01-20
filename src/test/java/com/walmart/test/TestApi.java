package com.walmart.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.walmart.mockDB.MockDB;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class TestApi {

    private static final String BASE_URL = "https://gorest.co.in/public/v2/users";

    private Response response;

    private final Random random = new Random();

    @BeforeTest
    public void setUp() throws JsonProcessingException {
        MockDB.initialize();
        //Please do not change anything from Mock DB
    }

    @Test(priority = 2)
    public void getUserList() {
        /*Create GET Method for below URL using RestAssured.
         Does not requried header
         Validate the Status code
         Validate the API response body with MockDB Class Attributes using 'For Loop' within TestNG Assertions
         Hint: You can fetch Api response as jsonPath and store them in to List */

        response = given().get(BASE_URL);

        // Validate the Status code
        Assert.assertEquals(response.getStatusCode(), 200, "Wasn't able to successfully process the GET request");

        // Hint: You can fetch Api response as jsonPath and store them in to List
        List<Map<String, Object>> list = response.jsonPath().get("$");

        for (int i = 0; i < list.size(); i++) {
            // Validate the API response body with MockDB Class Attributes using 'For Loop' within TestNG Assertions
            Assert.assertEquals(list.get(i).get("id"), MockDB.ids.get(i), "ID doesn't match");
            Assert.assertEquals(list.get(i).get("name"), MockDB.names.get(i), "Name doesn't match");
            Assert.assertEquals(list.get(i).get("email"), MockDB.emails.get(i), "Email doesn't match");
            Assert.assertEquals(list.get(i).get("gender"), MockDB.genders.get(i), "Gender doesn't match");
            Assert.assertEquals(list.get(i).get("status"), MockDB.statuses.get(i), "Status doesn't match");
        }
        System.out.println("--------------Completed GET request------------------------");
    }

    @Test(priority = 1)
    public void createUserList() {
     /*
     Create POST Method using below URL
     Create requestBody using MAP(key-value) for name,email,gender,status(Active-Inactive)
     pass Header as : .header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
     validate the HTTP status Code using Assertions
     Print the Response body
      */

        // Create a Map for name,email,gender,status(Active-Inactive)
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Venkat Mittapalle");
        requestBody.put("email", "vm"+random.nextInt(1000)+"@gmail.com"); //API requires distinct email ID while creating a user record.
        requestBody.put("gender", "male");
        requestBody.put("status", "Active");

        response = given().headers(getHeaders()).body(requestBody).post(BASE_URL);

        // validate the HTTP status Code using Assertions
        Assert.assertEquals(response.getStatusCode(), 201, "Response status code doesn't match for creating a user");

        // Print the Response body
        response.prettyPrint();
        System.out.println("--------------Completed POST request------------------------");
    }

    @Test(priority = 3)
    public void uptadeUser() {
     /*
     Create PATCH Method using below URL to update user details
     Create requestBody using MAP(key-value) for name,email,gender,status
     pass Header as : .header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
     validate the only HTTP status Code using Assertion
     For id Parameter you can fetch a random id from Mock DB(List<Integer> ids)
      */
//        String urlPATCH = "https://gorest.co.in/public/v2/users/{id}";

        // Create requestBody using MAP(key-value) for name,email,gender,status
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Venkat Mittapalle");
        requestBody.put("email", "vm"+random.nextInt(1000)+"@gmail.com");
        requestBody.put("gender", "male");
        requestBody.put("status", "Active");

        // For id Parameter you can fetch a random id from Mock DB(List<Integer> ids)
        int integer = random.nextInt(MockDB.ids.size());

        response = given().headers(getHeaders()).body(requestBody).patch(BASE_URL + "/" + MockDB.ids.get(integer));

        // Validate the only HTTP status Code using Assertion
        Assert.assertEquals(response.getStatusCode(), 200, "Response status code doesn't match for updating the user details");

        System.out.println("--------------Completed PATCH request------------------------");
    }

    @Test(priority = 4)
    public void deleteUser() {
     /*
     Create DELETE Method using below URL to delete user and verify with GET method if user is deleted
     pass Header as : .header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
     validate the only HTTP status Code using Assertion
     For id Parameter you can fetch a random id from Mock DB(List<Integer> ids)
      */
//        String urlDELETE = "https://gorest.co.in/public/v2/users/{id}";

        // For id Parameter you can fetch a random id from Mock DB(List<Integer> ids)
        int idToBeDeleted = random.nextInt(MockDB.ids.size());

        response = given().headers(getHeaders()).delete(BASE_URL + "/" + MockDB.ids.get(idToBeDeleted));

        // validate the only HTTP status Code using Assertion
        Assert.assertEquals(response.getStatusCode(), 204, "Wasn't able to delete the User");

        // Verify with GET method if user is deleted
        List<Integer> listOfIDs = given().get(BASE_URL).jsonPath().get("id");
        Assert.assertFalse(listOfIDs.contains(idToBeDeleted), "ID hasn't been deleted successfully");

        System.out.println("--------------Completed POST request------------------------");
    }

    private static Map<String, Object> getHeaders() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505");
        return headers;
    }
}