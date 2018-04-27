/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.web.servlets;

import bookStore.core.domain.Book;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookStore.core.jdbc.BookDBHandler;
import java.util.ArrayList;
/**
 *
 * @author chatterburger
 */
public class UserViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        HttpSession session = request.getSession();
        String currentUserRole = (String)session.getAttribute("currentUserRole");
        int loyalty = (int)session.getAttribute("currentUserLoyalty");
        
        String lastAddedToCart = (String)session.getAttribute("lastAddedToCart");
        System.out.println("last added to cart : " + lastAddedToCart);
        
        if(currentUserRole.equals("usr")){
            String nextJspPage = "/views/user/browsebooks.jsp";
            BookDBHandler db = new BookDBHandler();
            ArrayList<Book> allBooks = db.retrieveTopNBooks(10);
            request.setAttribute("allBooks", allBooks); // @TODO
            request.setAttribute("numBooks", allBooks.size());
            request.setAttribute("loyalty", loyalty);
            getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
        } else {
            response.sendRedirect("../login");
        }
    }

}
