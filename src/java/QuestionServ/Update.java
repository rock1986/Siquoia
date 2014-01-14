/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuestionServ;

import LoginServ.LoginBean;
import java.sql.*;
/**
 *
 * @author rock
 */
public class Update {
    static Connection con=null;
    
    public static void updateQuestion(QueBean bean, int id) throws SQLException
    {
        Statement stmt = null;
        try
        {
            con = ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            
            
            String query = "UPDATE question set difficulty='"+bean.getDifficulty()+"' WHERE question_id='"+bean.getId()+"';";
            stmt.executeUpdate(query);
            
            query = "INSERT INTO PLAYER_QUESTION(user_id,question_id) VALUES('"+id+"','"+bean.getId()+"');";
            stmt.executeUpdate(query);      
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConDB.ConnectDB.disconDB();
            if (stmt == null)
                stmt.close();
        }
    }
    
    public static void updateUser(LoginBean bean) throws SQLException
    {
        Statement stmt = null;
        try
        {
            con = ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            
            String query = "UPDATE player set highscore='"+bean.getHighscore()+"', point='"+bean.getPoint()+"' WHERE user_id='"+bean.getId()+"';";
            stmt.executeUpdate(query);
     
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConDB.ConnectDB.disconDB();
            if (stmt == null)
                stmt.close();
        }
    }
}
