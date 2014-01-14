/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SubmitServ;

import LoginServ.LoginBean;
import QuestionServ.QueBean;
import QuestionServ.StatusBean;
import QuestionServ.Update;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SubmitServlet", urlPatterns = {"/SubmitServlet"})
public class SubmitServlet extends HttpServlet {

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
            HttpSession session = request.getSession(true);
            LoginBean currentUser=(LoginBean)session.getAttribute("currentSessionUser");
            
            Enumeration paramName=request.getParameterNames();
            while(paramName.hasMoreElements())
            {
                String str = (String)paramName.nextElement();
                
                //The user submit several questions
                if (str.equals("submitnext"))
                {
                    QueBean newQue= new QueBean();
                    //Set the submitted question to the bean
                    String qusetion = request.getParameter("qusetion");
                    newQue.setQuestion(qusetion);
                    //Set the four choices to the bean
                    String choiceA = "__" + request.getParameter("choiceA");
                    newQue.setQuestion(choiceA);
                    String choiceB = "__" + request.getParameter("choiceB");
                    newQue.setQuestion(choiceB);
                    String choiceC = "__" + request.getParameter("choiceC");
                    newQue.setQuestion(choiceC);
                    String choiceD = "__" + request.getParameter("choiceD");
                    newQue.setQuestion(choiceD); 
                    String rightAnswer = request.getParameter("choice");
                    newQue.setRightAnswer(rightAnswer);
                    //Place the submitted question in to be verified table
                    SubmitQuestion.generateQuestion(newQue,currentUser.getId());
                    
                    response.sendRedirect("PaidUser/submitQuestion.jsp");
                }
                
                //The user finish submitting questions and go back to mainpage
                if (str.equals("finish"))
                {
                    QueBean newQue= new QueBean();
                    //Set the submitted question to the bean
                    String question = request.getParameter("question");
                    newQue.setQuestion(question);
                    //Set the four choices to the bean
                    String choiceA = "__" + request.getParameter("choiceA");
                    newQue.setChoiceA(choiceA);
                    String choiceB = "__" + request.getParameter("choiceB");
                    newQue.setChoiceB(choiceB);
                    String choiceC = "__" + request.getParameter("choiceC");
                    newQue.setChoiceC(choiceC);
                    String choiceD = "__" + request.getParameter("choiceD");
                    newQue.setChoiceD(choiceD); 
                    String rightAnswer = request.getParameter("choice");
                    newQue.setRightAnswer(rightAnswer);
                    
                    SubmitQuestion.generateQuestion(newQue,currentUser.getId());
                    
                    response.sendRedirect("PaidUser/mainpage.jsp");                   
                }
                
                if (str.equals("mainpage"))
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
