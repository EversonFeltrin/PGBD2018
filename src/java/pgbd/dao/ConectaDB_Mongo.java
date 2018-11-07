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
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ConnectionString;
import com.mongodb.DBObject;
import java.util.List;
import pgbd.model.Alunos;




/**
 *
 * @author efelt
 */
public class ConectaDB_Mongo {
    private static final String mongoDatabase = "trabPGBD";
    //cuidar nome da coleção para não gerar uma nova
    private static final String  mongoCollection = "alunos";
    
    public static void main (String[] args){
        new ConectaDB_Mongo().getConexao();
    }
    
    public DBCollection getConexao(){
        MongoClient mongoClient = null;
        DB db = null;
        DBCollection collection = null;
        //DBCursor cursor = null;
        try{
            mongoClient = new MongoClient();
            db = mongoClient.getDB(mongoDatabase);
            collection = db.getCollection(mongoCollection);
            //cursor = collection.find();
        }catch(Exception e){
            System.out.println("e");
        }
        System.out.println("Server pronto!");
        return collection;
    }
            
            
}