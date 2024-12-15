package gorestApiTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteUser {
	@Test
	public void deleteUser() {
		String id="3387657";
		String url="https://gorest.co.in/public/v1/users/";
		
		Response response=RestAssured.given()
											.header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
										.when()
											.delete(url+id);
		int statusCode=response.getStatusCode();
		assertEquals(statusCode,204);
		System.out.println(statusCode);
		
				
	}
}
