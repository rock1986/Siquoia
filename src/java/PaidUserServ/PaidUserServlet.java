/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaidUserServ;


import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rock
 */
@WebServlet(name = "PaidUserServlet", urlPatterns = {"/PaidUserServlet"})
public class PaidUserServlet extends HttpServlet {

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
//            HttpSession session= request.getSession(true);
//            LoginBean currentUser=(LoginBean)session.getAttribute("currentSessionUser");
            
            Enumeration paramName=request.getParameterNames();
            while(paramName.hasMoreElements())
            {
                String action= (String)paramName.nextElement();
                
                if (action.equals("game"))
                    response.sendRedirect("PaidUser/selectMode.jsp");
                
                if (action.equals("profile"))
                    response.sendRedirect("PaidUser/viewprofile.jsp");
                
                if (action.equals("point"))
                    response.sendRedirect("PaidUser/buypoint.jsp");
                
                if (action.equals("package"))
                    response.sendRedirect("PaidUser/buyPackage.jsp");  

                if (action.equals("question"))
                    response.sendRedirect("PaidUser/submitQuestion.jsp"); 
                
                if(action.equals("leaderboard"))
                    response.sendRedirect("leaderboard.jsp");
                
                if (action.equals("logout"))
                    response.sendRedirect("logout.jsp"); 
                
                if (action.equals("selectcategory"))
                    response.sendRedirect("PaidUser/gamp.jsp");                
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
