package gorestApiTest;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.asserts.SoftAssert;
import payloadBuilder.GorestRequestBuilder;

public class CreateUserBySerialization {

	//1. create POJO class under payloadBuilder folder
	//2.Create a user using Serialization
	//3.Submit POST request
	//4.Validate the status code
	//5.PrettyPrint the API response Body
	//5.Compare the request body and Response body using Junit Assertion (name,email,gender,status)
	@Test
	public void testSerialization() throws JsonProcessingException {	// Create payload by Serialization
	GorestRequestBuilder reqBuilder=new GorestRequestBuilder();
	reqBuilder.setName("Selahattin ejder");
	reqBuilder.setEmail("selahattin13@gmail.com");
	reqBuilder.setGender("male");
	reqBuilder.setStatus("active");

	
	//submit POST request
	String url="https://gorest.co.in/public/v1/users";

			Response response=given()

						.contentType(ContentType.JSON)
							.header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
							.body(reqBuilder)
							.when()
							.post(url);
		response.jsonPath().prettyPrint();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("ejder",response.jsonPath().get("data.name"));
	}
}
