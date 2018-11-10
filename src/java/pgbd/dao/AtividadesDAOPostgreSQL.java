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
      String sql = "SELECT * FROM atividades WHERE idAtividade = ?";

      try {
         conn = ConectaDB_PostgreSQL.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql);
         stmt.setInt(1, idAtividade);
         ResultSet rs = stmt.executeQuery();

         while (rs.next()) {
            a.setIdAtividade(rs.getInt("idAtividade"));
            a.setClassificacao(rs.getString("classificacao"));
            a.setLocalAtividade(rs.getString("localAtividade"));
            a.setDataIni(rs.getDate("dataIni"));
            a.setDataFim(rs.getDate("dataFim"));
            a.setCargaHoraria(rs.getInt("cargaHoraria"));
            a.setAtividadeDesenvolvida(rs.getString("atividadeDesenvolvida"));
            a.setDataSubmissao(rs.getDate("dataSubmissao"));
            a.setIdAluno(rs.getInt("idAluno"));
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
