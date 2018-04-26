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
import javax.servlet.http.HttpSession;

/**
 *
 * @author chatterburger
 */
public class UserService {
    public static final String ADMINUSR="admin";
    public static final String USR="usr";
    
    public static boolean checkAccess(HttpServletRequest request, String username, String password, UserRole userRoleType){
        
        UserDBHandler db = new UserDBHandler();
        if(db.makeConnection() == false){
            System.out.println("could not connect to database");
            return false;
        }
        

        if(username == null || username.equals("") || password == null || password.equals("")){
            String errorString = "Required fields for login!";
            System.out.println("required fields for login");
            request.setAttribute("errorString", errorString);
            return false;
        }
        
        User foundUser = db.findUser(db.getConnection(), username, password);
        if (foundUser == null){
            String errorString = "Invalid credentials! Please try again.";
            System.out.println("did not find user in database");
            request.setAttribute("errorString", errorString);
            return false;
        } else {
            HttpSession session = request.getSession(false);
            if(session!=null){
                session.invalidate();
            }
            session = request.getSession();
            session.setAttribute("currentUserRole",foundUser.getRole());
            session.setAttribute("currentUserLoyalty", foundUser.getLoyaltypoints());
            session.setAttribute("currentUserName", foundUser.getUsername());
            session.setAttribute("currentUserID", foundUser.getId());
            System.out.println("current user id : " + session.getAttribute("currentUserID"));
            System.out.println("current user name : " + session.getAttribute("currentUserName"));
            System.out.println("current role : " + session.getAttribute("currentUserRole"));
            return foundUser.getRole().equals(userRoleType.getRole());
        }
    }
}
