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

   public boolean update_atividade(Atividades a) {
      try(Connection conn = new ConectaDB_PostgreSQL().getConexao()) {
         String sql = "UPDATE atividade SET classificacao = ?, "
                 + "local_atividade = ?, data_ini = ?, data_fim = ?, "
                 + "carga_horaria = ?, atividade_desenvolvida = ?, "
                 + "data_submissao = ? WHERE id_atividade = ? "
                 + "AND id_aluno = ?";
         
         PreparedStatement pre = conn.prepareStatement(sql);
         pre.setString(1, a.getClassificacao());
         pre.setString(2, a.getLocalAtividade());
         pre.setString(3, a.getDataIni());
         pre.setString(4, a.getDataFim());
         pre.setInt(5, a.getCargaHoraria());
         pre.setString(6, a.getAtividadeDesenvolvida());
         pre.setString(7, a.getDataSubmissao());
         pre.setInt(8, a.getIdAtividade());
         pre.setInt(9, a.getIdAluno());
//         System.out.println("Atividade atualizada com sucesso");;
         if(pre.executeUpdate() >0){
            return true;
         }
      } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);
      }
      return false;
   }

   public Atividades read_atividade(int idAtividade) {
      try (Connection conn = new ConectaDB_PostgreSQL().getConexao()) {
        String sql = "SELECT * FROM atividade WHERE id_atividade = ?";
         
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setInt(1, idAtividade);
         
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Atividades ativ = new Atividades();
            ativ.setIdAtividade(rs.getInt("id_atividade"));
            ativ.setClassificacao(rs.getString("classificacao"));
            ativ.setLocalAtividade(rs.getString("local_atividade"));
            ativ.setDataIni(rs.getString("data_ini"));
            ativ.setDataFim(rs.getString("data_fim"));
            ativ.setCargaHoraria(rs.getInt("carga_horaria"));
            ativ.setAtividadeDesenvolvida(rs.getString("atividade_desenvolvida"));
            ativ.setDataSubmissao(rs.getString("data_submissao"));
            ativ.setIdAluno(rs.getInt("id_aluno"));
//            ativ.setAluno(al);
            return ativ;
         }         
      } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);   
      }
      return null;
   }

   public boolean delete_atividade(int idAtividade) {
      try(Connection conn = new ConectaDB_PostgreSQL().getConexao()) {
         String sql = "DELETE FROM atividade WHERE id_atividade = ?";
         
         PreparedStatement pre = conn.prepareStatement(sql);
         pre.setInt(1, idAtividade);
         if (pre.executeUpdate() > 0){             
             return true;
         }
      } catch (SQLException e) {
         System.out.println("Ocorreu um erro: " + e);
      }
      return false;
   }
   
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