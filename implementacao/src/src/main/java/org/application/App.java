package org.application;

import entities.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    static List<Usuario> listaUsuarios;

    static Scanner teclado = new Scanner(System.in);


    public static void main(String[] args) {

        // inicializacao: leitura de dados do arquivo
        clientes = lerClientes(ARQ_CLIENTES);
        jogos = lerJogos(ARQ_JOGOS);

        int autenticacao = login();

        switch (autenticacao) {
            case 1:
                menuAdmin();
                break;
            case 2:
                menuProfessor();
                break;
            case 3:
                menuAluno();
                break;
            default:
                System.out.println("Usuario nao encontrado");
                break;
        }

        int opcao;
        do {

            opcao = menu(teclado);

            switch (opcao) {
                case 1:
                    menu1CadastroDeCliente();
                    break;
                case 2:
                    menu2RegistrarCompra();
                    break;
                case 3:
                    menu3ObterHistoricoDoCliente();
                    break;
                case 4:
                    menu4CadastroDeJogo();
                    break;
                case 5:
                    menu5ValorMensalVendido();
                    break;
                case 6:
                    menu6ValorMedioDasCompras();
                    break;
                case 7:
                    menu7JogoMaisVendido();
                    break;
                case 8:
                    menu8JogoMenosVendido();
                    break;
            }
            pausa(teclado);
            limparTela();
        } while (opcao != 0);

        // escrita de dados no arquivo
        escreverClientes(clientes, ARQ_CLIENTES);
        escreverJogos(jogos, ARQ_JOGOS);

    }

    //#region LOGIN
    public static int login() {
        System.out.println("SISTEMA DE MATRICULAS\n");
        System.out.println("======== Entre com seu LOGIN =======");
        System.out.println("\nDigite o Nome de Usuário:");
        String username = teclado.nextLine();
        System.out.println("\nDigite a Senha do Usuário");
        String senha = teclado.nextLine();
        Usuario usuario = listaUsuarios.stream().filter(u -> u.login(username, senha)).findFirst().orElse(null);
        int autenticacao = 0;
        if (usuario != null) {
            System.out.println("\nBem vindo " + usuario.getNome() + "!");
            if(usuario.getTipo().equals(TipoUsuario.ALUNO)) {
                autenticacao = 1;
            } else if(usuario.getTipo().equals(TipoUsuario.PROFESSOR)) {
                autenticacao = 2;
            } else if(usuario.getTipo().equals(TipoUsuario.ADMIN)) {
                autenticacao = 3;
            }
        } else {
            System.out.println("\nUsuário ou senha inválidos!");
        }
        return autenticacao;
    }
    //#endregion

    //#region Métodos ADMIN
    public static int menuAdmin(Scanner teclado) {
        limparTela();
        System.out.println("SISTEMA DE MATRICULAS\n");
        System.out.println("======== OPERAÇÕES ADMIN =======");
        System.out.println("1 - Cadastrar Usuários");
        System.out.println("2 - Gerenciar Disciplinas");
        System.out.println("3 - Gerenciar Ofertas");
        System.out.println("4 - Gerenciar Matriculas");
        System.out.println("======== **** =======");
        System.out.println("0 - Sair");
        int opcao = 0;
        try {
            opcao = teclado.nextInt();
            teclado.nextLine();
        } catch (InputMismatchException ex) {
            teclado.nextLine();
            System.out.println("Somente opções numéricas.");
            opcao = -1;
        }
        return opcao;
    }

    private static void menuADMIN_1CadastroDeUsuario() {
        limparTela();
        System.out.println("CADASTRO DE USUÁRIOS");
        System.out.println("======== 1 - Cadastrar Usuario =======");
        System.out.println("\nDigite o Nome de Usuário desejado");
        String username = teclado.nextLine();
        System.out.println("\nDigite a Senha do Usuário");
        String senha = teclado.nextLine();
        System.out.println("\nSelecione o tipo do Usuário");
        System.out.println("\n1 - ALUNO");
        System.out.println("\n2 - PROFESSOR");
        System.out.println("\n3 - ADMIN");
        int tipoUsuario = teclado.nextInt();
        Usuario usuario;
        switch (tipoUsuario) {
            case 1 -> {
                usuario = new Aluno(username, senha);
                listaUsuarios.add(usuario);
            }
            case 2 -> {
                usuario = new Professor(username, senha);
                listaUsuarios.add(usuario);
            }
            case 3 -> {
                usuario = new Admin(username, senha);
                listaUsuarios.add(usuario);
            }
            default -> {
            }
        }

        teclado.nextLine();
    }
    //#endregion

    //#region Métodos Auxiliares
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pausa(Scanner teclado) {
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }

    //#endregion
}
