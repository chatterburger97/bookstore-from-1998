/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.core.services;

import bookStore.core.domain.CartItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
        if(session!=null && session.getAttribute("cart")!=null){
            HashMap<Integer, CartItem> cart = (HashMap<Integer, CartItem>)session.getAttribute("cart");
            if(!cart.isEmpty()){
                Iterator it = cart.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    System.out.println(pair.getKey() + " = " + pair.getValue()); 
                    int price = ((CartItem)pair.getValue()).getAddedBook().getPrice();
                    int qty = ((CartItem)pair.getValue()).getQty();
                    cartTotal+=(price*qty);
                }
            }
        }
        return cartTotal;
    }
    
}
