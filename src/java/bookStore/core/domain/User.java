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
public class User {
    private int ID;
    private String username;
    private String password;
    private String role;
    private int loyaltypoints;
    
    public User(String username, String password, String role, int loyaltypoints) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.loyaltypoints = loyaltypoints;
    }

    public User(int ID, String username, String password, String role, int loyaltypoints) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.loyaltypoints = loyaltypoints;
    }
    /* setters */
   
    public void setRole(String role){
        this.role = role;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setLoyaltypoints(int lp){
        this.loyaltypoints = lp;
    }
    
    /* getters */
    public int getId(){
        return ID;
    }
    public String getPassword(){
        return password;
    }
    public String getRole() {
        return role;
    }
    public String getUsername() {
        return username; //To change body of generated methods, choose Tools | Templates.
    }
    public int getLoyaltypoints(){
        return loyaltypoints;
    }
    
}
