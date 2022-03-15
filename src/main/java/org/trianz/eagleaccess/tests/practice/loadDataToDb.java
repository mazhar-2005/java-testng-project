package org.trianz.eagleaccess.tests.practice;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.trianz.eagleaccess.utils.Sql.sqlConnHelper;

import java.sql.Statement;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class loadDataToDb extends sqlConnHelper
{
  public static void main(String args []) throws Exception
   {
        System.out.println("loadDataToDb begins!");
        connectDb();
        String dropTable = "DROP TABLE EmployeeInfo";
        String createTable="CREATE TABLE EmployeeInfo "+
                               "(id VARCHAR(255) not NULL, "+
                               " email VARCHAR(255), "+
                               " first_name VARCHAR(255), "+
                               " last_name VARCHAR(255), "+
                               " avatar VARCHAR(255), "+
                               " page VARCHAR(255), "+
                               " PRIMARY KEY (id))";
       Statement stmt = conn.createStatement();
       try
       {
           stmt.executeUpdate(dropTable);

       }catch(Exception e)
       {
           System.out.println("Table does not exists");
       }
       stmt.executeUpdate(createTable);
       for(int i=1;i<=2;i++) {
           List<Map> restdataValues = getRestResponse(String.valueOf(i));
           for(Map map:restdataValues) {
               String InsertSql = "INSERT INTO EmployeeInfo VALUES("+map.get("id")+","+(char)34+map.get("email")+(char)34+","+(char)34+map.get("first_name")+(char)34+","+(char)34+map.get("last_name")+(char)34+","+(char)34+map.get("avatar")+(char)34+","+i+")";
               stmt.executeUpdate(InsertSql);
           }
           System.out.println("Inserted!");
           //System.out.println("After returned: "+restdataValues);
           }
       closeDb();
       }

   public static List<Map> getRestResponse(String pageNo)
         {
             Response response =  given()
             .contentType(ContentType.JSON)
             .when()
             .get("https://reqres.in/api/users?page="+pageNo)
             .then()
             .extract().response();
             JsonPath jp = new JsonPath(response.asString());
              List<Map> APIdatavalues = jp.getList("data");
              System.out.println("From getRestResponse()"+APIdatavalues);
              return APIdatavalues;
         }
}
