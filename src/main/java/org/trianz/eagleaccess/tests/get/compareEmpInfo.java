package org.trianz.eagleaccess.tests.get;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.trianz.eagleaccess.utils.Helper.testHelper;
import org.trianz.eagleaccess.utils.Rest.restGetHelper;
import org.trianz.eagleaccess.utils.Sql.getDBHelper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class compareEmpInfo<data> {

    @Test(description = "Verify if the data matches between DB and REST", enabled = true,dataProvider  ="empInfo")
    public static void compareEmpInfo(String id) throws SQLException {
        Map<Object, Object> empDetailsREST = restGetHelper.getRestEmpDetails(id, "data");
        Map<String, String> empDetailsDB = getDBHelper.getDBEmpDetails(id);
        Assertions.assertThat(testHelper.compareMaps(empDetailsREST, empDetailsDB)).as("Comparing Emp Info").isEqualTo("equal");
        //Assertions.assertThat("equal").isEqualTo("equal");
    }

@DataProvider
    private static Object[][] empInfo(){
        Object[][] data = new Object[][]{
                new Object[]{"1"},
                new Object[]{"2"},
                new Object[]{"3"},
                new Object[]{"4"},
                new Object[]{"5"},
                new Object[]{"6"},
                new Object[]{"7"}
        };
        return data;
    }
}