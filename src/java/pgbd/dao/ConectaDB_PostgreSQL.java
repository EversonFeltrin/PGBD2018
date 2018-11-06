/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cassi
 */
public class ConectaDB_PostgreSQL {

   private static final String serverName = "localhost:5432"; //caminho do servidor do BD
   private static final String mydatabase = "TrabPGBD";     //nome do BD
   private static final String url = "jdbc:postgresql://" + serverName + "/" + mydatabase;
   private static final String username = "postgres";        //nome de usuário de seu BD
   private static final String password = "123456";        //senha de acesso ao BD

   public static void main(String args[]) {
      new ConectaDB_PostgreSQL().getConexao();
   }

   public static Connection getConexao() {
      Connection conn = null;
      try {
         String driverName = "org.postgresql.Driver";
         Class.forName(driverName);
         conn = DriverManager.getConnection(url, username, password);
         if (conn != null) {
            System.out.println("conectou PostgreSQL");
         } else {
            System.out.println("não conectou PostgreSQL");
         }
      } catch (ClassNotFoundException ex) { //Driver não encontrado
         ex.printStackTrace();
      } catch (SQLException e) {  //Não conecta BD
         e.printStackTrace();
      }
      return conn;
   }
}
