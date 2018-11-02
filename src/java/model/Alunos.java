/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.util.ArrayList;

/**
 *
 * @author cassi
 */
public class Alunos {
   private int idAluno;
   private string nome;
   private string matricula;

   public int getIdAluno() {
      return idAluno;
   }

   public void setIdAluno(int idAluno) {
      this.idAluno = idAluno;
   }

   public string getNome() {
      return nome;
   }

   public void setNome(string nome) {
      this.nome = nome;
   }

   public string getMatricula() {
      return matricula;
   }

   public void setMatricula(string matricula) {
      this.matricula = matricula;
   }
   
   private ArrayList<Atividades> atividades;
   
   public ArrayList<Atividades> getAtividades() {
      return atividades;
   }

   public void setAtividades(ArrayList<Atividades> atividades) {
      this.atividades = atividades;
   }
   
}
