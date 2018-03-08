/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author yasmine
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class db {

    private String queryString;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    String query = new String("select * from Games");
    public static void main(String args[]) {
        db db = new db();

    }

    public db(){
        connect();
    }
        
    public void connect(){
       try{
			 con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/TicTacToe?user=root&password=yasmine123");
			 stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE);
                         rs = stmt.executeQuery(query);
			
	   }
	catch(SQLException ex)
		{
			ex.printStackTrace();
		}
    }
    
    public void disConnect(){
            try{
                stmt.close();
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
    }
    public void write(String [] row)
    {
    	try{
		String values="VALUES ("+"'"+row[0]+"'"+","+"'"+row[1]+"'"+","+"'"+row[2]+"'"+","+"'"+row[3]+"'"+","+"'"+row[4]+"')";
				String insertQuery=new String("INSERT INTO Games(player1Moves,player2Moves,player1Name,player2Name,winner)"+values);
				stmt.executeUpdate(insertQuery);
				rs = stmt.executeQuery(query);
				rs.moveToInsertRow();
	    }
	catch(SQLException ex)
	{
            ex.printStackTrace();
	}
        disConnect();
    }
    public ArrayList<String[]> read()
    {
       ArrayList <String[]>l=new ArrayList<String[]>();
       String []row=new String[6];
        try {
            int m=0;
            while(rs.next()){
                row=new String[6];
                for(int i=0;i<6;i++)
                {
                    
                    try {
                        row[i]=rs.getString(i+1);
                    } catch (SQLException ex) {
                        Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
            l.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        } 
        disConnect();
        return l;
    }
    public void delete(int id)
    {
    
    }
    



}