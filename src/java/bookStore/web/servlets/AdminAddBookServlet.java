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
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chatterburger
 */
public class AdminAddBookServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminAddBookServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminAddBookServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        String currentUserRole = (String)session.getAttribute("currentUserRole");
        
        if(currentUserRole != null && currentUserRole.equals("admin")){
            String nextJspPage = "/views/admin/addbook.jsp";
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
        String title = (String)request.getParameter("title");
        String isbn = (String)request.getParameter("ISBN");
        String author = (String)request.getParameter("author");
        String genre = (String)request.getParameter("genre");
        String description = (String)request.getParameter("description");
        
        BookDBHandler db = new BookDBHandler();
        
        if(db.makeConnection()){
            Connection con = db.getConnection();
            if(db.addNewBook(con, title, author, isbn, genre, description)){
                request.setAttribute("responsemessage", "added new book successfully");
                System.out.println("added new book successfully");
                String nextJspPage = "/views/admin/addbook.jsp";
                getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
                
            } else {
                request.setAttribute("responsemessage", "could not add new book");
                System.out.println("could not add new book");
                String nextJspPage = "/views/admin/addbook.jsp";
                getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
            }
        } else {
            request.setAttribute("responsemessage", "could not add new book");
            System.out.println("could not add new book");
            String nextJspPage = "/views/admin/addbook.jsp";
            getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
        }   
    }

}
