package gorestCrud;

import com.fasterxml.jackson.core.JsonProcessingException;
import mockDB.MockDB;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Crud {
    @BeforeTest
    public static void setUp() throws JsonProcessingException {
        MockDB.initialize();
    }


    @Test
    public void getUserList() {
        /*Create GET Method for below URL using RestAssured.
         Validate Status code
         Validate the API response body with MockDB Class using 'For Loop' within TestNG Assertion
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
     Print the Response body and do assertion with input payload
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
     For d Parameter you can fetch a random id from Mock DB
      */

        String urlPATCH = "https://gorest.co.in/public/v2/users/{id}";


    }

    @Test
    public void deleteUser() {
     /*
     Create DELETE endpoint using below URL to delete user and verify if user is deleted within GET method
     pass Header as : .header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
     validate the only HTTP status Code using Assertion
     For id Parameter you can fetch a random id from Mock DB
      */
        String urlPATCH = "https://gorest.co.in/public/v2/users/{id}";



    }
}
