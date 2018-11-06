/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pgbd.model.Alunos;

/**
 *
 * @author cassi
 */
public class AlunosDAOPostgreSQL {
   private Connection conn = null;
   
   public AlunosDAOPostgreSQL(){
      conn = ConectaDB_PostgreSQL.getConexao();
   }
   
   public void insert_aluno(Alunos a){
      
   }
   
   public void update_aluno(int id, Alunos a){
      
   }
   
   public void delete_aluno(int id){
      // Para deletar um aluno é necessário deletar todas as atividades do mesmo
      String sql0 = "DELETE FROM atividade WHERE id_aluno = ?";
      String sql1 = "DELETE FROM alunos WHERE id = ?";
      
      try {
         conn = ConectaDB_PostgreSQL.getConexao();
         
         PreparedStatement stmt1 = conn.prepareStatement(sql0);
         stmt1.setInt(1, id);
         stmt1.executeUpdate();
         
         PreparedStatement stmt = conn.prepareStatement(sql1);
         stmt1.setInt(1, id);
         stmt1.executeUpdate();
         System.out.println("Aluno Deletado do Banco");
      } catch (SQLException e){
         System.out.println("Ocorreu um erro: " + e);
      }
   }

}
