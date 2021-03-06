/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.web.servlets;

import bookStore.core.domain.Book;
import bookStore.core.jdbc.BookDBHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chatterburger
 */
public class AdminChangeBookServlet extends HttpServlet {
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
        int bookID = -1;
        String changeType = "";
        String nextJspPage = "";
        
        if(request.getParameter("bookID")!=null && request.getParameter("changeType")!=null){
            bookID = Integer.parseInt(request.getParameter("bookID"));
            changeType = request.getParameter("changeType");
        } 

        if(changeType.equals("qty")){
            request.setAttribute("bookID", bookID);
            nextJspPage = "/views/admin/changeqty.jsp";
            getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
        } else if(changeType.equals("price")){
            request.setAttribute("bookID", bookID);
            nextJspPage = "/views/admin/changeprice.jsp";
            getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
        } else if(changeType.equals("remove")){
            request.setAttribute("bookID", bookID);
            String bookName = request.getParameter("bookName");
            request.setAttribute("bookName", bookName);
            nextJspPage = "/views/admin/confirmremove.jsp";
            getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
        } else {
            // changeType is modify
            request.setAttribute("bookID", bookID);
            System.out.println("book ID is not null : " + bookID);
            BookDBHandler db = new BookDBHandler();
            boolean result = db.makeConnection();
          
            Book bookToUpdate = db.retrieveBookByID(db.getConnection(), bookID);
            request.setAttribute("bookToUpdate", bookToUpdate);
            System.out.println("book to update is being set properly " + bookToUpdate.getTitle());
            nextJspPage = "/views/admin/updatebookdetails.jsp";
            getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
            
        }
    }

}
