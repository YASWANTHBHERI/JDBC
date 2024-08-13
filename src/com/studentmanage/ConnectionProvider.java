package com.studentmanage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    static Connection con;
    public static Connection createCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String user = "root";
            String password = "Yaswanth@1216";
            String url = "jdbc:mysql://localhost:3306/student_db";
            con = DriverManager.getConnection(url,user,password);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return con;
    }
}
