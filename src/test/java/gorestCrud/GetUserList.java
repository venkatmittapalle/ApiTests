package gorestCrud;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import mockDB.MockDB;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUserList {
    @BeforeTest
    public static void setUp() throws JsonProcessingException {
        MockDB.initialize();
    }


    @Test
    public void getUserList() {
        //Create GET endpoint for below URL using RestAssured.
        // 1.Validate Status code
        //validate the API response body with MockDB Class using for loop within TestNG Assertion
        //Hint: You can fetch Api response as jsonPath and store them in the List

        String urlGET = "https://gorest.co.in/public/v2/users";



        Response response = RestAssured.given()
                .when()
                .get(urlGET)
                .then()
                .statusCode(200)
                .extract().response();
        List<Integer> actualIds = response.jsonPath().getList("id");
        List<String> actualNames = response.jsonPath().getList("name");
        List<String> actualEmails = response.jsonPath().getList("email");
        List<String> actualGenders = response.jsonPath().getList("gender");
        List<String> actualStatuses = response.jsonPath().getList("status");

        if (MockDB.ids.size() == actualIds.size()) {
            for (int i = 0; i < MockDB.ids.size(); i++) {
                Assert.assertEquals("Id does not match", MockDB.ids.get(i), actualIds.get(i));
                Assert.assertEquals("name does not match", MockDB.names.get(i), actualNames.get(i));
                Assert.assertEquals("email does not match", MockDB.emails.get(i), actualEmails.get(i));
                Assert.assertEquals("gender does not match", MockDB.genders.get(i), actualGenders.get(i));
                Assert.assertEquals("status does not match", MockDB.statuses.get(i), actualStatuses.get(i));
            }
        }

    }

    @Test
    public void createUserList() {

     /*
     Create POST endpoint using below URL
     Create requestBody using MAP(key-value) for name,email,gender,status
     pass Header as : .header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
     validate the only HTTP status Code using Assertions
      */

        String urlPOST = "https://gorest.co.in/public/v1/users";

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Selahattin Ejder");
        requestBody.put("email", "ejd3wqe4@gmail.com");
        requestBody.put("gender", "Male");
        requestBody.put("status", "Active");

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
                .body(requestBody)
                .when().post(urlPOST)
                .then()
                .extract().response();

        //validate status code
        assertEquals(201, response.getStatusCode());
    }

    @Test
    public void uptadeUser() {
     /*
     Create PATCH endpoint using below URL to update user details
     Create requestBody using MAP(key-value) for name,email,gender,status
     pass Header as : .header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
     validate the only HTTP status Code using Assertion
      */

        String url = "https://gorest.co.in/public/v1/users/7584914";

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Selahattin Ejder");
        requestBody.put("email", "ejer3212334@gmail.com");
        requestBody.put("gender", "Male");
        requestBody.put("status", "Active");

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
                .body(requestBody)
                .when()
                .put(url);
        assertEquals(200, response.getStatusCode());

    }
}
