/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectaDB_PostgreSQL {

   private static final String url = 
            "jdbc:postgresql://localhost:5432/TrabPGBD";
    private static final String user = "postgres";
    private static final String pass = "1234";
    
    public static void main (String args[]){
        new ConectaDB_PostgreSQL().getConexao();
    }
    
    public Connection getConexao(){
        Connection conn = null;
        
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,user,pass);
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}