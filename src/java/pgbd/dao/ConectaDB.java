package pgbd.dao;


//classes necessaris para uso de BD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConectaDB {
    private static final String banco = "mySql";
    
    public static void main (String args[]){
        
        if (banco.equals("mongo")){
            
            //new ConectaDB().read(2);
            System.out.println("Conectado ao MongoDB");
        }
        else {
            //vai testar conforme a definição do nome do banco qual conexão levantar
            new ConectaDB().getConexaoMySql();
            System.out.println("Conectado ao MySqlDB");
        }
        
    }
    
    
    
    public Connection getConexaoMySql(){
        Connection conn = null;
        String serverName = "localhost:5432"; //caminho do servidor do BD
        String mydatabase = "pgbd2018";     //nome do BD
        String url = "jdbc:postgresql://" + serverName + "/" + mydatabase;
        String username = "postgres";        //nome de usuário de seu BD
        String password = "1234";        //senha de acesso ao BD
        
        try{
            String driverName = "org.postgresql.Driver";
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null){
                System.out.println("conectou MySql");
            }else {
                System.out.println("não conectou MySql");
            }
        } catch(ClassNotFoundException ex){ //Driver não encontrado
            ex.printStackTrace();
        } catch(SQLException e){  //Não conecta BD
            e.printStackTrace();
        }
        return conn;
        
    }
    
    
    
    
    
}
