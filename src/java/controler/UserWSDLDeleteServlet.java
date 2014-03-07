/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import modelDAO.UserWSDLBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Touraj
 */
@WebServlet(name = "userWSDLDeleteServlet", urlPatterns = {"/userWSDLDeleteServlet"})
public class UserWSDLDeleteServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserWSDLBean uwb = new UserWSDLBean();
        if (request.getParameterValues("selectedItems") != null) {

            String[] selectedItems = request.getParameterValues("selectedItems");
            for (String selectedItem : selectedItems) {
                try {
                    uwb.userWSDLdelete(Integer.valueOf(selectedItem));

                } catch (Exception ex) {
                    Logger.getLogger(UserWSDLDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        String address = "userWSDLview.jsp";
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
        response.sendRedirect("userWSDLview.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
