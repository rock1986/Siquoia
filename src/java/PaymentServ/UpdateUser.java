/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PaymentServ;

import LoginServ.LoginBean;
import java.sql.*;
/**
 *
 * @author rock
 */
public class UpdateUser {
    static Connection con=null;
    
    public static void update(LoginBean lbean) throws SQLException
    {
        int userid = lbean.getId();
        Statement stmt=null;
        try
        {
            con = ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            String query = "UPDATE player SET ispaid='1', highscore='0' WHERE user_id='"+userid+"';";
            stmt.executeUpdate(query);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
                ConDB.ConnectDB.disconDB();
                if (stmt!= null) stmt.close();
        }
    }
}
