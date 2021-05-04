package com.example.demojdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demojdbc {

    public static void main(String[] args) {

        Connection connection = ConnectJDBC.getConnection();

        String sqlSelect = "select StudentId, StudentName, ClassName from Student s, Classes c where s.ClassId = c.ClassId";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("Id: "+rs.getString("StudentId"));
                System.out.println("Name: "+rs.getString("StudentName"));
                System.out.println("Class: "+rs.getString("ClassName"));
            }
        }catch (SQLException e){
            System.out.println("Sai goi!!");
        }

        String className = "D17CQVT01-N";
        String studentName = "Nguyen Thanh Truc";

//        String sqlInsert = "insert into Classes values (?)";
        String sqlSelectClassName = "select ClassId from Classes where ClassName = ?";
        String sqlInsert = "insert into Student values (?,?)";
        try {

            PreparedStatement ps = connection.prepareStatement(sqlSelectClassName);
            ps.setString(1, className);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String classId = rs.getString("ClassId");
                PreparedStatement ps1 = connection.prepareStatement(sqlInsert);
                ps1.setString(1, studentName);
                ps1.setString(2,classId);
                ps1.executeUpdate();
            }
            System.out.println("Okkk!");
        }catch (SQLException ex){
            System.out.println("Sai goi!!");
        }


        String newClassName = "N18DCAT01-N";
        Integer classIdUpdate = 1;
        String sqlUpdate = "update Classes set ClassName = ? where ClassId = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlUpdate);
            ps.setString(1,newClassName);
            ps.setString(2, String.valueOf(classIdUpdate));
            ps.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Sai goi!!");
        }

        Integer classIdDelete = 6;
        String sqlDelete = "delete from Classes where ClassId = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlDelete);
            ps.setString(1, String.valueOf(classIdDelete));
            ps.executeUpdate();
            System.out.println("Okkk!!");
        }catch (SQLException ex){
            System.out.println("Sai goi!!");
        }

    }

}
