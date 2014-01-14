/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SubmitServ;

import QuestionServ.QueBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rock
 */
public class SubmitQuestion {
    static Connection con=null;
    static ResultSet rset=null;
    
    public static void generateQuestion(QueBean bean, int user_id) throws SQLException
    {
        Statement stmt=null;        
        try{
            con = ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            
            String question = bean.getQuestion()+bean.getChoiceA()+bean.getChoiceB()+bean.getChoiceC()+bean.getChoiceD();
            String right = bean.getRightAnswer();
            String query = "INSERT INTO submitted(user_id,question,rightAnswer,verified) VALUES('"+user_id+"','"+question+"','"+right+"','0');";
            
            stmt.executeUpdate(query);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            stmt.close();
            ConDB.ConnectDB.disconDB();
        }
    }
}