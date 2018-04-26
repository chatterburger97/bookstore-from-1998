/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.web.servlets;

import bookStore.core.domain.Book;
import bookStore.core.domain.CartItem;
import bookStore.core.jdbc.BookDBHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chatterburger
 */
public class AddToCartServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        HttpSession session = request.getSession();
        session.removeAttribute("lastAddedToCart");
        
        if(request.getParameterMap().containsKey("bookID")){
            Integer bookID = Integer.parseInt(request.getParameter("bookID"));
            Book addedBook = null;
            BookDBHandler db = new BookDBHandler();
            if (db.makeConnection()) {
                addedBook = db.retrieveBookByID(bookID);
                session.setAttribute("lastAddedToCart", addedBook.getTitle());
            }

            HashMap<Integer, CartItem> cart = new HashMap<>(); // bookId, qty pairs
            if(session.getAttribute("cart")!=null){
                cart = (HashMap<Integer, CartItem>)session.getAttribute("cart");
            } 
            if(cart.get(bookID) != null){
                CartItem item = cart.get(bookID);
                item.setQty(item.getQty() + 1);
                cart.put(bookID, item);
            } else {
                CartItem item = new CartItem();
                item.setAddedBook(addedBook);
                item.setQty(1);
                cart.put(bookID, item);
                
            }
            
            session.setAttribute("cart", cart);
        }  
        response.sendRedirect("user/view");        
    }

}
