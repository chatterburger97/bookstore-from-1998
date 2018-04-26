/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookStore.web.servlets;

import bookStore.core.domain.User;
import bookStore.core.jdbc.UserDBHandler;
import bookStore.core.services.PaymentService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chatterburger
 */
public class CheckoutServlet extends HttpServlet {

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
            out.println("<title>Servlet CheckoutServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        HttpSession session = request.getSession(false);
        String paymentMethod = request.getParameter("paymentMethod");
        System.out.println("payment method : " + paymentMethod);
        String nextJspPage;
        if(paymentMethod.equals("loyalty")){
            if(session == null || session.getAttribute("currentUserRole") == null){
                System.out.println("no user role");
                response.sendRedirect("/");
            } else if(session.getAttribute("currentUserID")!=null){
                UserDBHandler db = new UserDBHandler();
                if(db.makeConnection()){
                    Connection con = db.getConnection();
                    User foundUser = db.findUser(con,(int)session.getAttribute("currentUserID")); 
                    int cartTotal = PaymentService.getCartTotal(request);
                    int loyaltyPoints = foundUser.getLoyaltypoints();
                    if(loyaltyPoints >= cartTotal){

                        if(request.getAttribute("deductLoyalty")!=null){
                            int adjustedLoyalty = loyaltyPoints - cartTotal;
                            db.updateLoyaltyPointsById(con, foundUser.getId(),adjustedLoyalty);
                        }

                        session.setAttribute("adjustedLoyalty", loyaltyPoints - cartTotal);
                        request.setAttribute("successmessage", "you have enough points to checkout, checkout successful");
                        nextJspPage = "/views/user/checkoutsuccessful.jsp";
                        getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
                    } else {
                        request.setAttribute("cartTotal", cartTotal);
                        request.setAttribute("adjustedTotal", cartTotal - loyaltyPoints);
                        request.setAttribute("loyaltyPoints", loyaltyPoints);
                        nextJspPage  = "/views/user/insufficientloyalty.jsp";
                        getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
                    }
                } else {
                    request.setAttribute("errormessage", "connectivity error, please check your vpn");
                    nextJspPage  = "/user/cart";
                    getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
                }   
            } else {
                response.sendRedirect("/login");
            }
        } else if(paymentMethod.equals("creditcard")){
            nextJspPage = "/views/user/creditcardpayment.jsp";
            getServletContext().getRequestDispatcher(nextJspPage).forward(request, response);
        } else {
            System.out.println("payment method is not loyalty or creditcard");
            response.sendRedirect("/"); 
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
