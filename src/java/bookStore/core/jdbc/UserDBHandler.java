/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.core.jdbc;

import bookStore.core.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chatterburger
 */
public class UserDBHandler extends DBHandler {
    public User findUser(Connection connection, String username, String password){
        User foundUser = null;
        try {
            String sqlQuery = "Select [role], [loyaltypoints], [ID] from Users a where a.name = ? and a.password= ?";
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                String role = rs.getString(1);
                int loyaltypoints = rs.getInt(2);
                int ID = rs.getInt(3);
                foundUser = new User(ID, username, password, role, loyaltypoints);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foundUser;
    }

    public User findUser(Connection connection, int ID) {
        User foundUser = null;
        System.out.println("searching by : " + ID);
        try {
            String sqlQuery = "Select [name], [password], [role], [loyaltypoints] from Users a where a.ID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println("query executed");
                String username = rs.getString(1);
                String password = rs.getString(2);
                String role = rs.getString(3);
                int loyaltypoints = rs.getInt(4);
                foundUser = new User(ID, username, password, role, loyaltypoints);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foundUser;
    }
}
