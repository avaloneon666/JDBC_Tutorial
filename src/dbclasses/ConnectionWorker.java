package dbclasses;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionWorker {
    public static Connection getConnection(){
        Connection connection = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL="jdbc:mysql://localhost:3306/pomonatransitsystem";
            String dbUser="root";
            String dbPass="";
            connection = DriverManager.getConnection(dbURL,dbUser,dbPass);

        }
        catch ( Exception error)
        {
            error.printStackTrace();


        }


        return connection;
    }



}
