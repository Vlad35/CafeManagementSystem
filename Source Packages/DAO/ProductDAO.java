/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author vladg
 */
public class ProductDAO {
    public static void save(Product product) throws SQLException {
        String query = "INSERT INTO PRODUCT(NAME,CATEGORY,PRICE) VALUES ('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')";
        DBOperations.setDataOrDelete(query, "Product Added Successfully!");
    }
    public static ArrayList<Product> getAllRecords() {
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DBOperations.getData("SELECT * FROM PRODUCT");
            while(rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                arrayList.add(product);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static void update(Product product) throws SQLException {
        String query = "UPDATE PRODUCT SET NAME = '"+product.getName()+"',CATEGORY = '"+product.getCategory()+"',PRICE = '"+product.getPrice()+"' WHERE ID='"+product.getId()+"'";
        DBOperations.setDataOrDelete(query, "Product Updated Successfully!");
    }
    public static void delete(String id) throws SQLException {
        String query = "DELETE FROM PRODUCT WHERE ID = '"+id+"'";
        DBOperations.setDataOrDelete(query, "Product Deleted Successfully!");
    }
    public static ArrayList<Product> filterProductByName(String name,String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DBOperations.getData("SELECT * FROM PRODUCT WHERE NAME LIKE'%"+name+"%' AND CATEGORY = '"+category+"'");
            while(rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static ArrayList<Product> getAllRecordsByCatgegory(String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DBOperations.getData("SELECT * FROM PRODUCT WHERE CATEGORY='"+category+"'");
            while(rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static Product getProductByName(String name) {
        Product product = new Product();
        try{
            ResultSet rs = DBOperations.getData("SELECT * FROM PRODUCT WHERE NAME='"+name+"'");
            while(rs.next()) {
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
