/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.web.servlets;

import bookStore.core.domain.UserRole;
import bookStore.core.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chatterburger
 * 
 * Uses login service to check whether user is authenticated in admin or user role
 * Sends boolean success as a context variable that can be accessed from within the page, so if login is unsuccessful an
 * error message can be displayed on the same page
 * If login as admin succeeds, redirects to admin/view servlet (ends up at admin/dashboard.jsp)
 * If login as user succeeds, redirects to user/view servlet (ends up at browsebooks.jsp)
 */
public class LoginServlet extends HttpServlet {


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

        if(UserService.checkAccess(request, UserRole.ADMINUSR)){
            String nextServlet = "../admin/view";
            response.sendRedirect(nextServlet);
        } else if (UserService.checkAccess(request, UserRole.USR)){
            String nextServlet = "../user/view";
            response.sendRedirect(nextServlet);
        } else {
            getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
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
        return "Short description";
    }// </editor-fold>

}
