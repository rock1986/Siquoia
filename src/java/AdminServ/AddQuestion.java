/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AdminServ;

import QuestionServ.QueBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rock
 */
public class AddQuestion {
    static Connection con=null;
    static ResultSet rset=null;
    
    public static void add(String category,QueBean bean) throws SQLException
    {
        Statement stmt=null;        
        try{
            con = ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            String query = "SELECT MAX(question_id) as max FROM question;";
            rset= stmt.executeQuery(query);
            int max=0;
            if (rset.next())
            {
                max = rset.getInt("max");
                max=max+1;
            }
            query = "SELECT id, sl_id, fl_id FROM thirdlevel WHERE thirdlevel='"+category+"';";
            rset= stmt.executeQuery(query);
            int id=0,fl_id=0,sl_id=0;
            if (rset.next())
            {
                id = rset.getInt("id");
                fl_id = rset.getInt("fl_id");
                sl_id = rset.getInt("sl_id");
            }
            String question = bean.getQuestion()+"__"+bean.getChoiceA()+"__"+bean.getChoiceB()+"__"+bean.getChoiceC()+"__"+bean.getChoiceD();
            String right = bean.getRightAnswer();
            
            query = "INSERT INTO question(question_id, fl_id, sl_id, tl_id,question,correctAnswer,difficulty,package_id) "
                    + "VALUES('"+max+"','"+fl_id+"','"+sl_id+"','"+id+"','"+question+"','"+right+"','0','0');";
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
