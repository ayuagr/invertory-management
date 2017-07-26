package com.hitesh.im.model;

import com.hitesh.im.model.utility.DbConnection;
import com.hitesh.im.model.utility.IMException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hitesh on 25/7/17.
 */
public class CustomerModel {

    public Customer getCustomer(String phoneNumber){
        try {
            PreparedStatement pst = DbConnection.getConnection().prepareStatement("select * from Customer where PhoneNumber = ?");
            pst.setString(1,phoneNumber);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Customer customer = new Customer(rs.getInt("CustomerID"),rs.getString("PhoneNumber"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Gender"),rs.getString("Email"));
            return customer;
        } catch (SQLException e) {
            throw new IMException("Cannot get Customer for PhoneNumber "+phoneNumber);
        }
    }

    public void deleteCustomer(Customer cust){
        try {
            PreparedStatement pst = DbConnection.getConnection().prepareStatement("delete from Customer where PhoneNumber = ?");
            pst.setString(1,cust.getPhoneNumber());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new IMException("Cannot delete Customer with PhoneNumber "+cust.getPhoneNumber());
        }
    }

    public void createCustomer(String phoneNumber, String firstName, String lastName, String gender, String email){
        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("insert into Customer(PhoneNumber,FirstName,LastName,Email,Gender) values(?,?,?,?,?)");
            pst.setString(1,phoneNumber);
            pst.setString(2,firstName);
            pst.setString(3,lastName);
            pst.setString(4,email);
            pst.setString(5,gender);
            pst.execute();
        } catch (SQLException e) {
            throw new IMException("Cannot create new Customer with phoneNumber "+phoneNumber);
        }
    }

    public void updateCustomer(Customer cust){
        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("update Customer set PhoneNumber=?,FirstName=?,LastName=?,Email=?,Gender=? where CustomerID=?");
            pst.setString(1,cust.getPhoneNumber());
            pst.setString(2,cust.getFirstName());
            pst.setString(3,cust.getLastName());
            pst.setString(4,cust.getEmail());
            pst.setString(5,cust.getGender());
            pst.setInt(6,cust.getCustomerId());
            pst.execute();
        } catch (SQLException e) {
            throw new IMException("Cannot update Customer with phoneNumber "+cust.getPhoneNumber());
        }
    }


    public void createCustomer(String phoneNumber, String firstName, String lastName, String gender){
        try{
            Connection conn = DbConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("insert into Customer(PhoneNumber,FirstName,LastName,Gender) values(?,?,?,?)");
            pst.setString(1,phoneNumber);
            pst.setString(2,firstName);
            pst.setString(3,lastName);
            pst.setString(5,gender);
            pst.execute();
        } catch (SQLException e) {
            throw new IMException("Cannot create new Customer with phoneNumber "+phoneNumber);
        }
    }

}
