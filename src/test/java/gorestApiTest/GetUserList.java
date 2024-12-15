package gorestApiTest;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetUserList {

	public static void main(String[] args) {
			
		String url="https://gorest.co.in/public/v1/users";
		
		
		//if you dont import given method you have tou user RestAssured.given class
//		Response response=RestAssured.given().when().get(url);
		Response response=given()
								.param("gender", "female")
								.param("status","inactive")
							.when()
							.get(url);
		
		 
		response.prettyPrint();
		
		//retrieve element value from response json data
		int total=response.then().extract().path("meta.pagination.total");
		System.out.println(total);
		
		
		//contentType--> validate response data format
//		response.then().contentType("application/json");	
//		response.then().contentType(ContentType.JSON);
		
		
		//Validation  status code and assert it
//		response.then().statusCode(200);
		
		//get status code
//		int statusCode=response.getStatusCode();
//		System.out.println(statusCode);
		

		
		
		
		//print response and convert it to String
//		String strResp=response.prettyPrint();
		
		//convert response to pretty String
//		String strResp2=response.asPrettyString();
//		System.out.println(strResp);

		//Convert response to  String  in one single line
//		String strResp3=response.asString();
//		System.out.println(strResp3);
		
		
		//then--->  method is user to for response validation
		
	 
		
	}

}
