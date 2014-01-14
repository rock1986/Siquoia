/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BuyPackageServ;

import LoginServ.LoginBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.StringTokenizer;
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
@WebServlet(name = "BuyPackServlet", urlPatterns = {"/BuyPackServlet"})
public class BuyPackServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session=request.getSession(true);
            Enumeration paramName=request.getParameterNames();
            while(paramName.hasMoreElements())
            {
                String action= (String)paramName.nextElement(); 
                if (action.equals("purchase"))
                {
                    String str = request.getParameter("package");
                    StringTokenizer st = new StringTokenizer(str,"-------------------");
                    int package_id=0,price=0;
                    LoginBean user=(LoginBean)session.getAttribute("currentSessionUser");
                    int user_id = user.getId();
                    
                    if (st.hasMoreTokens())
                    {
                        String name=st.nextToken();
                        package_id =UpdateInfo.getPackageId(name);
                        price = UpdateInfo.getPackagePrice(name);
                    }
                    
                    UpdateInfo.updateInfo(user_id,package_id,price);
                    response.sendRedirect("PaidUser/buyPackage.jsp");                    
                }
                if (action.equals("backtocatetory"))
                {
                    response.sendRedirect("PaidUser/selectCategory.jsp");
                }
                if (action.equals("mainpage"))
                {
                    response.sendRedirect("PaidUser/mainpage.jsp");
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
