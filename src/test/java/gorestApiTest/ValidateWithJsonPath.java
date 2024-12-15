package gorestApiTest;

import org.junit.Test;

import com.jayway.jsonpath.JsonPath;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.List;

import io.restassured.response.Response;

public class ValidateWithJsonPath {
	@Test
	public void validateGender() {
		String url="https://gorest.co.in/public/v1/users";
		Response response =given()
								.param("gender", "female")
							.when()
								.get(url);
//		response.prettyPrint();
		List<String> gender=JsonPath.read(response.asString(),"$.data[*].gender");
//		System.out.println(gender);
		for(String eacValue:gender) {
			assertEquals("female",eacValue);
		}
		
	}

}
