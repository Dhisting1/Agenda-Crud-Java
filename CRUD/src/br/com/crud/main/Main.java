package br.com.crud.main;

import br.com.crud.dao.ContatoDAO;
import br.com.crud.model.Contato;

import java.sql.SQLException;
import java.util.Date;
import  java.util.List;
import java.util.Scanner;

public class Main {
    private static Object ContatoDAO;

    public static void main(String[] args) throws SQLException {

        ContatoDAO contatodao = new ContatoDAO();
        Scanner input = new Scanner(System.in);

        boolean sair = false;

        Object contatoDAO;

        while (!sair) {
            System.out.println("Seleciona uma opção: ");
            System.out.println("1 - Criar contato");
            System.out.println("2 - Atualizar contato");
            System.out.println("3 - Deletar contato");
            System.out.println("4 - Listar todos os contatos");
            System.out.println("5 - Sair");

            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    // Criando um contato
                    Contato contato = new Contato();

                    System.out.println("Digite o nome do contato: ");
                    contato.setNome(input.nextLine());
                    System.out.println("Digite o telefone do contato: ");
                    contato.setTelefone(input.nextLine());
                    System.out.println("Digite o email do contato: ");
                    contato.setEmail(input.nextLine());
                    System.out.println("Digite o cpf do contato: ");
                    contato.setCpf(input.nextLine());
                    System.out.println("Digite a idade do contato: ");
                    contato.setIdade(input.nextInt());
                    contato.setDataCadastro(new Date());
                    contatodao.save(contato);

                    break;
                case 2:
                    //Atualizando um contato
                    Contato c1 = new Contato();
                    System.out.println("Digite o id do contato que deseja atualizar: ");
                    c1.setId(input.nextInt());
                    input.nextLine();
                    System.out.println("Digite o nome do contato: ");
                    c1.setNome(input.nextLine());
                    System.out.println("Digite o telefone do contato: ");
                    c1.setTelefone(input.nextLine());
                    System.out.println("Digite o email do contato: ");
                    c1.setEmail(input.nextLine());
                    System.out.println("Digite o cpf do contato: ");
                    c1.setCpf(input.nextLine());
                    System.out.println("Digite a idade do contato: ");
                    c1.setIdade(input.nextInt());
                    c1.setDataCadastro(new Date());

                    contatodao.update(c1);
                    break;
                case 3:
                    //Deletando um contato
                    System.out.println("Digite o id do contato que deseja deletar: ");
                    int id = input.nextInt();
                    contatodao.removerIdUser(id);
                    break;
                case 4:
                    //Percorrer a lista de contatos usando o forEach
                    for (Contato c : contatodao.getContatos()) {
                        System.out.println("Id: " + c.getId());
                        System.out.println("Nome: " + c.getNome());
                        System.out.println("Telefone: " + c.getTelefone());
                        System.out.println("Email: " + c.getEmail());
                        System.out.println("CPF: " + c.getCpf());
                        System.out.println("Data de Cadastro: " + c.getDataCadastro());
                        System.out.println("Idade: " + c.getIdade());
                        System.out.println("--------------------------------------------------");
                    }
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}





        //Deletando um contato


