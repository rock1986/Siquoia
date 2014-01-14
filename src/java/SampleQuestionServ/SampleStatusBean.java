/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SampleQuestionServ;

import java.sql.SQLException;
import javax.ejb.Stateless;

/**
 *
 * @author rock
 */
@Stateless
public class SampleStatusBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private int count;
    private int correct;
    private SampleBean[] pacakge=new SampleBean[10];
    
    public SampleBean[] getPackage() throws SQLException
    {
        return pacakge;
    }
    
    public void setPackage(String select) throws SQLException
    {
        this.pacakge=GetSample.getPackage(pacakge,select);
    }
    
    public SampleBean getQuestion()
    {
        int num=this.getCount();
        return pacakge[num];
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
