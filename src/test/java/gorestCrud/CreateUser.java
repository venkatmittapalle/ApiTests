package gorestCrud;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
 
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateUser {
	@Test
	public void createNewUSer() {
		String url="https://gorest.co.in/public/v1/users";
		String requesData="{\n"
				+ "    \"name\": \"Selahattin Ejder\",\n"
				+ "    \"email\": \"Selahattinejer1@gmail.com\",\n"
				+ "    \"gender\": \"male\",\n"
				+ "    \"status\": \"active\"\n"
				+ "}";
		Response response =given()
								.body(requesData)
								.header("Content-Type","application/json")
//								contentType(ContentType.JSON)
								.header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
								.when().post(url);
		
		//validate status code
		assertEquals(201,response.getStatusCode());
//		response.then().statusCode(201);

		
		//1.prettyPrint()-->prints response data and converts it to String
		response.prettyPrint();
		
		//2.asString --> converts response to String
		String strResponse=response.asString();
	
		
		//3.asPrettyString()-->converts response to String  prints in readable format
		String strResponse1=response.asPrettyString();
		System.out.println(strResponse1);
		
	}

}
