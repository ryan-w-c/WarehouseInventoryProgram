package DBLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    static String DBNAME;
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static String DB_URL = "jdbc:derby://localhost:1527/cecs323jdbc";
    static Connection conn;
    
    public void openConnection(){
        try{
            DriverManager.getConnection(DB_URL);
        }
        catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void closeConnection(){
        try{
            conn.close();
        }
        catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}
