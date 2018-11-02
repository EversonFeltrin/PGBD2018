/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;





/**
 *
 * @author efelt
 */
public class ConectaDB_Mongo {
    
    public static void main (String[] args){
        try{
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("trabPGBD");
            System.out.println("Conectado com sucesso");
            
        }catch(Exception e){
            System.out.println("e");
        }
        System.out.println("Server pronto!");
    } 
}
