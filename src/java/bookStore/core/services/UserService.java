/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.core.services;

import bookStore.core.domain.User;
import bookStore.core.domain.UserRole;
import bookStore.core.jdbc.UserDBHandler;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author chatterburger
 */
public class UserService {
    public static final String ADMINUSR="admin";
    public static final String USR="usr";
    
    public static boolean checkAccess(HttpServletRequest request, UserRole userRoleType){
        // return request.isUserInRole(userRoleType.getRole());
        String username = (String)request.getAttribute("username");
        String password = (String)request.getAttribute("password");
        UserDBHandler db = new UserDBHandler();
        db.makeConnection();
        String errorString = null;
        
        if(username==null || username.equals("") || password == null || password.equals("")){
            errorString = "Required fields for login!";
            request.setAttribute("errorString", errorString);
            return false;
        } 
        User foundUser =db.findUser(db.getConnection(), username, password);
        
        if (foundUser == null){
            errorString = "Required fields for login!";
            request.setAttribute("errorString", errorString);
            return false;
        } else {
            return true;
        }

    }
}
