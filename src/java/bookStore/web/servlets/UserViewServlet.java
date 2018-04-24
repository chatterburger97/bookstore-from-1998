/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.web.servlets;

import bookStore.core.domain.Book;
import bookStore.core.domain.UserRole;
import bookStore.core.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
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
            out.println("<title>Servlet UserViewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserViewServlet at " + request.getContextPath() + "</h1>");
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
        String username = (String)session.getAttribute("currentuser");
        request.authenticate(response);
        boolean authorised = UserService.checkAccess(request, UserRole.USR);
        if(authorised){
            String nextJspPage = "/views/user/browsebooks.jsp";
            // BookDBHandler db = new BookDBHandler();
            ArrayList<Book> allBooks = new ArrayList<>(); //  = db.retrieveTopNBooks(10)
            request.setAttribute("username", username);
            request.setAttribute("allBooks", allBooks); // @TODO
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
