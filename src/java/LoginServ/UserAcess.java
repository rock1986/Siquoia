/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LoginServ;

import java.util.*;
import java.sql.*;

/**
 *
 * @author rock
 */
public class UserAcess 
{
    static Connection con=null;
    static ResultSet rset=null ,rset1=null;

    public static LoginBean login(LoginBean bean) throws SQLException
    {
        String useremail= bean.getUseremail();
        String userpassword=bean.getUserpassword();
        
        Statement stmt = null;
            try
            {
                con=ConDB.ConnectDB.getConn();
                stmt = con.createStatement();
                String query="SELECT user_id, firstname, lastname, email, password "
                                              + "FROM user "
                                              + "WHERE email='" +useremail+"' and user_id IN"
                                                + "(SELECT admin_id FROM admin);";
                rset=stmt.executeQuery(query);
                if (rset.next())
                {
                    if (rset.getString("password").equals(userpassword))
                    {
                        String FirstName=rset.getString("firstname");
                        String LastName=rset.getString("lastname");
                        int id = rset.getInt("user_id");
                        bean.setFirstname(FirstName);
                        bean.setLastname(LastName);
                        bean.setVaild(true);
                        bean.setId(id);                           
                        bean.setAdmin(true);
                    }
                    else
                    {
                        bean.setVaild(false);
                        bean.setStatus("InvalidPassword");
                    }                    
                }
                else
                {
                    query="SELECT user.user_id, firstname, lastname, email, password, ispaid, highscore, point "
                                              + "FROM player, user, admin "
                                              + "WHERE player.user_id=user.user_id and email='" +useremail+"';"; 
                    rset=stmt.executeQuery(query);
                    if (rset.next())
                    {
                        //user login
                        if (rset.getString("password").equals(userpassword))
                        {      
                            String FirstName=rset.getString("firstname");
                            String LastName=rset.getString("lastname");
                            int id = rset.getInt("user_id");
                            int highscore=rset.getInt("highscore");
                            int point=rset.getInt("point");

                            bean.setIspaid(rset.getBoolean("ispaid"));
                            bean.setHighscore(highscore);
                            bean.setPoint(point);
                            bean.setVaild(true);
                            bean.setFirstname(FirstName);
                            bean.setLastname(LastName);
                            bean.setId(id);                        
                        }
                        else
                        {
                            bean.setVaild(false);
                            bean.setStatus("InvalidPassword");
                        }
                    }
                    else
                    {
                        bean.setVaild(false);
                        bean.setStatus("InvalidUser");
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
                if (rset1!= null) rset1.close();
                if (stmt!= null) stmt.close();
            }
        return bean;
    }
}