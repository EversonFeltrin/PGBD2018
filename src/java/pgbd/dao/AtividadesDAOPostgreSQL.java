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

   }

   public void update_atividade(int idAtividade, Atividades a) {

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
