/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgbd.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ConnectionString;
import pgbd.model.Alunos;




/**
 *
 * @author efelt
 */
public class ConectaDB_Mongo {
    
    
    public static void main (String[] args){
        try{
            MongoClient mongoClient = new MongoClient();
            DB db = mongoClient.getDB("trabPGBD");
            System.out.println("Conectado com sucesso");
           
            DBCollection collection = db.getCollection("alunos");
            
            DBCursor cursor = collection.find();
            BasicDBObject document = new BasicDBObject();
            
            document.put("nome","Camilla Bordin Portilho");
            document.put("matricula","2013207542");
            collection.insert(document);
            
            
            int i = 1;
            
            while (cursor.hasNext()){
                System.out.println("Documento Inserido: " + i);
                System.out.println(cursor.next());
                i++;
            }
            
            
            
            
        }catch(Exception e){
            System.out.println("e");
        }
        System.out.println("Server pronto!");
    
    }

    
}