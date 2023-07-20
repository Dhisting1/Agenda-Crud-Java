package br.com.crud.model;

import java.util.Date;

public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private Date dataCadastro;
    private int idade;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return Integer.parseInt(String.valueOf(this.id));
    }
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }
    public int getIdade() {
        return this.idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getTelefone() {
        return this.telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }
    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getDataCadastro() {
        return this.dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


}