package ConDB;
import java.sql.*;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rock
 */

public class ConnectDB {

    static Connection conn = null;

    public static Connection getConn() {

        String mysJDBCDriver = "com.mysql.jdbc.Driver";
        String mysURL = "jdbc:mysql://localhost:3306/siquoia";
        String mysUserID = "root";
        String mysPassword = "rock";


        try {
            Class.forName(mysJDBCDriver).newInstance();
            
            //connect to the database
            conn = java.sql.DriverManager.getConnection(mysURL, mysUserID, mysPassword);
            System.out.println("Connected successfully to database using JConnect");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void disconDB(){
        try{conn.close();}catch(Exception ee){};
    }
}