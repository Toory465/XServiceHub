/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import modelDAO.IndexQueryBean;
import modelDAO.UserWSDLBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Touraj
 */
@WebServlet(name = "UserWSDLView", urlPatterns = {"/userWSDLview.jsp"})
public class UserWSDLView extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            boolean create = true;
            HttpSession session = request.getSession(create);
            Integer user_id = (Integer) session.getAttribute("user_id");
            String user_name = (String) session.getAttribute("user_name");
            String address = "WEB-INF/needAuthentication/userWSDLview1.jsp";
            UserWSDLBean userQueries = new UserWSDLBean();
            userQueries.setUserID(user_id);
            userQueries.UserViewMaker();//    
            request.setAttribute("UQB", userQueries);
            session.setAttribute("user_id", user_id);
            session.setAttribute("user_name", user_name);
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(address);
            dispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
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
