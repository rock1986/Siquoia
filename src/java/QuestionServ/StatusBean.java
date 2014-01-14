/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuestionServ;

import java.sql.SQLException;
import javax.ejb.Stateless;

/**
 *
 * @author rock
 */
@Stateless
public class StatusBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private int count;
    private int correct;
    private int numofQue;
    private QueBean[] questionPack=new QueBean[10];
    
    public QueBean[] getPackage() throws SQLException
    {
        return questionPack;
    }
    
    public void setPackage(String level,String select, int user_id) throws SQLException
    {
        this.questionPack=GetQuestion.getPackage(questionPack,level,select,user_id);
    }

    public int getNumofQue() {
        return numofQue;
    }

    public void setNumofQue(int numofQue) {
        this.numofQue = numofQue;
    }
    
    public QueBean getQuestion()
    {
        int num=this.getCount();
        return questionPack[num];
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }    
}
