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
interface AlunosDAO {

   public void create(Alunos a);

   public void update_aluno(int id, Alunos a);
   
   public Alunos read_aluno(int idAluno);

   public void delete_aluno(int id);
}
