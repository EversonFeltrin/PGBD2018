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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pgbd.model.Alunos;
import pgbd.model.Atividades;

/**
 *
 * @author cassi
 */
public class AtividadesDAOPostgreSQL {

//   private Connection conn = null;
//
//   public AtividadesDAOPostgreSQL() {
//      conn = ConectaDB_PostgreSQL().getConexao();
//   }
//
   public int create(Atividades a) {
      a.setIdAtividade(geraIdAtividade());
      try (Connection conn = new ConectaDB_PostgreSQL().getConexao()){
         String sql = "INSERT INTO atividade (id_atividade, classificacao, "
                 + "local_atividade, data_ini, data_fim, carga_horaria, "
                 + "atividade_desenvolvida, data_submissao, id_aluno) "
                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
 
         PreparedStatement pre = conn.prepareStatement(sql);
         pre.setInt(1, a.getIdAtividade());
         pre.setString(2, a.getClassificacao());
         pre.setString(3, a.getLocalAtividade());
         pre.setString(4, a.getDataIni());
         pre.setString(5, a.getDataFim());
         pre.setInt(6, a.getCargaHoraria());
         pre.setString(7, a.getAtividadeDesenvolvida());
         pre.setString(8, a.getDataSubmissao());
         pre.setInt(9, a.getIdAluno());
         
         if (pre.executeUpdate() > 0){
             System.out.println("Atividade adicionada com sucesso...\n");
             return a.getIdAtividade();
         }
      } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);
      }
      return 0;
   }
//
//   public boolean update_atividade(int idAtividade, Atividades a) {
//      String sql = "UPDATE atividade SET classificacao = ?, localAtividade = ?, dataIni = ?, dataFim = ?, cargaHoraria = ?, atividadeDesenvolvida = ?, dataSubmissao = ?, idAluno = ? WHERE idAtividade = ?";
//      
//      try {
//         conn = ConectaDB_PostgreSQL.getConexao();
//         PreparedStatement stmt = conn.prepareStatement(sql);
//         stmt.setString(1, a.getClassificacao());
//         stmt.setString(2, a.getLocalAtividade());
//         stmt.setString(3, a.getDataIni());
//         stmt.setString(4, a.getDataFim());
//         stmt.setInt(5, a.getCargaHoraria());
//         stmt.setString(6, a.getAtividadeDesenvolvida());
//         stmt.setString(7, a.getDataSubmissao());
//         stmt.setInt(8, a.getAluno().getIdAluno());
//         stmt.setInt(9, a.getIdAtividade());
//         System.out.println("Atividade atualizada com sucesso");
//         if(stmt.executeUpdate() >0){
//            return true;
//         }
//      } catch (SQLException e) {
//         System.out.println("Ocorreu um erro: " + e);
//      }
//      return false;
//   }
//
//   public Atividades read_atividade(int idAtividade) {
//      Atividades a = new Atividades();
//      Alunos al = new Alunos();
//      
//      String sql = "SELECT * FROM atividade a join alunos al on a.idAluno = al.idAluno WHERE a.idAtividade = ?";
//
//      try {
//         conn = ConectaDB_PostgreSQL.getConexao();
//         PreparedStatement stmt = conn.prepareStatement(sql);
//         stmt.setInt(1, idAtividade);
//         ResultSet rs = stmt.executeQuery();
//
//         while (rs.next()) {
//            a.setIdAtividade(rs.getInt("idAtividade"));
//            a.setClassificacao(rs.getString("classificacao"));
//            a.setLocalAtividade(rs.getString("localAtividade"));
//            a.setDataIni(rs.getString("dataIni"));
//            a.setDataFim(rs.getString("dataFim"));
//            a.setCargaHoraria(rs.getInt("cargaHoraria"));
//            a.setAtividadeDesenvolvida(rs.getString("atividadeDesenvolvida"));
//            a.setDataSubmissao(rs.getString("dataSubmissao"));
//            al.setIdAluno(rs.getInt("idAluno"));
//            a.setAluno(al);
//         }
//         return a;
//      } catch (SQLException e) {
//         System.out.println("Ocorreu um erro: " + e);
//         return null;
//      }
//
//   }
//
//   public void delete_atividade(int idAtividade) {
//      String sql = "DELETE FROM atividade WHERE idAtividade = ?";
//
//      try {
//         conn = ConectaDB_PostgreSQL.getConexao();
//
//         PreparedStatement stmt1 = conn.prepareStatement(sql);
//         stmt1.setInt(1, idAtividade);
//         stmt1.executeUpdate();
//         System.out.println("Atividade Deletada do Banco");
//      } catch (SQLException e) {
//         System.out.println("Ocorreu um erro: " + e);
//      }
//   }
   
   public int geraIdAtividade(){
        int val = -1;
        try(Connection conn = new ConectaDB_PostgreSQL().getConexao()){
            String sql = "select max(id_atividade) from atividade;";
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