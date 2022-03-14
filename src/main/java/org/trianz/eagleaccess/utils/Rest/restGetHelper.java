package org.trianz.eagleaccess.utils.Rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class restGetHelper {
    public static Map getRestEmpDetails(String id,String node){
        Response response =  given()
        .contentType(ContentType.JSON)
        .when()
        .get("https://reqres.in/api/users/"+id)
        .then()
        .extract().response();
        Map<Object,Object> empDetails=response.jsonPath().getMap(node);
        System.out.println("The emp details from REST is (inside RestGetHelper class): "+empDetails);
        return empDetails;
    }
}
