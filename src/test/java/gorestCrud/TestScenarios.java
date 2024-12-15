package gorestCrud;

import org.junit.*;

import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
public class TestScenarios {
	@Test @Ignore
	public void validateGender() {
		String url="https://gorest.co.in/public/v1/users";
		//submit GET request to retrieve female user
		Response response=given()
								.param("gender","female")
							.when().get(url);
		response.prettyPrint();
		List <String> genderList=JsonPath.read(response.asString(),"$.data[*].gender");
		System.out.println(genderList);
		for(String each:genderList) {
			assertEquals("female",each);
		
		}	
	}
	//Validate Status	
	@Test @Ignore
	public void  validateStatus() {
		String url="https://gorest.co.in/public/v1/users";
		Response response=given()
								.param("status","active")
							.when()
								.get(url);
		String strResponse=response.prettyPrint();
		List <String> statusList=JsonPath.read(strResponse,"$.data[*].status");
		for(String each:statusList) {
			assertEquals("active",each);
			
		}
		
	}
	//3,validate user count
	@Test @Ignore
	public void validateUserCount()
	{
		//submit GET request
		String url="https://gorest.co.in/public/v1/users";
		Response response=given().when().get(url);
		response.prettyPrint();
		List<String> userList=JsonPath.read(response.asString(),"$.data[*]");
		System.out.println(userList);
		
		//Count of the List-->size()
		System.out.println(userList.size());
		//validate count of user
		assertEquals(10,userList.size());
		
		 }
	//4.validate total active female user
	 @Test 
	public void validateTotalFemaleUsers()
	{
		String url="https://gorest.co.in/public/v1/users";
//submit GET request to GorestAPI to get total of number of active female user
		Response response=given()	
								.param("gender","female")
								.param("status","active")
							.when()
								.get(url);
		String strResponse=response.prettyPrint();
		int totalFemaleUser=JsonPath.read(strResponse, "$.meta.pagination.total");
		System.out.println(totalFemaleUser);
		
	String usertName=JsonPath.read(strResponse,"$.data[0].name");
	System.out.println(usertName);
	
	//get 1st user
	JsonPath.read(strResponse,"$.data[0].*");
	Map <String,Object> firstUserMap=JsonPath.read(strResponse,"$.data[0]");
	System.out.println(firstUserMap);
	
	//get all users information
	List<Map <String,Object>> allUser=JsonPath.read(strResponse,"$.data[*]");
	
	for(Map <String,Object> map:allUser) {
		System.out.println(map);
		
	}
	//validate all gender with JsonPath
	List<String> allGender=JsonPath.read(strResponse,"$.data[*].gender");
	System.out.println(allGender);
  
		
	 }}

