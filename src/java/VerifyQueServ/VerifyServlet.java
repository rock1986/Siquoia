/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VerifyQueServ;

import LoginServ.AdminBean;
import LoginServ.LoginBean;
import QuestionServ.QueBean;
import java.io.IOException;
import java.util.Enumeration;
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
@WebServlet(name = "VerifyServlet", urlPatterns = {"/VerifyServlet"})
public class VerifyServlet extends HttpServlet {

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
        try{
            /* TODO output your page here. You may use following sample code. */   
            HttpSession session = request.getSession(true);
            AdminBean ad = (AdminBean)session.getAttribute("currentSessionAdmin");
            Enumeration paramName=request.getParameterNames();
            while(paramName.hasMoreElements())
            {
                String str = (String)paramName.nextElement();

                if (str.equals("approve"))
                {             
                    QueBean que = (QueBean)session.getAttribute("currentQuestion");
                    String cat = request.getParameter("category");
                    VerifyQuestion.updateUser(ad);
                    VerifyQuestion.updateQuestion(cat,que);
                             
                    que = VerifyQuestion.getSubmittedQue(ad,que);
                    session.setAttribute("currentQuestion", que);

                    if (que.isHasQue())
                        response.sendRedirect("Admin/verifyQue.jsp");
                    else
                        response.sendRedirect("Admin/noQue.jsp");
                }
                if (str.equals("decline"))
                {
                    QueBean que = (QueBean)session.getAttribute("currentQuestion");
                    VerifyQuestion.deleteQuestion(que);
                    
                    que = VerifyQuestion.getSubmittedQue(ad,que);
                    session.setAttribute("currentQuestion", que);
                    if (que.isHasQue())
                        response.sendRedirect("Admin/verifyQue.jsp");
                    else
                        response.sendRedirect("Admin/noQue.jsp");
                    
                }
                //back to main menu
                if (str.equals("mainpage"))
                {
                    response.sendRedirect("Admin/admin.jsp");
                }
             }
        }
        catch (Exception e)
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
