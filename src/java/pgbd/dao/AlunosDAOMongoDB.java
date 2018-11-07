/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.dao;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.List;
import pgbd.model.Alunos;

/**
 *
 * @author efelt
 */
public class AlunosDAOMongoDB {
    
    public static void main (String args[]){
        Alunos aluno = new Alunos();
        aluno.setNome("Camilla Bordin Portilho");
        aluno.setMatricula("201320742");
       //new AlunosDAOMongoDB().create(aluno);
    }
    
    
    public void create(Alunos a){
        DBCollection collection = new ConectaDB_Mongo().getConexao();
        
        /*try(){
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }*/
        DBCursor cursor = collection.find();
        int i = 1;
            
            while (cursor.hasNext()){
                System.out.println("Documento Inserido: " + i);
                System.out.println(cursor.next());
                i++;
            }
        
        BasicDBObject comparaQuery = new BasicDBObject("nome", "Camilla Bordin Portilho");
                
        //UPDATE ou INSERT
        //cria o array de atividades para linkar ao usuario
        List<Object> atividadesDBList = new BasicDBList();
        DBObject atividadeDBObject = new BasicDBObject();
           
        atividadeDBObject.put("classificacao","teste a mais");
        atividadeDBObject.put("localAtividade", "São Paulo");
        atividadeDBObject.put("dataIni", "20/10/2018");
        atividadeDBObject.put("dataFim", "22/10/2018");
        atividadeDBObject.put("cargaHoraria", "50");
        atividadeDBObject.put("atividadeDesenvolvida", "Ouvinte");
        atividadeDBObject.put("dataSubmissao", "02/11/2018");
        atividadesDBList.add(atividadeDBObject);
 
        //insere alunos no banco de dados
        BasicDBObject aluno = new BasicDBObject();
        aluno.put("nome","Camilla Bordin Portilho");
        aluno.put("matricula","2013207542");
        aluno.put("atividade",atividadesDBList);
            
        //collection.insert(aluno);    
        //collection.update(comparaQuery, aluno);
        i = 1;
            
        while (cursor.hasNext()){
            System.out.println("Documento Inserido: " + i);
            System.out.println(cursor.next());
            i++;
        }
        
        //return false;
    }
        
        
    /*
    DBCollection collection = db.getCollection("alunos");
    DBCursor cursor = collection.find();
            
            BasicDBObject comparaQuery = new BasicDBObject("nome", "Camilla Bordin Portilho");
                
            //UPDATE ou INSERT
            //cria o array de atividades para linkar ao usuario
            List<Object> atividadesDBList = new BasicDBList();
            DBObject atividadeDBObject = new BasicDBObject();
            
            atividadeDBObject.put("classificacao","teste a mais");
            atividadeDBObject.put("localAtividade", "São Paulo");
            atividadeDBObject.put("dataIni", "20/10/2018");
            atividadeDBObject.put("dataFim", "22/10/2018");
            atividadeDBObject.put("cargaHoraria", "50");
            atividadeDBObject.put("atividadeDesenvolvida", "Ouvinte");
            atividadeDBObject.put("dataSubmissao", "02/11/2018");
            atividadesDBList.add(atividadeDBObject);
 
            //insere alunos no banco de dados
            BasicDBObject aluno = new BasicDBObject();
            aluno.put("nome","Camilla Bordin Portilho");
            aluno.put("matricula","2013207542");
            aluno.put("atividade",atividadesDBList);
            
            
            collection.update(comparaQuery, aluno);
            
            int i = 1;
            
            while (cursor.hasNext()){
                System.out.println("Documento Inserido: " + i);
                System.out.println(cursor.next());
                i++;
            }
            
            
            //DELETE
            BasicDBObject deleteQuery = new BasicDBObject();
            deleteQuery.put("nome","Evandro");
            
            //DBCursor cursor;
            cursor = collection.find(deleteQuery);
            
            while(cursor.hasNext()){
                DBObject registro = cursor.next();
                collection.remove(registro);
            }
             
            //int i = 1;
            /*
            while (cursor.hasNext()){
                System.out.println("Documento Inserido: " + i);
                System.out.println(cursor.next());
                i++;
            }
            */
        

       
}
