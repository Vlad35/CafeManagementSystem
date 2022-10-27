/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Bill;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author vladg
 */
public class BillDAO {

    public static String getId() {
        int id = 1;
        try {
            ResultSet rs = DBOperations.getData("SELECT MAX(ID) FROM BILL");
            if (rs.next()) {
                id = rs.getInt(1);
                id++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    public static void save(Bill bill) throws SQLException {
        String query = "INSERT INTO BILL VALUES('" + bill.getId() + "','" + bill.getName() + "','" + bill.getMobileNumber() + "','" + bill.getEmail() + "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getCreatedBy() + "')";
        DBOperations.setDataOrDelete(query, "Bill Details Added Successfully!");
    }

    public static ArrayList<Bill> getAllRecordsByIncrement(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DBOperations.getData("SELECT * FROM BILL WHERE DATE LIKE '%" + date + "%'");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("created_By"));
                arrayList.add(bill);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static ArrayList<Bill> getAllRecordsByDesc(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DBOperations.getData("SELECT * FROM BILL WHERE DATE LIKE '%" + date + "%' ORDER BY ID DESC");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("created_By"));
                arrayList.add(bill);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
