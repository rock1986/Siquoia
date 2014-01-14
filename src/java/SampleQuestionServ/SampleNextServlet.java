/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SampleQuestionServ;

import LoginServ.LoginBean;
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
@WebServlet(name = "SampleNextServlet", urlPatterns = {"/SampleNextServlet"})
public class SampleNextServlet extends HttpServlet {

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
        try  {
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession(true);
            LoginBean currentUser=(LoginBean)session.getAttribute("currentSessionUser");

            Enumeration paramName=request.getParameterNames();
            while(paramName.hasMoreElements())
            {
                String str = (String)paramName.nextElement();
                if (str.equals("ready") && !currentUser.isPaid())
                {
                    SampleStatusBean status= new SampleStatusBean();
                    status.setPackage("sample");                    
                    status.setCorrect(0);
                    status.setCount(0);
                    session.setAttribute("currentSessionQuestion", status.getQuestion());
                    
                    int total = currentUser.getTotal();
                    total++;
                    currentUser.setTotal(total);                      
                    
                    session.setAttribute("currentStatus", status);
                    response.sendRedirect("Guest/sample.jsp");
                }
                if (str.equals("next"))
                {
                    SampleStatusBean status=(SampleStatusBean)session.getAttribute("currentStatus");
//                    status.setPackage("sample");
                    String choice = request.getParameter("choice");
                    if (choice.equals(status.getQuestion().getRightAnswer()))
                    { 
//                        int highscore = currentUser.getHighscore();
//                        highscore++;
//                        currentUser.setHighscore(highscore);

                        int correct = status.getCorrect();
                        correct++;
                        status.setCorrect(correct);                                           
                    }   
                    
                    int count = status.getCount();
                    count++;
                    status.setCount(count);                     
                    
                    if(status.getQuestion()!=null && status.getCount()<=10)
                    {
                        session.setAttribute("currentSessionQuestion", status.getQuestion());
                        int total = currentUser.getTotal();
                        total++;
                        currentUser.setTotal(total);

                        response.sendRedirect("Guest/sample.jsp");
                    }
                    else
                    {
                        session.setAttribute("currentStatus", status);
                        response.sendRedirect("Guest/result.jsp");
                    }
                    
                    
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
