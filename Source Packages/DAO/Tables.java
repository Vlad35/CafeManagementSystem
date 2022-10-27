/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
/**
 *
 * @author vladg
 */
import javax.swing.JOptionPane;

public class Tables {
    public static void main(String[] args){
        try{
            String userTable = "CREATE TABLE USER(ID INT AUTO_INCREMENT PRIMARY KEY,NAME VARCHAR(200),EMAIL VARCHAR(200),MOBILENUMBER VARCHAR(10),"
                    + "ADDRESS VARCHAR(200),PASSWORD VARCHAR(200),SECURITYQUESTION VARCHAR(200),ANSWER VARCHAR(200),STATUS VARCHAR(20),UNIQUE (EMAIL))";
            String adminDetails = "INSERT INTO USER(NAME, EMAIL, MOBILENUMBER,ADDRESS,PASSWORD,SECURITYQUESTION,ANSWER,STATUS) VALUES('Admin', 'admin@gmail.com','1234567890', 'Russia', 'admin', 'What primary schoold did you attend?','ABC','true')";
            String categoryTable = "CREATE TABLE CATEGORY (ID INT AUTO_INCREMENT PRIMARY KEY,NAME VARCHAR(200))";
            String productTable = "CREATE TABLE PRODUCT(ID INT AUTO_INCREMENT PRIMARY KEY,NAME VARCHAR(200),CATEGORY VARCHAR(200),PRICE VARCHAR(200))";
            String billTable = "CREATE TABLE BILL (ID INT PRIMARY KEY,NAME VARCHAR(200),MOBILENUMBER VARCHAR(200),EMAIL VARCHAR(200),DATE VARCHAR(50),TOTAL VARCHAR(200),CREATED_BY VARCHAR(200))";
            
            
            DBOperations.setDataOrDelete(userTable, "User Table Created Succesfully");
            DBOperations.setDataOrDelete(adminDetails, "Admin Details Added Succesfully");
            DBOperations.setDataOrDelete(categoryTable, "Category Table Created Succesfully");
            DBOperations.setDataOrDelete(productTable, "Product Table Created Succesfully");
            DBOperations.setDataOrDelete(billTable, "Bill Table Created Succesfully");
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
