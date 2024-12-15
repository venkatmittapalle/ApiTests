package gorestCrud;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class DeleteUser {
	
	@Test
	public void deleteUser() {
		String url="https://gorest.co.in/public/v1/users/7582442";
		Response response=given()
				               .header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
				              .when()
				                .delete(url);
		int statusCode=response.getStatusCode();
		System.out.println(statusCode);
		response.prettyPrint();
		
	}

}
