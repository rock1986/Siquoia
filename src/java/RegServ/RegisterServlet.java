/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RegServ;

import LoginServ.LoginBean;
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
public class RegisterServlet extends HttpServlet {

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
            RegBean newuser = (RegBean) sc.getAttribute("newuser");
            if (newuser == null) {
                newuser = new RegBean();
                sc.setAttribute("newuser", newuser);
            }            
 
            newuser.setFirstname(request.getParameter("fnamesignup"));
            newuser.setLastname(request.getParameter("lnamesignup"));
            newuser.setUseremail(request.getParameter("emailsignup"));
            newuser.setUserpassword(request.getParameter("passwordsignup"));
            newuser.setUserpassword_conf(request.getParameter("passwordsignup_confirm"));
            newuser.setIsFirstTime(false);
            
            newuser = NewUser.register(newuser);
            
            if (!newuser.isVaildPage())  
            {
//                newuser.initialize();
//                newuser.setIsFirstTime(true);
                response.sendRedirect("registerIndex.jsp"); 
            }           
            else
            {
                //Set session for the new user
                HttpSession session = request.getSession(true);
                LoginBean newUser = new LoginBean();
                newUser.setFirstname(newuser.getFirstname());
                newUser.setLastname(newuser.getLastname());
                newUser.setUseremail(newuser.getUseremail());
                newUser.setUserpassword(newuser.getUserpassword());
                newUser.setAdmin(false);
                newUser.setHighscore(0);
                newUser.setIspaid(false);
                newUser.setPoint(0);
                newUser.setTotal(0);
                session.setAttribute("currentSessionUser", newUser);
                response.sendRedirect("Guest/guest.jsp");
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
