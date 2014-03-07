/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import modelDAO.IndexQueryBean;
import modelDAO.UserSignUpBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "RegisterationServlet", urlPatterns = {"/RegisterationServlet"})
public class RegisterationServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String k = request.getParameter("registerBtn");
        UserSignUpBean usb = new UserSignUpBean();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            if (usb.CheckEmailValidity(request.getParameter("email"))) {
                if (k.equals("register")) {
                    try {

                        usb.userSignUn(request.getParameter("firstName"), request.getParameter("family"), request.getParameter("org"), request.getParameter("email"), request.getParameter("webSite"), request.getParameter("pass"));
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                }
                String address = "signIn.jsp";
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
            } else {


                out.print(request.getParameter("email is not valid"));
                String address = "register.jsp";
                RequestDispatcher dispatcher =
                        request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            System.err.println("Cannot connect ");
        } finally {
            out.close();
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
        String address = "SignIn.jsp";
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
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
