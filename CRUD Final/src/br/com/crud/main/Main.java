package br.com.crud.main;

import br.com.crud.dao.ContatoDAO;
import br.com.crud.interfaces.IContatoDAO;
import br.com.crud.model.Contato;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        IContatoDAO contatoDAO = new ContatoDAO();
        Scanner input = new Scanner(System.in);

        boolean sair = false;

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
                    //Adicionando contato
                    Contato contato1 = new Contato();

                    System.out.println("Digite o nome do contato: ");
                        String nomeContato = input.nextLine();
                        contato1.setNome(nomeContato);
                    System.out.println("Digite o telefone do contato: ");
                        String telefoneContato = input.nextLine();
                        contato1.setTelefone(telefoneContato);
                    System.out.println("Digite o email do contato: ");
                        String emailContato = input.nextLine();
                        contato1.setEmail(emailContato);
                    System.out.println("Digite o cpf do contato: ");
                        String cpfContato = input.nextLine();
                        contato1.setCpf(cpfContato);
                    System.out.println("Digite a idade do contato: ");
                        int idadeContato = input.nextInt();
                        contato1.setIdade(idadeContato);

                    contatoDAO.save(contato1);
                    break;
                case 2:
                    //Atualizando um contato
                    Contato atualizaContato = new Contato();
                    System.out.println("Digite o id do contato que deseja atualizar: ");
                        atualizaContato.setId(input.nextInt());
                        input.nextLine();
                    System.out.println("Digite o nome do contato: ");
                        atualizaContato.setNome(input.nextLine());
                    System.out.println("Digite o telefone do contato: ");
                        atualizaContato.setTelefone(input.nextLine());
                    System.out.println("Digite o email do contato: ");
                        atualizaContato.setEmail(input.nextLine());
                    System.out.println("Digite o cpf do contato: ");
                        atualizaContato.setCpf(input.nextLine());
                    System.out.println("Digite a idade do contato: ");
                        atualizaContato.setIdade(input.nextInt());
                    contatoDAO.update(atualizaContato);
                    break;
                case 3:
                    //Deletando um contato
                    System.out.println("Digite o id do contato que deseja remover: ");
                    int id = input.nextInt();
                    contatoDAO.removerIdUser(id);
                    break;
                case 4:
                    //Percorrer a lista de contatos usando o forEach
                   List<Contato> contatos = contatoDAO.getContatos();
                    for (Contato c : contatos) {
                        System.out.println("Id: " + c.getId());
                        System.out.println("Nome: " + c.getNome());
                        System.out.println("Telefone: " + c.getTelefone());
                        System.out.println("Email: " + c.getEmail());
                        System.out.println("CPF: " + c.getCpf());
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
