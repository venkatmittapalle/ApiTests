package mockDB;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MockDB {

    public static List<Integer> ids = new ArrayList<>();
    public static List<String> names = new ArrayList<>();
    public static List<String> emails = new ArrayList<>();
    public static List<String> genders = new ArrayList<>();
    public static List<String> statuses = new ArrayList<>();

    public static void initialize() throws JsonProcessingException {
        String url = "https://gorest.co.in/public/v2/users";

        Response response = RestAssured.given()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().response();
        ObjectMapper mapper =new ObjectMapper();
        List<Map<String,Object>> data =mapper.readValue(response.asString(),new TypeReference<List<Map<String,Object>>>() {});

        ids.clear();
        names.clear();
        emails.clear();
        emails.clear();
        genders.clear();
        statuses.clear();

        for(Map<String,Object> user: data){
            Integer id= (Integer) user.get("id");
            String name= (String) user.get("name");
            String email= (String) user.get("email");
            String gender= (String) user.get("gender");
            String status= (String) user.get("status");
            ids.add(id);
            names.add(name);
            emails.add(email);
            genders.add(gender);
            statuses.add(status);
        }
    }
}

