/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.model;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.util.ArrayList;

/**
 *
 * @author cassi
 */
public class Alunos {
   private int idAluno;
   private String nome;
   private String matricula;
   private ArrayList<Atividades> atividades;
   private String idAlunoM;

    public String getIdAlunoM() {
        return idAlunoM;
    }

    public void setIdAlunoM(String idAlunoM) {
        this.idAlunoM = idAlunoM;
    }
    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Atividades> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividades> atividades) {
        this.atividades = atividades;
    }
   
   
}
