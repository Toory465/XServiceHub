
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import modelDAO.AddWSDLBean;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utility.URLUtil;
import utility.WSDLValidator;

/**
 *
 * @author Touraj
 */
@WebServlet(name = "AddWSDLServlet", urlPatterns = {"/AddWSDLServlet"})
public class AddWSDLServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s = "";
        s = (String) request.getParameter("addBtn");
        HttpSession session = request.getSession(true);
        session.setAttribute("error", "");
        if (s.equals("WSDLadded11")) {

//            if (checkwsdlValid(request.getParameter("url"))) {
            String address = "userWSDLview.jsp";
            AddWSDLBean aub = new AddWSDLBean();
            aub.categoryListMaker();
            request.setAttribute("addWSDLBean", aub);
            session = request.getSession(true);
            Integer user_id = (Integer) session.getAttribute("user_id");
            String k = request.getParameter("addBtn");
            if (k.equals("WSDLadded11")) {
                try {
                    aub.AddWSDL(user_id, 1, request.getParameter("price"), request.getParameter("url"), 1, request.getParameter("subject"), request.getParameter("description"));
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
//            } else {
//                session.setAttribute("error", "Your WSDL URL is not valid");
//                String address = "WEB-INF/needAuthentication/userAddWSDL.jsp";
//                RequestDispatcher dispatcher =
//                        request.getRequestDispatcher(address);
//                dispatcher.forward(request, response);
//            }
        } else {
            String address = "WEB-INF/needAuthentication/userAddWSDL.jsp";
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(address);
            dispatcher.forward(request, response);

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
        String address = "userWSDLview.jsp";
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

    public boolean checkwsdlValid(String uri) {
        boolean result = false;
        try {
            InputStream xmlStream = URLUtil.getInputStreamFromURL(uri);
            if (xmlStream != null) {
                result = WSDLValidator.validateWSDL(uri);
            }
        } catch (Exception ex) {
        }
        return result;
    }
}
