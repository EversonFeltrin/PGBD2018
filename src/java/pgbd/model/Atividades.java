/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.model;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.util.Date;
import java.util.ArrayList;
import pgbd.model.Alunos;


/**
 *
 * @author cassi
 */
public class Atividades {
   private int idAtividade;
   private String classificacao;
   private String localAtividade;
   private String dataIni;
   private String dataFim;
   private int cargaHoraria;
   private String atividadeDesenvolvida;
   private String dataSubmissao; 
   private Alunos aluno;

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getLocalAtividade() {
        return localAtividade;
    }

    public void setLocalAtividade(String localAtividade) {
        this.localAtividade = localAtividade;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getAtividadeDesenvolvida() {
        return atividadeDesenvolvida;
    }

    public void setAtividadeDesenvolvida(String atividadeDesenvolvida) {
        this.atividadeDesenvolvida = atividadeDesenvolvida;
    }

    public String getDataSubmissao() {
        return dataSubmissao;
    }

    public void setDataSubmissao(String dataSubmissao) {
        this.dataSubmissao = dataSubmissao;
    }

    public Alunos getAluno() {
        return aluno;
    }

    public void setAluno(Alunos aluno) {
        this.aluno = aluno;
    }

   
}

