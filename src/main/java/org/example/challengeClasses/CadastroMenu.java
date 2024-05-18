package org.example.challengeClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CadastroMenu {


    private List<Login> cadastros;

    public CadastroMenu() {
        cadastros = new ArrayList<Login>();
    }

    public void cadastra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o email: ");
        String email = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();
        System.out.println("Digite o cpf: ");
        String cpf = scanner.nextLine();
        System.out.println("Digite o nome completo: ");
        String nomeCompleto = scanner.nextLine();
        System.out.println("Digite o telefone: ");
        String telefone = scanner.nextLine();

        Login cadastro = new Login(nome, email, senha, cpf, nomeCompleto);
        cadastro.setTelefone(telefone);
        cadastros.add(cadastro);
    }

    public void listaCadastros() {
        for (Login cadastro : cadastros) {
            System.out.println(cadastro);
        }
    }

    public static void main(String[] args) {
        CadastroMenu menu = new CadastroMenu();
        int opcao;
        do {
            System.out.println("Menu de Cadastro: !");
            System.out.println("1 - Cadastra");
            System.out.println("2 - Lista Todos os Cadastros!");
            System.out.println("3 - Sair!");
            System.out.print("Digite a opcao desejada: ");
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            //====================================================
            switch (opcao) {
                case 1:
                    menu.cadastra();
                    break;
                case 2:
                    menu.listaCadastros();
                    break;
                case 3:
                    System.out.println("Sai do projeto");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (opcao != 3);
    }




}
