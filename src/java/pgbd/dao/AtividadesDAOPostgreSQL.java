/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pgbd.model.Alunos;
import pgbd.model.Atividades;

/**
 *
 * @author cassi
 */
public class AtividadesDAOPostgreSQL {

   private Connection conn = null;

   public AtividadesDAOPostgreSQL() {
      conn = ConectaDB_PostgreSQL.getConexao();
   }

   public void create(Atividades a) {
      String sql = "INSERT INTO atividades (idAtividade, classificacao, localAtividade, dataIni, dataFim, cargaHoraria, atividadeDesenvolvida, dataSubmissao, aluno) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
      try {
         conn = ConectaDB_PostgreSQL.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setInt(1, a.getIdAtividade());
         stmt.setString(2, a.getClassificacao());
         stmt.setString(3, a.getLocalAtividade());
         stmt.setDate(4, (Date) a.getDataIni());
         stmt.setDate(5, (Date) a.getDataFim());
         stmt.setInt(6, a.getCargaHoraria());
         stmt.setString(7, a.getAtividadeDesenvolvida());
         stmt.setDate(8, (Date) a.getDataSubmissao());
         stmt.setInt(9, a.getAluno().getIdAluno());
         stmt.execute();
         System.out.println("\nAtividade adicionada com sucesso");
      } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);
      }
   }
   

   public void update_atividade(int idAtividade, Atividades a) {
      String sql = "UPDATE atividades SET classificacao = ?, localAtividade = ?, dataIni = ?, dataFim = ?, cargaHoraria = ?, atividadeDesenvolvida = ?, dataSubmissao = ?, aluno = ? WHERE idAtividade = ?";
      
      try {
         conn = ConectaDB_PostgreSQL.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setString(1, a.getClassificacao());
         stmt.setString(2, a.getLocalAtividade());
         stmt.setDate(3, (Date) a.getDataIni());
         stmt.setDate(4, (Date) a.getDataFim());
         stmt.setInt(5, a.getCargaHoraria());
         stmt.setString(6, a.getAtividadeDesenvolvida());
         stmt.setDate(7, (Date) a.getDataSubmissao());
         stmt.setInt(8, a.getAluno().getIdAluno());
         stmt.setInt(9, a.getIdAtividade());

         stmt.execute();
         System.out.println("\nAtividade atualizada com sucesso");
      } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);
      }
   }

   public Atividades read_atividade(int idAtividade) {
      Atividades a = new Atividades();
      Alunos al = new Alunos();
      
      String sql = "SELECT * FROM atividades a join alunos al on a.idAluno = al.idAluno WHERE idAtividade = ?";

      try {
         conn = ConectaDB_PostgreSQL.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setInt(1, idAtividade);
         ResultSet rs = stmt.executeQuery();

         while (rs.next()) {
            a.setIdAtividade(rs.getInt("a.idAtividade"));
            a.setClassificacao(rs.getString("a.classificacao"));
            a.setLocalAtividade(rs.getString("a.localAtividade"));
            a.setDataIni(rs.getDate("a.dataIni"));
            a.setDataFim(rs.getDate("a.dataFim"));
            a.setCargaHoraria(rs.getInt("a.cargaHoraria"));
            a.setAtividadeDesenvolvida(rs.getString("a.atividadeDesenvolvida"));
            a.setDataSubmissao(rs.getDate("a.dataSubmissao"));
            al.setIdAluno(rs.getInt("al.idAluno"));
            a.setAluno(al);
         }
         return a;
      } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);
         return null;
      }

   }

   public void delete_atividade(int idAtividade) {
      String sql = "DELETE FROM atividade WHERE idAtividade = ?";

      try {
         conn = ConectaDB_PostgreSQL.getConexao();

         PreparedStatement stmt1 = conn.prepareStatement(sql);
         stmt1.setInt(1, idAtividade);
         stmt1.executeUpdate();
         System.out.println("Atividade Deletada do Banco");
      } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);
      }
   }
}
