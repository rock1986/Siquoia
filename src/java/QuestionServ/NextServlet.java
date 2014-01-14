/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuestionServ;

import SubmitServ.SubmitQuestion;
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
@WebServlet(name = "NextServlet", urlPatterns = {"/NextServlet"})
public class NextServlet extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(true);
            LoginBean currentUser=(LoginBean)session.getAttribute("currentSessionUser");
            int user_id = currentUser.getId();
            
            StatusBean status=(StatusBean)session.getAttribute("currentStatus");
            String choice = request.getParameter("choice");
            if (choice.equals(status.getQuestion().getRightAnswer()))
            { 
                //Update user highscore
                int highscore = currentUser.getHighscore();
                highscore++;
                currentUser.setHighscore(highscore);

                //update user points
                int points = currentUser.getPoint();
                points++;
                currentUser.setPoint(points);

                int correct = status.getCorrect();
                correct++;
                status.setCorrect(correct);

                status.getQuestion().setAnsweredRight(true);
                //update question difficulty
                int difficulty = status.getQuestion().getDifficulty();
                difficulty++;
                status.getQuestion().setDifficulty(difficulty);
                Update.updateQuestion(status.getQuestion(),user_id);
                Update.updateUser(currentUser);

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

                response.sendRedirect("PaidUser/game.jsp");
            }
            else
            {
                session.setAttribute("currentStatus", status);
                response.sendRedirect("PaidUser/result.jsp");
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
