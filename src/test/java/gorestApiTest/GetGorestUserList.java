package gorestApiTest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


import org.junit.Test;

import io.restassured.response.Response;

public class GetGorestUserList {
	
	String url="https://gorest.co.in/public/v1/users";

	@Test
	public void getFemaleusers() {

	Response response=given()
					.param("gender", "female")
					.param("status","inactive")
				.when()
					.get(url);
	
	response.prettyPrint();
	assertEquals(200,response.getStatusCode());
	
	assertNotNull(response);
	
	}
}
