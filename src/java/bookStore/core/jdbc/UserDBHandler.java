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
            String sqlQuery = "Select [name], [password], [role] from Users a where a.name = ? and a.password= ?";
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                String role = rs.getString(3);
                foundUser = new User(username, password, role);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foundUser;
    }
}
