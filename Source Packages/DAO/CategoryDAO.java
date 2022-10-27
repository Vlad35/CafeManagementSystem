/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Category;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author vladg
 */
public class CategoryDAO {
    public static void save(Category category) throws SQLException {
        String query = "INSERT INTO CATEGORY (NAME) VALUES ('"+category.getName()+"')";
        DBOperations.setDataOrDelete(query, "Category added Successfully!");
    }
    public static ArrayList<Category> getAllRecords() {
        ArrayList<Category> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DBOperations.getData("SELECT * FROM CATEGORY");
            while(rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static void delete(String id) throws SQLException {
        String query = "DELETE FROM CATEGORY WHERE ID = '"+id+"'";
        DBOperations.setDataOrDelete(query, "Category Deleted Successfully!");
    }
}
