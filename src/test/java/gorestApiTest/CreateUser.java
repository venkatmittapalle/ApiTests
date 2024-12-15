package gorestApiTest;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class CreateUser {


		@Test
		public void createUser() {
		//POST method is used to create new record
		//body()--> method is used to send reqiesr data (json,xml,etc.)
		//it can be used in POST ,PUT,PATCH request
		//contentTYpe(>>> is used to specify the format of the equest data we submit in body() method
		//Where we use body() method , we should aslo use contentType() method
		
	
		String url="https://gorest.co.in/public/v1/users";
		String payload="{\n"
				+ "    \"name\": \"Selahattin Ejder\",\n"
				+ "    \"email\": \"Selahattinejder0@gmail.com\",\n"
				+ "    \"gender\": \"male\",\n"
				+ "    \"status\": \"active\"\n"
				+ "}";
		Response response=given()
//								.header("Content-Type","application/json")
//								.contentType("application/json")
								.contentType(ContentType.JSON)
								.header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
								.body(payload)
						   .when()
								.post(url);
		
		response.prettyPrint();

		}
}
