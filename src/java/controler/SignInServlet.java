/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import modelDAO.IndexQueryBean;
import modelDAO.SignInBean;
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
@WebServlet(name = "SignInServlet", urlPatterns = {"/SignInServlet"})
public class SignInServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email_ = request.getParameter("email");
        String pass_ = request.getParameter("pass");
        SignInBean sib = new SignInBean(email_, pass_);
        try {
            if (sib.checkMemberShip() != -1) {

                String address = "userWSDLview.jsp";
                request.setAttribute("user_id", sib.checkMemberShip());
                HttpSession session = request.getSession();
                session.setAttribute("user_id", sib.checkMemberShip());
                session.setAttribute("nA", "Yes");
                request.setAttribute("user_name", sib.getUserName());
                session.setAttribute("user_name", sib.getUserName());
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
                response.sendRedirect("userWSDLview.jsp");
            } else {
                String address = "SignIn.jsp";
                request.setAttribute("ws", "Authentication Failed");
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
            }

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
