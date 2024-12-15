package gorestCrud;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UptadeUser {
	@Test
	public void uptadeUser() {
		String url="https://gorest.co.in/public/v1/users/3067995";
		String requestData="{\n"
				+ "        \"name\": \"Selahattin Ejder\",\n"
				+ "        \"email\": \"Selahattinejder5@gmail.com\"\n"
				+ "        \"gender\": \"male\",\n"
				+ "        \"status\": \"inactive\"\n"
				+ "    }\n"
				+ "}";
		Response response= given()
							.contentType(ContentType.JSON)
							.header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
					     	 .body(requestData)
					     .when()
					     	.put(url);
		response.prettyPrint();
		System.out.println(response.getStatusCode() );
							
	}



}
