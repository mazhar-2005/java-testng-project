package org.trianz.eagleaccess.utils.Sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlConnHelper
{
    public static Connection conn;
    public static ResultSet rs;
    public static void connectDb()
    {
        try
        {
          String url = "jdbc:sqlite:C:\\Users\\MazharAhmad.Khan\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db";
          conn = DriverManager.getConnection(url);
          System.out.println("The connection established!");
        }catch(SQLException e)
        {
          System.out.println("Error during connection: "+e.getMessage());
        }
    }
    public static void closeDb() throws SQLException
    {
            conn.close();
            System.out.println("Connection closed!");
    }

}
