/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.model;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.util.Date;

/**
 *
 * @author cassi
 */
public class Atividades {
   private int idAtividade;
   private string classificacao;
   private string localAtividade;
   private Date dataIni;
   private Date dataFim;
   private int cargaHoraria;
   private string atividadeDesenvolvida;
   private Date dataSubmissao; 
   private int idAluno;

   public int getIdAtividade() {
      return idAtividade;
   }

   public void setIdAtividade(int idAtividade) {
      this.idAtividade = idAtividade;
   }

   public string getClassificacao() {
      return classificacao;
   }

   public void setClassificacao(string classificacao) {
      this.classificacao = classificacao;
   }

   public string getLocalAtividade() {
      return localAtividade;
   }

   public void setLocalAtividade(string localAtividade) {
      this.localAtividade = localAtividade;
   }

   public Date getDataIni() {
      return dataIni;
   }

   public void setDataIni(Date dataIni) {
      this.dataIni = dataIni;
   }

   public Date getDataFim() {
      return dataFim;
   }

   public void setDataFim(Date dataFim) {
      this.dataFim = dataFim;
   }

   public int getCargaHoraria() {
      return cargaHoraria;
   }

   public void setCargaHoraria(int cargaHoraria) {
      this.cargaHoraria = cargaHoraria;
   }

   public string getAtividadeDesenvolvida() {
      return atividadeDesenvolvida;
   }

   public void setAtividadeDesenvolvida(string atividadeDesenvolvida) {
      this.atividadeDesenvolvida = atividadeDesenvolvida;
   }

   public Date getDataSubmissao() {
      return dataSubmissao;
   }

   public void setDataSubmissao(Date dataSubmissao) {
      this.dataSubmissao = dataSubmissao;
   }

   public int getIdAluno() {
      return idAluno;
   }

   public void setIdAluno(int idAluno) {
      this.idAluno = idAluno;
   }
   
}

