/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.dao;

import pgbd.model.Atividades;

/**
 *
 * @author cassi
 */
interface AtividadesDAO {
   public void create(Atividades a);

   public void update_atividade(int idAtividade, Atividades a);
   
   public Atividades read_atividade(int idAtividade);

   public void delete_atividade(int idAtividade);
}
