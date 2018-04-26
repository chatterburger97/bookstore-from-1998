/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.web.servlets;

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
public class AdminUpdateBookServlet extends HttpServlet {

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
                        
        int bookID = -1;
        String title="";
        String authorName="";
        String ISBN = "";
        String genre = "";
        
        // String updateTitleAuthorISBNGenreByID
        try {
            bookID = Integer.parseInt(request.getParameter("bookID"));
            title = request.getParameter("title");
            authorName = request.getParameter("author");
            ISBN = request.getParameter("ISBN");
            genre = request.getParameter("genre");
            if(bookID!=-1){
                BookDBHandler db = new BookDBHandler();
                db.makeConnection();
                boolean result;
                result = db.updateTitleAuthorISBNGenreByID(db.getConnection(), bookID, title, authorName, ISBN, genre);
                System.out.println(result);
            }
            response.sendRedirect("../admin/view");
        } catch (Exception e) {
            System.out.println("Could not update book"  + e.getMessage());
            response.sendRedirect("../admin/view");
        }
    }

}
