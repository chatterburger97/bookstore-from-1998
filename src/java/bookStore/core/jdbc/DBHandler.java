/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 *
 * @author chatterburger
 */
public class DBHandler {
    
    private String jdbcUrl = "jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad005_db";
    private String dbPwd = "aiad005";
    private String dbUsername = "aiad005";

    private Connection con;
    private boolean success = false;
    
    public boolean makeConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPwd);
            success = true;
        } catch (ClassNotFoundException | SQLException e) {
            success = false;
        }
        return success;
    }
    
    public Connection getConnection(){
        return con;
    }
}
