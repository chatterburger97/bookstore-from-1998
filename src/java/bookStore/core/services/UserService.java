/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.core.services;

import bookStore.core.domain.UserRole;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author chatterburger
 */
public class UserService {
    public static final String ADMINUSR="admin";
    public static final String USR="usr";
    
    public static boolean checkAccess(HttpServletRequest request, UserRole userRoleType){
        return request.isUserInRole(userRoleType.getRole());
    }
}
