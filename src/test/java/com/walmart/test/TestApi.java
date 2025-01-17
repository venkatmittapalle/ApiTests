package com.walmart.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.walmart.mockDB.MockDB;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestApi {
    @BeforeTest
    public void setUp() throws JsonProcessingException {
        MockDB.initialize();
        //Please do not change anything from Mock DB
    }


    @Test
    public void getUserList() {
        /*Create GET Method for below URL using RestAssured.
         Does not requried header 
         Validate the Status code
         Validate the API response body with MockDB Class Attributes using 'For Loop' within TestNG Assertions
         Hint: You can fetch Api response as jsonPath and store them in to List */
      String urlGET = "https://gorest.co.in/public/v2/users";
        


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
        String urlPOST = "https://gorest.co.in/public/v2/users";



    }

    @Test
    public void uptadeUser() {
     /*
     Create PATCH Method using below URL to update user details
     Create requestBody using MAP(key-value) for name,email,gender,status
     pass Header as : .header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
     validate the only HTTP status Code using Assertion
     For id Parameter you can fetch a random id from Mock DB(List<Integer> ids)
      */
        String urlPATCH = "https://gorest.co.in/public/v2/users/{id}";



    }

    @Test
    public void deleteUser() {
     /*
     Create DELETE Method using below URL to delete user and verify with GET method if user is deleted
     pass Header as : .header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
     validate the only HTTP status Code using Assertion
     For id Parameter you can fetch a random id from Mock DB(List<Integer> ids)
      */
        String urlDELETE = "https://gorest.co.in/public/v2/users/{id}";




    }
}
