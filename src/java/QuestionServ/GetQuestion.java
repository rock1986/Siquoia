/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuestionServ;


import java.sql.*;
import java.util.StringTokenizer;

/**
 *
 * @author rock
 */
public class GetQuestion {     
        static Connection con=null;
        static ResultSet rset=null;
        
    public static QueBean[] getPackage(QueBean[] bean, String level, String category, int id) throws SQLException
    {         
        Statement stmt=null;
        try{
            con = ConDB.ConnectDB.getConn();
            stmt = con.createStatement();
            String query1="";
            if(level.equals("firstlevel"))
            {
               String query ="SELECT id FROM firstlevel WHERE firstlevel='"+category+"'";
               rset = stmt.executeQuery(query);
               if (rset.next())
               {
                    int category_id = rset.getInt("id");
                    query1="SELECT difficulty,question_id,question,correctAnswer FROM question "
                            + "WHERE fl_id='"+category_id+"' and question_id not IN (SELECT question_id FROM player_question WHERE user_id='"+id+"') "
                            + "and package_id IN (SELECT package_id FROM package_player WHERE user_id='"+id+"');";
               }
             }
            
            if(level.equals("secondlevel"))
            {
               String query ="SELECT id FROM secondlevel WHERE secondlevel='"+category+"'";
               rset = stmt.executeQuery(query);
               if (rset.next())
               {
                    int category_id = rset.getInt("id");
                    query1="SELECT difficulty,question_id,question,correctAnswer FROM question "
                            + "WHERE sl_id='"+category_id+"' and question_id not IN (SELECT question_id FROM player_question WHERE user_id='"+id+"') "
                            + "and package_id IN (SELECT package_id FROM package_player WHERE user_id='"+id+"');";
               }
             } 

            if(level.equals("thirdlevel"))
            {
               String query ="SELECT id FROM thirdlevel WHERE thirdlevel='"+category+"'";
               rset = stmt.executeQuery(query);
               if (rset.next())
               {       
                    int category_id = rset.getInt("id");
                    query1="SELECT difficulty,question_id,question,correctAnswer FROM question "
                            + "WHERE tl_id='"+category_id+"' and question_id not IN (SELECT question_id FROM player_question WHERE user_id='"+id+"') "
                            + "and package_id IN (SELECT package_id FROM package_player WHERE user_id='"+id+"');";
                }
            }
                    rset = stmt.executeQuery(query1);
                    int count=0;
                    while(rset.next() && count<10)
                    {
                        String que= rset.getString("question");
                        StringTokenizer st = new StringTokenizer(que,"__");
                        bean[count]=new QueBean();
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
                        String rightAns= rset.getString("correctAnswer");
                        bean[count].setRightAnswer(rightAns);
                        
                        int difficulty = rset.getInt("difficulty");
                        bean[count].setDifficulty(difficulty);
                        
                        int question_id = rset.getInt("question_id");
                        bean[count].setId(question_id);                        

                        count++;
                        
                    }
                }

        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bean;
    }
}