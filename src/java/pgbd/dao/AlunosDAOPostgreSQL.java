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
   
   public void create(Alunos a){
      String sql = "INSERT INTO alunos (idAluno, nome, matricula) VALUES (?, ?, ?)";
      
      try {
         conn = ConectaDB_PostgreSQL.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setInt(1, a.getIdAluno());
         stmt.setString(2, a.getNome());
         stmt.setString(3, a.getMatricula());
         stmt.execute();
         System.out.println("\nAluno adicionado com sucesso");
      } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);
      }
   }
   
   public void update_aluno(int idAluno, Alunos a){
      String sql = "UPDATE alunos SET nome = ?, matricula = ? WHERE idAluno = ?";
      
      try {
         conn = ConectaDB_PostgreSQL.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setString(1,a.getNome());
         stmt.setString(2,a.getMatricula());
         stmt.setInt(3,idAluno);
         System.out.println("\nAluno editado com sucesso");
      } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);
      }
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
