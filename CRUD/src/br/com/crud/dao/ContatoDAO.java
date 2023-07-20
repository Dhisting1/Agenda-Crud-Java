package br.com.crud.dao;

import br.com.crud.factory.ConexaoBD;
import br.com.crud.model.Contato;
import com.mysql.jdbc.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    //Fazendo o CRUD
    public void save(Contato contato) {
        String sql = "INSERT INTO contato(nome, telefone, email, cpf, dataCadastro, idade) VALUES(?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        //Criando uma conexão com o banco de dados
        try {
            conn = ConexaoBD.createConnectionToMySQL();
            //Preparando a query para ser executada
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //Adicionando os valores que serão inseridos pela query
            pstm.setString(1, contato.getNome());
            pstm.setString(2, contato.getTelefone());
            pstm.setString(3, contato.getEmail());
            pstm.setString(4, contato.getCpf());
            pstm.setDate(5, new Date(contato.getDataCadastro().getTime()));
            pstm.setInt(6, contato.getIdade());

            //Executando a query
            pstm.execute();
            System.out.println("Contato salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Contato contato){
        String sql = "UPDATE contato SET nome = ?, telefone = ?, email = ?, cpf = ?, dataCadastro = ?, idade = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Cria uma conexão com o banco
            conn = ConexaoBD.createConnectionToMySQL();
            //Cria uma PreparedStatment, classe usada para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //Adiciona o valor dos parâmetros da sql
            pstm.setString(1, contato.getNome());
            pstm.setString(2, contato.getTelefone());
            pstm.setString(3, contato.getEmail());
            pstm.setString(4, contato.getCpf());
            pstm.setDate(5, new Date(contato.getDataCadastro().getTime()));
            pstm.setInt(6, contato.getIdade());
            //Qual o id do contato que será atualizado
            pstm.setInt(7, contato.getId());

            pstm.execute();

        }catch (Exception e){
            //Imprime o erro no console
            e.printStackTrace();
        }finally {
            //Fecha as conexões
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void removerIdUser(int id){
        String sql = "DELETE FROM contato WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBD.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Contato> getContatos() throws SQLException {
        String sql = "SELECT * FROM contato";
        List<Contato> contatos = new ArrayList<Contato>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que recupera os dados do banco de dados
        ResultSet resultSet = null;

        try {
            ConexaoBD ConnectionFactory = null;
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            resultSet = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, o while abaixo adiciona os dados na lista de contatos e exibe no console
            while (resultSet.next()) {
                Contato contato = new Contato();
                contato.setId(resultSet.getInt("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setTelefone(resultSet.getString("telefone"));
                contato.setEmail(resultSet.getString("email"));
                contato.setCpf(resultSet.getString("cpf"));
                contato.setDataCadastro(resultSet.getDate("dataCadastro"));
                contato.setIdade(resultSet.getInt("idade"));

                contatos.add(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (resultSet != null){
                    resultSet.close();
                }
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return contatos;
        }
    }
}