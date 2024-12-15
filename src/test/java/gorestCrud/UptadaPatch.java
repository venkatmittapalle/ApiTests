package gorestCrud;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UptadaPatch {
	
	@Test
	public void uptadatePath() {
		String url="https://gorest.co.in/public/v1/users/3067995";
		String requestData="{\n"
				+ "        \"name\": \"Seloo Ejder\"\n"
				+ "}";
		Response response= given()
								.contentType(ContentType.JSON)
								.header("Authorization","Bearer a73a75c54b75d9eed785a0546edf621dd893fe64643aa61b86d73512ab5eb505")
								.body(requestData)
							.when()	
							  .patch(url);
		response.prettyPrint();
	}

}
