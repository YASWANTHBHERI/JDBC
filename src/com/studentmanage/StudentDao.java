package com.studentmanage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

    public static boolean insertIntoDB(Student st){
        boolean f = false;
        try{
            Connection con = ConnectionProvider.createCon();
            String q = "insert into students(sname,scity,sphone) values(?,?,?)";
            PreparedStatement pstmt =  con.prepareStatement(q);
            pstmt.setString(1,st.getSname());
            pstmt.setString(2,st.getScity());
            pstmt.setString(3,st.getSphone());

            pstmt.executeUpdate();
            f = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static boolean deleteStudent(int sid){
        boolean f = false;
        try{
            Connection con = ConnectionProvider.createCon();
            String q = "delete from students where sid=?";
            PreparedStatement ptmt = con.prepareStatement(q);
            ptmt.setInt(1,sid);
            ptmt.executeUpdate();
            f = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static void showAllStudents(){
        try{
            Connection con = ConnectionProvider.createCon();
            String q = "select * from students";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            while (set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);
                String phone = set.getString("sphone");

                System.out.println(id+" "+name+" "+city+" "+phone);
                System.out.println("-------------------------------------------------");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
