/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.core.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chatterburger
 */
public class PaymentService {
    public static int getCartTotal(HttpServletRequest request){
        int cartTotal = 0;
        HttpSession session = request.getSession(false);
        if(session!=null){
            
        }
        return cartTotal;
    }
    
}
