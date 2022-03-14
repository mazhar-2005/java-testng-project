package org.trianz.eagleaccess.tests.get;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import  io.restassured.response.Response;
import  io.restassured.http.ContentType;
import java.util.Map;

public class getWhetherInfo
{
    @Test(description = "Verify the status code", enabled = true, dataProvider = "cityData")
    public void getStatusCode(String city) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://demoqa.com/utilities/weather/city/" + city)
                .then()
                .extract().response();
        System.out.println("Response is :" + response.asString());
        //System.out.println("Response path : "+response.path("City"));
        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test(description = "Verify the Temp", enabled = true, dataProvider = "cityTemp"/*,priority = 0*/,dependsOnMethods="getStatusCode")
    public void getCityTemp(String city,String temp) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://demoqa.com/utilities/weather/city/" + city)
                .then()
                .extract().response();
        System.out.println("Response is :" + response.asString());
        System.out.println("Temp from data provider is : "+temp);
        Map<Object,Object> test = response.jsonPath().getMap("");
        System.out.println("Response from Map : "+test);
        System.out.println("City info from Map : "+test.get("City"));
        //assertThat(response.statusCode()).isEqualTo(200);
    }

    @DataProvider
    private static Object[][] cityData() {
        Object[][] data = new Object[][]{new Object[]{"Chennai"}, new Object[]{"Mumbai"}, new Object[]{"Hyderabad"}};
        return data;
    }
    @DataProvider
    private static Object[][] cityTemp() {
        Object[][] data = new Object[][]{new Object[]{"Chennai","88 Degree celsius"}, new Object[]{"Mumbai","109 Degree celsius"}, new Object[]{"Hyderabad","50 Degree celsius"}};
        return data;
    }

}