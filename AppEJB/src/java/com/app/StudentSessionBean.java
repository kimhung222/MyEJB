/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import javax.ejb.Stateless;
import appclient.Students;
import java.util.*;
import javax.ejb.*;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Admin
 */
@Stateless
public class StudentSessionBean implements StudentSessionBeanRemote {
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Students> findAll() {
        List<Students> student_list;
        ResultSet rs;
        student_list = new ArrayList<Students>();
        try(java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","")){
        System.out.println("Database connected!");
        Statement stmt = null;
        String query ="SELECT * FROM students";
        stmt = connection.createStatement();
        rs = stmt.executeQuery(query);
        while(rs.next()){
            Students s = new Students();
            s.setId(rs.getInt(1));
            s.setName(rs.getString(2));
            s.setSid(rs.getInt(3));
            s.setClasss(rs.getString(4));
            s.setFaculty(rs.getString(5));
            s.setImage(rs.getString(7));
            s.setEmail(rs.getString(8));
            s.setPoint(rs.getFloat(9));
            student_list.add(s);
   
        }
        
        } catch (SQLException e){
            
        }

        return student_list;
    }
//CURRENT_TIMESTAMP
        public List<Students> add(Students new_s) {
        List<Students> student_list;
        ResultSet rs;
        student_list = new ArrayList<Students>();
        try(java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","")){
        System.out.println("Database connected!");
        Statement stmt = null;
        String query ="INSERT INTO students(id,name,sid,classs,faculty,last_update,image,email,point)"+
                      " VALUES("+"\'"+new_s.getId()+"\'"+
                                ",\'"+new_s.getName()+"\'"+
                                ",\'"+new_s.getSid()+"\'"+
                                ",\'"+new_s.getClasss()+"\'"+
                                ",\'"+new_s.getFaculty()+"\'"+
                                   ",CURRENT_TIMESTAMP"+
                                ",\'"+new_s.getImage()+"\'"+
                                ",\'"+new_s.getEmail()+"\'"+
                                ",\'"+new_s.getPoint()+"\'"+                
                    ")";
        stmt = connection.createStatement();
        rs = stmt.executeQuery(query);
        String query2 ="SELECT * FROM students";
        rs = stmt.executeQuery(query2);
        while(rs.next()){
            Students s = new Students();
            s.setId(rs.getInt(1));
            s.setName(rs.getString(2));
            s.setSid(rs.getInt(3));
            s.setClasss(rs.getString(4));
            s.setFaculty(rs.getString(5));
            s.setImage(rs.getString(7));
            s.setEmail(rs.getString(8));
            s.setPoint(rs.getFloat(9));
            student_list.add(s);
   
        }
        
        } catch (SQLException e){
            
        }
        return student_list;
    }
//        UPDATE Customers
//SET ContactName='Alfred Schmidt', City='Frankfurt'
//WHERE CustomerID=1;
        
    public List<Students> edit(Students new_s) {
        List<Students> student_list;
        ResultSet rs;
        student_list = new ArrayList<Students>();
        try(java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","")){
        System.out.println("Database connected!");
        Statement stmt = null;
        stmt = connection.createStatement();
        String query ="UPDATE students"+
                "SET"+
                " name = "+ new_s.getName() +
                " sid  = "+ new_s.getSid()+
                " classs  ="+ new_s.getClasss()+
                " falcuty  ="+ new_s.getFaculty()+
                " last_update ="+ "CURRENT_TIMESTAMP"+
                " image = "+ new_s.getImage() +
                " email = "+ new_s.getEmail() +
                " point = "+ new_s.getPoint() +
                "WHERE id = "+ "\'"+new_s.getId()+"\'";
 
        rs = stmt.executeQuery(query);
        String query2 ="SELECT * FROM students";
        rs = stmt.executeQuery(query2);
        while(rs.next()){
            Students s = new Students();
            s.setId(rs.getInt(1));
            s.setName(rs.getString(2));
            s.setSid(rs.getInt(3));
            s.setClasss(rs.getString(4));
            s.setFaculty(rs.getString(5));
            s.setImage(rs.getString(7));
            s.setEmail(rs.getString(8));
            s.setPoint(rs.getFloat(9));
            student_list.add(s);  
        }
        
        } catch (SQLException e){
            
        }

        return student_list;
    }
    //DELETE FROM table_name
    //WHERE some_column=some_value;

        public List<Students> delete(Integer id) {
        List<Students> student_list;
        ResultSet rs;
        student_list = new ArrayList<Students>();
        try(java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","")){
        System.out.println("Database connected!");
        Statement stmt = null;
        stmt = connection.createStatement();
        String query ="DELETE FROM studens WHERE id = " +"\'"+id+"\'";
        rs = stmt.executeQuery(query);
        String query2 ="SELECT * FROM students";
        rs = stmt.executeQuery(query2);
        while(rs.next()){
            Students s = new Students();
            s.setId(rs.getInt(1));
            s.setName(rs.getString(2));
            s.setSid(rs.getInt(3));
            s.setClasss(rs.getString(4));
            s.setFaculty(rs.getString(5));
            s.setImage(rs.getString(7));
            s.setEmail(rs.getString(8));
            s.setPoint(rs.getFloat(9));
            student_list.add(s);
   
        }
        
        } catch (SQLException e){
            
        }

        return student_list;
    }

    

}
