/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.web.servlets;

import bookStore.core.domain.Book;
import bookStore.core.domain.UserRole;
import bookStore.core.jdbc.BookDBHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookStore.core.services.UserService;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chatterburger
 */
public class AdminViewServlet extends HttpServlet {

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
        String username = (String)session.getAttribute("currentUserName");
        String currentUserRole = (String)session.getAttribute("currentUserRole");
        int loyalty = (int)session.getAttribute("currentUserLoyalty");
        
        if(currentUserRole.equals("admin")){
            String nextJspPage = "/views/admin/dashboard.jsp";
            BookDBHandler db = new BookDBHandler();
            ArrayList<Book> allBooks = db.retrieveTopNBooks(10);
            request.setAttribute("allBooks", allBooks); // @TODO
            request.setAttribute("numBooks", allBooks.size());
            request.setAttribute("username", username);
            request.setAttribute("loyalty", loyalty);
            getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
        } else {
            response.sendRedirect("../login");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "admin/view";
    }// </editor-fold>

}
