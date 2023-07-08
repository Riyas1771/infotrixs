package empapp;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection con;
    public static Connection createDBConnetion() {
   	 
       try{
    	//return DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get connection
            String url="jdbc:mysql://localhost:3306/emp";
            String username="root";
            String password="root";
           con= DriverManager.getConnection(url,username,password);

        }catch (Exception ex){
            ex.printStackTrace();
        }
     return con;

    }
}
