/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukarna.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sukarna.db.DataAccess;
import sukarna.models.User;

/**
 *
 * @author shawontafsir
 */
public class OrderProcess extends HttpServlet {

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
        //String email = LogInProcess.globalemail;
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        if(email == null){
                RequestDispatcher rd = request.getRequestDispatcher("logIn.jsp");
                rd.forward(request, response);
            }
        
        String foodId = request.getParameter("foodId");
        String noOfOrder = request.getParameter("noOfOrder");
        DataAccess dao = new DataAccess();
        int orderId = dao.getMaxOrderId();
        
        ArrayList<User> userInfo = dao.getUserInfo(email);
        int count = dao.createOrder(orderId+1,Integer.parseInt(foodId),userInfo.get(0).userId,0,Integer.parseInt(noOfOrder));
        
        if(count == 1){
            System.out.println("I am count 1");
                RequestDispatcher rd = request.getRequestDispatcher("makeOrder.jsp");
                rd.forward(request, response);
            }
        else{
            System.out.println("I am count 0");
            RequestDispatcher rd = request.getRequestDispatcher("makeOrder.jsp");
            rd.forward(request, response); 
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
        processRequest(request, response);
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
