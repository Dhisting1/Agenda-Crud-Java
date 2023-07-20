package br.com.crud.interfaces;


import br.com.crud.dao.ContatoDAO;
import br.com.crud.model.Contato;

import java.sql.SQLException;
import java.util.List;

public interface IContatoDAO {
    void save(Contato contato) throws SQLException ;
    void update(Contato contato) throws SQLException;
    void removerIdUser(int id) throws SQLException;
    List<Contato> getContatos() throws SQLException;
}
