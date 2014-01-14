/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SampleQuestionServ;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

/**
 *
 * @author rock
 */
public class GetSample {
    static Connection con=null;
    static ResultSet rset=null;
    
    public static SampleBean[] getPackage(SampleBean[] bean, String category) throws SQLException
    {       
        Statement stmt=null;
        try{
            con = ConDB.ConnectDB.getConn();
            stmt = con.createStatement();

//            bean.getNumOfQues();
            String query = "SELECT question, correctAnswer FROM question WHERE package_id='0';";
            
            rset = stmt.executeQuery(query);
            int count=0;
            while(rset.next()&& count<10)
            {
                String que= rset.getString(1);
                StringTokenizer st = new StringTokenizer(que,"__");
                bean[count]=new SampleBean();
                if(st.hasMoreTokens())
                {
                    bean[count].setQuestion(st.nextToken());
                }
                while (st.hasMoreTokens())
                {
                    bean[count].setChoiceA(st.nextToken());
                    bean[count].setChoiceB(st.nextToken());
                    bean[count].setChoiceC(st.nextToken());
                    bean[count].setChoiceD(st.nextToken());
                }
                
                String rightAns= rset.getString(2);
                bean[count].setRightAnswer(rightAns);
                count++;
                
            }
//            bean.setNumOfQues();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bean;
    }
}