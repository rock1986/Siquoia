/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuestionServ;

import ConDB.ConnectDB;
import java.io.IOException;
import java.sql.*;
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
@WebServlet(name = "SelectCategoryServlet", urlPatterns = {"/SelectCategoryServlet"})
public class SelectCategoryServlet extends HttpServlet {

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
            
            //Go to Main topics
            String select = request.getParameter("firstlevelcategory");
            if (select!=null)
            {
                Connection con = ConnectDB.getConn();
                Statement stmt = con.createStatement();
                String query = "SELECT firstlevel FROM firstlevel";
                ResultSet rset= stmt.executeQuery(query);
                while (rset.next())
                {
                    //Go to full topic hierarchy
                    if(select.equals(rset.getString("firstlevel")))
                    {
                        HttpSession session= request.getSession(true);
                        session.setAttribute("category", rset.getString("firstlevel"));
                        response.sendRedirect("PaidUser/category.jsp");
                    }
                }
            }
            else
            {
                Enumeration paramName=request.getParameterNames();
                while(paramName.hasMoreElements())
                {
                    String action= (String)paramName.nextElement(); 
                    //Back to selectMode.jsp
                    if (action.equals("back"))
                    {
                        response.sendRedirect("PaidUser/selectMode.jsp");
                    }               
                    //Back to main page
                    if (action.equals("mainpage"))
                    {
                        response.sendRedirect("PaidUser/mainpage.jsp");
                    }                 
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectDB.disconDB();

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
