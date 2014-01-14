/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BuyPointServ;

import LoginServ.LoginBean;
import java.sql.*;
/**
 *
 * @author rock
 */
public class AddPoint {
    static Connection con=null;
    static ResultSet rset=null;
    
    public static LoginBean addPoint(LoginBean lbean, BuyPointBean bean) throws SQLException
    {
        int userid = lbean.getId();
        int amount = Integer.parseInt(bean.getAmount());
        int point=0;
        Statement stmt=null;
        try
        {
            con = ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            String query = "SELECT point FROM player WHERE user_id='"+userid+"';";
            rset = stmt.executeQuery(query);
            if (rset.next())
            {
                point = rset.getInt("point");
            }
            
            point = point + amount*10;
            lbean.setPoint(point);
            query = "UPDATE player SET point='"+point+"' WHERE user_id='"+userid+"';";
            stmt.executeUpdate(query);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
                ConDB.ConnectDB.disconDB();
                if (rset!= null) rset.close(); 
                if (stmt!= null) stmt.close();
        }
        return lbean;
    }
}
