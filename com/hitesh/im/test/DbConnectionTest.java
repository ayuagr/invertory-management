package com.hitesh.im.test;

import com.hitesh.im.model.utility.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hitesh on 25/7/17.
 */
public class DbConnectionTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = DbConnection.getConnection();
        if(conn == null) System.out.println("null h");
        ResultSet rs = conn.createStatement().executeQuery("Select * from test");
        while (rs.next()){
            System.out.println(rs.getString(1));
        }
    }
}
