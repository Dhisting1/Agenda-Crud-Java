package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    //Nome do Usuário do BD
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    //Conexão com o BD
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/agenda";
    //Criando conexão com o BD
    public static Connection createConnectionToMySQL()  throws Exception{

        //Faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.jdbc.Driver");

        //Criando conexão com o banco
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return (com.mysql.jdbc.Connection) connection;
    }

    //Testando a conexão com o BD
    public static void main(String[] args) throws Exception {
        //Recupera conexão com o BD
        Connection con = createConnectionToMySQL();
        if (con != null) {
            System.out.println("Conexão feita com sucesso!" + con);
            con.close();
        }
    }

}