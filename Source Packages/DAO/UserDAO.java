/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author vladg
 */
import Model.User;
import cafe_management_system.ForgotPassword;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    public static void save(User user) throws SQLException {
        String Query = "INSERT INTO USER(NAME,EMAIL,MOBILENUMBER,ADDRESS,PASSWORD,SECURITYQUESTION,ANSWER,STATUS) VALUES ('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"',"
                + "'"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
        DBOperations.setDataOrDelete(Query, "Registered Successfully!Wait for Admin Approval!");
    }
    public static User login(String email, String password) {
        User user = null;
        try{
            ResultSet rs = DBOperations.getData("SELECT * FROM USER WHERE EMAIL='"+email+"' and password='"+password+"'");
            while(rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
        return user;
    }
    public static User getSecurityQuestion(String email) {
        User user = null;
        try{
            ResultSet rs = DBOperations.getData("SELECT * FROM USER WHERE EMAIL = '"+email+"'");
            while(rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    } 
    public static void update(String email,String newPassword) throws SQLException {
        String query = "UPDATE USER SET PASSWORD = '"+newPassword+"' WHERE EMAIL = '"+email+"'";
        DBOperations.setDataOrDelete(query, "Password Changed Successfully!");
    }
    public static ArrayList<User> getAllRecords(String email) {
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DBOperations.getData("SELECT * FROM USER WHERE EMAIL LIKE '%"+email+"'");
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static void changeStatus(String email,String status) throws SQLException {
        String query = "UPDATE USER SET STATUS = '"+status+"' WHERE EMAIL = '"+email+"'";
        DBOperations.setDataOrDelete(query, "Status Changed Successfully!");
    }
    public static void changePassword(String email,String oldPassword,String newPassword) {
        try{
            ResultSet rs = DBOperations.getData("SELECT * FROM USER WHERE EMAIL = '"+email+"' AND PASSWORD='"+oldPassword+"'");
            if(rs.next()) {
                update(email, newPassword);
            }else {
                JOptionPane.showMessageDialog(null, "Old Password is Wrong!!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    } 
    public static void changeSecurityQuestion(String email,String password,String securityQuestion, String answer) {
        try{
            ResultSet rs = DBOperations.getData("SELECT * FROM USER WHERE EMAIL = '"+email+"' AND PASSWORD='"+password+"'");
            if(rs.next()) {
                update(email, securityQuestion, answer);
            }else {
                JOptionPane.showMessageDialog(null, "Password is Wrong!");
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static void update(String email,String securityQuestion,String answer) throws SQLException {
        String query = "UPDATE USER SET SECURITYQUESTION ='"+securityQuestion+"',ANSWER='"+answer+"' WHERE EMAIL = '"+email+"'";
        DBOperations.setDataOrDelete(query, "Security Question has been changed Successfully!");
    }
} 
