/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cassi
 */
public class ConectaDB_PostgreSQL {

   String serverName = "localhost:5432"; //caminho do servidor do BD
   String mydatabase = "TrabPGBD";     //nome do BD
   String url = "jdbc:postgresql://" + serverName + "/" + mydatabase;
   String username = "postgres";        //nome de usuário de seu BD
   String password = "123456";        //senha de acesso ao BD

   public static void main(String args[]) {
      new ConectaDB_PostgreSQL().getConexao();
   }

   public Connection getConexao() {
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
      } catch (ClassNotFoundException | SQLException ex) {
         //Driver não encontrado
               }
      //Não conecta BD
      return conn;
   }
}
