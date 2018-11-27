/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pgbd.model.Alunos;
import pgbd.model.Atividades;

/**
 *
 * @author cassi
 */
public class AlunosDAOPostgreSQL {

   private Connection conn = null;

//   public AlunosDAOPostgreSQL() {
//      conn = ConectaDB_PostgreSQL.getConexao();
//   }

   public int create(Alunos a) {
//       int idAluno = geraIdAluno();
       a.setIdAluno(geraIdAluno());
       try(Connection conn = new ConectaDB_PostgreSQL().getConexao()) {
         String sql = "INSERT INTO aluno(idAluno, nome, matricula) VALUES (?, ?, ?)";
         PreparedStatement pre = conn.prepareStatement(sql);
         pre.setInt(1, a.getIdAluno());
         pre.setString(2, a.getNome());
         pre.setString(3, a.getMatricula());
         if (pre.executeUpdate() > 0){
                System.out.println("\nAluno adicionado com sucesso");
                return a.getIdAluno();
            }   
         
        } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);
        }
        return 0;
   }
   public Alunos read_aluno(String nome, String matricula){
      try(Connection conn = new ConectaDB_PostgreSQL().getConexao()){
          String sql = "SELECT * FROM aluno WHERE nome = ? AND matricula = ?";
        
          PreparedStatement pre = conn.prepareStatement(sql);
          pre.setString( 1, nome);
          pre.setString( 2, matricula);
          
          ResultSet rs = pre.executeQuery();
          
          Alunos a = new Alunos();
          while(rs.next()){
              a.setIdAluno(rs.getInt("idAluno"));
              a.setNome(rs.getString("nome"));
              a.setMatricula(rs.getString("matricula"));
          }
          return a;
      }
      catch(SQLException e){
          e.printStackTrace();
      }
       return null;
   } 
   public Alunos read_aluno(int idAluno) {
      Alunos a = new Alunos();
      String sql = "SELECT * FROM aluno WHERE idAluno = ?";

      try (Connection conn = new ConectaDB_PostgreSQL().getConexao()){
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setInt(1, idAluno);
         ResultSet rs = stmt.executeQuery();

         while (rs.next()) {
            a.setIdAluno(rs.getInt("idAluno"));
            a.setNome(rs.getString("nome"));
            a.setMatricula(rs.getString("matricula"));
         }
         return a;
      } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);
         return null;
      }
   }
//
//   public boolean update_aluno(int idAluno, Alunos a) {
//      String sql = "UPDATE alunos SET nome = ?, matricula = ? WHERE idAluno = ?";
//
//      try {
//         conn = ConectaDB_PostgreSQL.getConexao();
//         PreparedStatement stmt = conn.prepareStatement(sql);
//         stmt.setString(1, a.getNome());
//         stmt.setString(2, a.getMatricula());
//         stmt.setInt(3, idAluno);
//         System.out.println("\nAluno editado com sucesso");
//         if(stmt.executeUpdate() >0){
//            return true;
//         }
//      } catch (SQLException e) {
//         System.out.println("Ocorreu um erro: " + e);
//      }
//      return false;
//   }
//
//   public void delete_aluno(int id) {
//      // Para deletar um aluno é necessário deletar todas as atividades do mesmo
//      String sql0 = "DELETE FROM atividade WHERE idAluno = ?";
//      String sql1 = "DELETE FROM alunos WHERE idaluno = ?";
//
//      try {
//         conn = ConectaDB_PostgreSQL.getConexao();
//
//         PreparedStatement stmt1 = conn.prepareStatement(sql0);
//         stmt1.setInt(1, id);
//         stmt1.executeUpdate();
//
//         PreparedStatement stmt = conn.prepareStatement(sql1);
//         stmt.setInt(1, id);
//         stmt.executeUpdate();
//         System.out.println("Aluno Deletado do Banco");
//      } catch (SQLException e) {
//         System.out.println("Ocorreu um erro: " + e);
//      }
//   }
//   
//   public ArrayList<Atividades> setArrayAtividades(ArrayList<Atividades> arrayAtiv, Atividades at){
//       arrayAtiv.add(at);
//       return arrayAtiv;
//   }
//   
////   public ArrayList<Atividades> getArrayAtividades(ArrayList<Atividades> arrayAtiv){
////       
////   }
//   
   public int geraIdAluno(){
        int val = -1;
        try(Connection conn = new ConectaDB_PostgreSQL().getConexao()){
            String sql = "select max(idAluno) from aluno;";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            rs.next();
            long countLong = rs.getLong(1);
            //retorna o proximo ID disponível
            val = (int)countLong + 1;
            return val;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return val;
    }
}
