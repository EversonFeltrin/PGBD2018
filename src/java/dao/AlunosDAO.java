/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Alunos;

/**
 *
 * @author cassi
 */
interface AlunosDAO {

   public Alunos create(Alunos a);

   public void update(long id, Alunos a);

   public void delete(long id);

   public Alunos findByName(String name);
}
