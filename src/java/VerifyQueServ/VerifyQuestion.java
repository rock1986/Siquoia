/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VerifyQueServ;

import LoginServ.AdminBean;
import QuestionServ.QueBean;
import java.sql.*;
import java.util.StringTokenizer;

/**
 *
 * @author rock
 */
public class VerifyQuestion {
    static Connection con;
    static Statement stmt;
    static ResultSet rset;
    
    public static QueBean getSubmittedQue(AdminBean adbean, QueBean bean)
    {
        try{
            con = ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            String query = "SELECT MIN(id),user_id,question,rightAnswer FROM submitted WHERE verified='0';";
            rset = stmt.executeQuery(query);
            
            if (rset.next() && rset.getString("question")!=null)
            {
                String que = rset.getString("question");
                int user_id = rset.getInt("user_id");
                adbean.setUser_id(user_id);
                
                StringTokenizer st = new StringTokenizer(que,"__");
                bean=new QueBean();
                if(st.hasMoreTokens())
                {
                    bean.setQuestion(st.nextToken());
                }
                while (st.hasMoreTokens())
                {
                    bean.setChoiceA(st.nextToken());
                    bean.setChoiceB(st.nextToken());
                    bean.setChoiceC(st.nextToken());
                    bean.setChoiceD(st.nextToken());
                }
                String rightAns= rset.getString("rightAnswer");
                bean.setRightAnswer(rightAns);                
            }
            else 
                bean.setHasQue(false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConDB.ConnectDB.disconDB();
        }
        return bean;
    }
    
    public static void updateUser(AdminBean bean)
    {
        try{
            con = ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            String query = "UPDATE player SET point=point+1 WHERE user_id = '"+bean.getUser_id()+"';";
            stmt.executeUpdate(query);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConDB.ConnectDB.disconDB();
        }
    }  
    
    public static void updateQuestion(String category, QueBean bean)
    {      
        try{
            con = ConDB.ConnectDB.getConn(); 
            con.setAutoCommit(false);
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
            int row1=stmt.executeUpdate(query);
            
            query = "UPDATE submitted SET verified='1' WHERE question='"+question+"';";
            int row2=stmt.executeUpdate(query);            
            if (row1>0 && row2>0)
                con.commit();
            else
                con.rollback();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            
        }
        finally
        {
            ConDB.ConnectDB.disconDB();
        }
    }
    
    public static void deleteQuestion(QueBean bean)
    {
        try{
            con = ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            String query = "DELETE FROM submitted WHERE question='"+bean.getQuestion()+"';";
            stmt.executeUpdate(query);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConDB.ConnectDB.disconDB();
        }
    }     
}
