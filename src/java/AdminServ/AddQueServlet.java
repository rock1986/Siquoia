/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AdminServ;

import QuestionServ.QueBean;
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
@WebServlet(name = "AddQueServlet", urlPatterns = {"/AddQueServlet"})
public class AddQueServlet extends HttpServlet {

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
                String str = (String)paramName.nextElement();
                //Admin submit several questions
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
                    String category = request.getParameter("category");
                    
                    AddQuestion.add(category, newQue);
                    
                    response.sendRedirect("Admin/addQue.jsp");
                }
                
                //Admin finish submitting questions and go back to mainpage
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
                    String category = request.getParameter("category");
                    AddQuestion.add(category, newQue);
                    
                    response.sendRedirect("Admin/admin.jsp");                   
                }
                
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
