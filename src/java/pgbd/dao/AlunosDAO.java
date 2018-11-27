/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.dao;

import pgbd.model.Alunos;

/**
 *
 * @author cassi
 */
public abstract class AlunosDAO {

    public abstract void create(Alunos a);

   public abstract boolean update_aluno(int id, Alunos a);
   
   public abstract Alunos read_aluno(int idAluno);
   
   public abstract Alunos read_aluno(String idAluno);
    
   public abstract void delete_aluno(int id);
}
