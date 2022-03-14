package org.trianz.eagleaccess.utils.Sql;

import java.sql.Statement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class getDBHelper extends sqlConnHelper{
    public static Map<String,String> empDetails;
    public static Map<String,String> getDBEmpDetails(String empId) throws SQLException {
        String query = "select id,email,first_name,last_name,avatar from EmployeeInfo where id=" + (char) 39 + empId + (char) 39;
        System.out.println(query);
        connectDb();
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        while (rs.next()) {
            empDetails = new HashMap<String,String>();
            empDetails.put("id", rs.getString(1));
            empDetails.put("email", rs.getString(2));
            empDetails.put("first_name", rs.getString(3));
            empDetails.put("last_name", rs.getString(4));
            empDetails.put("avatar", rs.getString(5));
        }
        System.out.println("The emp details from DB is (inside getDBHelper class): " + empDetails);
        closeDb();
        return empDetails;
    }
}
