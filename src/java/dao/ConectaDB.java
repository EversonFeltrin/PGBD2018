package dao;

public class ConectaDB {
    private static final String url = "";
    private static final String user = "";
    private static final String pass = "";
    private static final String banco = "mongo";
    
    public static void main (String args[]){
        //vai testar conforme a definição do nome do banco qual conexão levantar
        if (banco.equals("mongo")){
            System.out.println("Conectado ao MongoDB");
        }
        else {
            System.out.println("Conectado ao MySqlDB");
        }
        
    }
    
    
    
}
