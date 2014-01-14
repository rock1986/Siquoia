/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaymentServ;

import LoginServ.LoginBean;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rock
 */
@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            ServletContext sc= this.getServletContext();
            PaymentBean bean=(PaymentBean)sc.getAttribute("bean");
            if (bean==null)
            {
                bean = new PaymentBean();
                sc.setAttribute("bean", bean);
            }
            bean.setMethod(request.getParameter("bill_method"));
            bean.setCardNum(request.getParameter("card_number"));
            bean.setMonth(request.getParameter("exp_month"));
            bean.setYear(request.getParameter("exp_year"));
            bean.setCode(request.getParameter("cc_cvv"));
            bean.setFirstname(request.getParameter("bill_fname"));
            bean.setLastname(request.getParameter("bill_lname"));
            bean.setAddress1(request.getParameter("bill_address_1"));
            bean.setAddress2(request.getParameter("bill_address_2"));
            bean.setCity(request.getParameter("bill_city"));
            bean.setCountry(request.getParameter("bill_country"));
            bean.setState(request.getParameter("bill_state"));
            bean.setZip(request.getParameter("bill_zip"));
            bean.setPhone(request.getParameter("bill_phone"));
            bean.setEmail(request.getParameter("bill_email"));
            bean.setFirsttime(false);
            
            if (!bean.isValidPage())
            {
                response.sendRedirect("payment.jsp");
            }
            
            else
            {
                HttpSession session = request.getSession(true);
                LoginBean currentUser=(LoginBean)session.getAttribute("currentSessionUser");
                currentUser.setIspaid(true);
                UpdateUser.update(currentUser);
                session.setAttribute("currentSessionUser", currentUser);                
                response.sendRedirect("PaidUser/mainpage.jsp");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
