/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RegServ;

import java.util.*;
import java.sql.*;

/**
 *
 * @author rock
 */
public class NewUser 
{
    static Connection con=null;

    public static RegBean register(RegBean bean) throws SQLException
    {
        String fname=bean.getFirstname();
        String lname=bean.getLastname();
        String useremail= bean.getUseremail();
        String userpassword=bean.getUserpassword();
        int id=0;
        boolean committed=false;
        Statement check=null, stmt=null, stmt1=null;
        ResultSet rset=null;

            try
            {
                con=ConDB.ConnectDB.getConn();
                check = con.createStatement();
                stmt = con.createStatement();
                stmt1 = con.createStatement();
                String query ="SELECT email FROM USER WHERE email='"+useremail+"';";
                
                rset=check.executeQuery(query);
                if (rset.next())
                {
                    bean.setHasUser(true);
                }
                else{
                    query = "SELECT MAX(user_id) AS max FROM USER;";
                    rset=stmt1.executeQuery(query);
                    if (rset.next())
                    {
                        id=rset.getInt("max");
                        id = id+1;
                    }
                    try{
                        String insertQ1 = "Insert into USER(user_id, firstname, lastname, email, password)"
                                + "VALUES('"+id+"','"+fname+"','"+lname+"','"+useremail+"','"+userpassword+"');"; 
                            stmt.executeUpdate(insertQ1);
                            
                        String insertQ2 = "Insert into PLAYER(user_id, highscore, ispaid, point)"
                                + "VALUES('"+id+"','"+0+"','"+0+"','"+0+"');";
                            stmt.executeUpdate(insertQ2);                          

                            con.commit();
                            committed = true;
                    }
                    finally{
                        if (!committed)
                        {
                            con.rollback();
                        }
                    }
                }

            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            finally
            {
                ConDB.ConnectDB.disconDB();
                if (rset!= null) rset.close(); 
                if (stmt!= null) stmt.close();
            }
        return bean;
    }
}