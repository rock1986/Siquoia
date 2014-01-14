/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BuyPackageServ;
 
/**
 *
 * @author rock
 */
import java.sql.*;

public class UpdateInfo {
    static Connection con;
    static Statement stmt;
    
    public static int getPackageId(String name)
    {
        int package_id=0;
        try{
            con= ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            String query = "SELECT package_id FROM package WHERE category='"+name+"';";
            ResultSet rset = stmt.executeQuery(query);
            
            if (rset.next())
            {
                package_id = rset.getInt("package_id");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConDB.ConnectDB.disconDB();
        }  
        return package_id;
    }

    public static int getPackagePrice(String name)
    {
        int price=0;
        try{
            con= ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            String query = "SELECT price FROM package WHERE category='"+name+"';";
            ResultSet rset = stmt.executeQuery(query);
            
            if (rset.next())
            {
                price = rset.getInt("price");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConDB.ConnectDB.disconDB();
        }  
        return price;
    }
    
    public static void updateInfo(int user_id, int package_id, int price)
    {
        try{
            con= ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            String query = "INSERT INTO package_player(user_id,package_id) VALUES('"+user_id+"', '"+package_id+"');";
            stmt.executeUpdate(query);
            
            query = "SELECT point FROM player WHERE user_id='"+user_id+"';";
            ResultSet rset = stmt.executeQuery(query);
            if (rset.next())
            {
                int point = rset.getInt("point");
                point = point - price;
                
                query = "UPDATE player SET point='"+point+"' WHERE user_id='"+user_id+"';";
                stmt.executeUpdate(query);
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConDB.ConnectDB.disconDB();
        }
        
    }
}
