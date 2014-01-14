/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuestionServ;

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
@WebServlet(name = "CategoryServlet", urlPatterns = {"/CategoryServlet"})
public class CategoryServlet extends HttpServlet {

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
                Enumeration paramName=request.getParameterNames();
                while(paramName.hasMoreElements())
                {
                    String action= (String)paramName.nextElement();            
                    if (action.equals("firstlevel"))
                    {
                        HttpSession session=request.getSession(true);
                        session.setAttribute("firstlevel", request.getParameter("firstlevel"));
                        response.sendRedirect("areyouready.jsp");
                    }
                   if (action.equals("secondlevel"))
                    {
                        HttpSession session=request.getSession(true);
                        session.setAttribute("secondlevel", request.getParameter("secondlevel"));
                        response.sendRedirect("areyouready.jsp");
                    }
                   if (action.equals("thirdlevel"))
                    {
                        HttpSession session=request.getSession(true);
                        session.setAttribute("thirdlevel", request.getParameter("thirdlevel"));
                        response.sendRedirect("areyouready.jsp");
                    }               

                    //Back to selectCategory.jsp from category.jsp
                    if (action.equals("backtocategory"))
                    {
                        response.sendRedirect("PaidUser/selectCategory.jsp");
                    }                
                    //Back to main page
                    if (action.equals("mainpage"))
                    {
                        response.sendRedirect("PaidUser/mainpage.jsp");
                    }   
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
