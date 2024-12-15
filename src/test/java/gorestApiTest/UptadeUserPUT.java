package gorestApiTest;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloadBuilder.GorestRequestBuilder;
import static io.restassured.RestAssured.given;
public class UptadeUserPUT {
	@Test
	public void uptadeUser() {
		String id="3387423";
		String url="https://gorest.co.in/public/v1/users/";
		
		//create request payload for update user
		GorestRequestBuilder reqBuilder=new GorestRequestBuilder();
		reqBuilder.setName("Selahattin Ejder");
		reqBuilder.setEmail("selahattinejder1553@gmail.com");
		reqBuilder.setGender("male");
		reqBuilder.setStatus("active");
		//submit put request
		Response response=given()
			
				.header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
				.contentType(ContentType.JSON)
				.body(reqBuilder)
		           .when()
		     		.put(url+id);
		response.prettyPrint();
	}
}
