/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.core.domain;

/**
 *
 * @author chatterburger
 */
public enum UserRole {
    ADMINUSR("admin"), USR("usr");
    private String role;
    
    UserRole(String role){
        this.role = role;
    }
    
    public String getRole(){
        return role;
    }
}
