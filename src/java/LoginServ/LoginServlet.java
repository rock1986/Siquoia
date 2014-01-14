/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LoginServ;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rock
 */
public class LoginServlet extends HttpServlet {

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
        try
        {           
            ServletContext sc = this.getServletContext();
            LoginBean user = (LoginBean) sc.getAttribute("user");
            if (user == null) {
                user = new LoginBean();
                sc.setAttribute("currentSessionUser", user);
            }             

            user.setUseremail(request.getParameter("useremail"));
            user.setUserpassword(request.getParameter("password"));
            user.setFirsttime(false);
            
            user = UserAcess.login(user);
                    
            if (user.isVaild() && user.isPaid() && !user.isAdmin())
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                response.sendRedirect("PaidUser/mainpage.jsp");
            }
            else if (user.isVaild() && !user.isPaid() && !user.isAdmin())
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                response.sendRedirect("Guest/guest.jsp");
            }
            else if (user.isVaild() && user.isAdmin())
            {
                AdminBean admin = new AdminBean();
                admin.setAdmin_Id(user.getId());
                admin.setFirstname(user.getFirstname());
                admin.setLastname(user.getLastname());
                admin.setUseremail(user.getUseremail());
                admin.setUserpassword(user.getUserpassword());
                
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionAdmin", admin);
                response.sendRedirect("Admin/admin.jsp");
            }
            else
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);                
                response.sendRedirect("index.jsp");
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
