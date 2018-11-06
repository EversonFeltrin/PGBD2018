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

   public boolean create();

   public void update(long id, Alunos a);

   public int delete(long id);

   public Alunos findByName(String name);
}
