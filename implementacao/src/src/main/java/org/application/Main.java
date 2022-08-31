package org.application;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import dao.DAO;
import dao.DaoGenerico;
import entities.*;
import excecao.TipoInvalidoExcecao;

public class Main {

    static List<Usuario> listaUsuario;
    static List<Curso> listaCurso;
    static List<Disciplina> listaDisciplina;
    static List<Matricula> listaMatricula;
    static List<OfertaDisciplina> listaOferta;
    
    private static String opcao;
    private static Scanner sc = new Scanner(System.in);
    private static DAO<Usuario> daoUsuario = new DaoGenerico<>("Usuarios.DAT");

    public static void main(String[] args) throws Exception {
        listaUsuario = daoUsuario.getAll();

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
                System.out.println("Usuario ou senha inválidos");
                break;
        }
    }


    //#region LOGIN
    public static int login() {
        System.out.println("SISTEMA DE MATRICULAS\n");
        System.out.println("======== Entre com seu LOGIN =======");
        System.out.println("\nDigite o Nome de Usuário:");
        String username = sc.nextLine();
        System.out.println("\nDigite a Senha do Usuário");
        String senha = sc.nextLine();
        Usuario usuario = listaUsuario.stream().filter(u -> u.login(username, senha)).findFirst().orElse(null);
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


    //#region MENU ALUNO
    public static void menuAluno() {
        listaUsuario = daoUsuario.getAll();

        do {
            System.out.println("\n                 *****  Sistema de Matricula - ALUNO  *****            ");
            System.out.println("       ================================================================= ");
            System.out.println("      |                                                                 |");
            System.out.println("      |    1.  Solicitar Matrícula                                      |");
            System.out.println("      |    2.  Cancelar Matrícula                                       |");
            System.out.println("      |    0.  Salvar e sair                                            |");
            System.out.println("      *=================================================================*\n");
            System.out.print("Informe uma opcao: ");

            opcao = sc.next();
            System.out.println("");
            if (validarOpcao(opcao))

                switch (Integer.parseInt(opcao)) {
                    case 1:
                        menu1CadastrarUsuario();

                        break;

                    case 2:

                        break;

                    case 0:
                        break;
                }

        } while (!opcao.equals("0"));
        daoUsuario.salvarTodos(listaUsuario);
        System.out.println("Sistema encerrado!");
    }
    //#endregion

    //#region MENU ADMIN
    public static void menuAdmin() {
        listaUsuario = daoUsuario.getAll();

        do {
            System.out.println("\n                 *****  Sistema de Matricula - ADMIN  *****            ");
            System.out.println("       ================================================================= ");
            System.out.println("      |                                                                 |");
            System.out.println("      |    1.  Cadastrar Usuario                                        |");
            System.out.println("      |    2.  Gerenciar Disciplinas                                    |");
            System.out.println("      |    3.  Gerenciar Cursos                                         |");
            System.out.println("      |    4.  Gerenciar Ofertas                                        |");
            System.out.println("      |    5.  Concluir Matriculas                                      |");
            System.out.println("      |    0.  Salvar, e sair                                            |");
            System.out.println("      *=================================================================*\n");
            System.out.print("Informe uma opcao: ");

            opcao = sc.next();
            System.out.println("");
            if (validarOpcao(opcao))

                switch (Integer.parseInt(opcao)) {
                    case 1:
                        menu1CadastrarUsuario();
                        break;

                    case 2:
                        menu2GerenciarDisciplinas();
                        break;

                    case 3:
                        menu3GerenciarCursos();
                        break;

                    case 4:
                        menu4GerenciarOfertas();
                        break;

                    case 5:
                        menu5ConcluirMatriculas();
                        break;

                    case 0:
                        break;
                }

        } while (!opcao.equals("0"));
        daoUsuario.salvarTodos(listaUsuario);
        System.out.println("Sistema encerrado!");
    }

    public static void menu1CadastrarUsuario() {

        sc.nextLine();

        System.out.println("Informe qual o tipo do Usuario entre Administrador, Professor e Aluno: ");
        String tipo = sc.nextLine();
        try {
            Usuario Usuario = UsuarioFactory.creator(tipo);

            boolean validador = false;
            String nomeDeUsuario;
            do {
                validador=false;
                System.out.println("Informe o seu nome de usuário: ");
                nomeDeUsuario = sc.nextLine();

                for (Usuario Usuarios : listaUsuario) {
                    if (nomeDeUsuario.equals(Usuarios.getNomeDeUsuario())) {
                        System.out.println("\nUsuário já cadastrado\n");
                        validador = true;
                        break;
                    }
                }
                if(validarStringVazia(nomeDeUsuario)){
                    System.out.println("Favor não inserir um nome vazio");
                    validador=true;
                }
            } while (validador);
            validador = false;

            System.out.println("Informe sua senha: ");
            String senha = sc.nextLine();

            while (!isValidPassword(senha)) {
                senhaInvalida();
                System.out.println("Informe sua senha: ");
                senha = sc.nextLine();
            }


            Usuario.setNomeDeUsuario(nomeDeUsuario);
            Usuario.setSenha(senha);
            listaUsuario.add(Usuario);
            System.out.println("\nUsuario cadastrado!\n");
        } catch (TipoInvalidoExcecao e) {
            System.out.println(e.getMessage());
        }

    }

    //#region 2-DISCIPLINAS
    private static void menu2GerenciarDisciplinas() {
        sc.nextLine();

        System.out.println("Gerenciar DISCIPLINAS: \n");
        System.out.println("1.  Cadastrar Disciplina");
        System.out.println("2.  Excluir Disciplina");
        System.out.println("0.  Voltar ao Menu Principal");
        opcao = sc.next();
        System.out.println("");
        if (validarOpcao(opcao))
            switch (Integer.parseInt(opcao)) {
                case 1:
                    menu2_1CadastrarDisciplina();
                    break;
                case 2:
                    menu2_2ExcluirDisciplina();
                    break;
                default:
                    menuAdmin();
            }

    }

    private static void menu2_1CadastrarDisciplina() {

        boolean validador = false;
        String nomeDisciplina;
        do {
            validador=false;
            System.out.println("Informe o nome da disciplina: ");
            nomeDisciplina = sc.nextLine();

            for (Disciplina disciplina : listaDisciplina) {
                if (nomeDisciplina.equals(disciplina.getNome())) {
                    System.out.println("\nDisciplina já cadastrada\n");
                    validador = false;
                    break;
                }
            }
            if(validarStringVazia(nomeDisciplina)){
                System.out.println("Favor não inserir um nome vazio");
                validador=true;
            }
        } while (validador);
        validador = false;

        System.out.println("Informe a quantidade de créditos da disciplina: ");
        String creditos = sc.nextLine();

        while (!validarOpcao(creditos)) {
            System.out.println("Informe a quantidade numerica de creditos: ");
            creditos = sc.nextLine();
        }

        System.out.println("Informe o preço da disciplina: ");
        String preco = sc.nextLine();

        while (!validarOpcao(creditos)) {
            System.out.println("Informe a quantidade numerica para o preço: ");
            preco = sc.nextLine();
        }

        boolean obrigatoria;
        System.out.println("Informe se a disciplina é obrigatória");
        System.out.println("1. Obrigatória");
        System.out.println("2. Não Obrigatória");
        opcao = sc.nextLine();
        obrigatoria= opcao.equals("1");

        Disciplina disciplina = new Disciplina(nomeDisciplina, Integer.parseInt(creditos), Integer.parseInt(preco), obrigatoria);
        listaDisciplina.add(disciplina);
        System.out.println("\nDisciplina cadastrada!\n");

    }

    private static void menu2_2ExcluirDisciplina() {
        boolean validador = false;
        String nomeDisciplina;
        do {
            validador=false;
            System.out.println("Informe o nome da disciplina a ser excluída: ");
            nomeDisciplina = sc.nextLine();

            String finalNomeDisciplina = nomeDisciplina;
            if(listaDisciplina.stream().anyMatch(d -> d.getNome().equals(finalNomeDisciplina))){
                listaDisciplina.removeIf(d -> d.getNome().equals(finalNomeDisciplina));
                System.out.println("\nDisciplina removida!\n");
                validador = true;
            } else {
                System.out.println("\nDisciplina não encontrada\n");
                System.out.println("\nDeseja procurar novamente?\n");
                System.out.println("1. Sim");
                System.out.println("0. Não");
                opcao = sc.nextLine();
                if(Integer.parseInt(opcao)==1){
                    validador = true;
                }
            }
        } while (validador);
    }
    //#endregion

    //#region 3-CURSOS

    private static void menu3GerenciarCursos() {
        sc.nextLine();

        System.out.println("Gerenciar CURSOS: \n");
        System.out.println("1.  Cadastrar Curso");
        System.out.println("2.  Excluir Curso");
        System.out.println("3.  Adicionar Disciplinas ao curso");
        System.out.println("0.  Voltar ao Menu Principal");
        opcao = sc.next();
        System.out.println("");
        if (validarOpcao(opcao))
            switch (Integer.parseInt(opcao)) {
                case 1:
                    menu3_1CadastrarCurso();
                    break;
                case 2:
                    menu3_2ExcluirCurso();
                    break;
                case 3:
                    menu3_3AdicionarDisciplinasAoCurso();
                    break;
                default:
                    menuAdmin();
            }

    }

    private static void menu3_1CadastrarCurso() {

        boolean validador = false;
        String nomeCurso;
        do {
            validador=false;
            System.out.println("Informe o nome do curso: ");
            nomeCurso = sc.nextLine();

            for (Curso curso : listaCurso) {
                if (nomeCurso.equals(curso.getNome())) {
                    System.out.println("\nCurso já cadastrado\n");
                    validador = false;
                    break;
                }
            }
            if(validarStringVazia(nomeCurso)){
                System.out.println("Favor não inserir um nome vazio");
                validador=true;
            }
        } while (validador);
        validador = false;

        System.out.println("Informe a quantidade de créditos totais do curso: ");
        String creditos = sc.nextLine();

        while (!validarOpcao(creditos)) {
            System.out.println("Informe a quantidade numerica de creditos: ");
            creditos = sc.nextLine();
        }

        Curso curso = new Curso(nomeCurso, Integer.parseInt(creditos));
        listaCurso.add(curso);
        System.out.println("\nCurso cadastrado!\n");
    }

    private static void menu3_2ExcluirCurso() {
        boolean validador = false;
        String nomeDisciplina;
        do {
            validador=false;
            System.out.println("Informe o nome da disciplina a ser excluída: ");
            nomeDisciplina = sc.nextLine();

            String finalNomeDisciplina = nomeDisciplina;
            if(listaDisciplina.stream().anyMatch(d -> d.getNome().equals(finalNomeDisciplina))){
                listaDisciplina.removeIf(d -> d.getNome().equals(finalNomeDisciplina));
                System.out.println("\nDisciplina removida!\n");
                validador = true;
            } else {
                System.out.println("\nDisciplina não encontrada\n");
                System.out.println("\nDeseja procurar novamente?\n");
                System.out.println("1. Sim");
                System.out.println("0. Não");
                opcao = sc.nextLine();
                if(Integer.parseInt(opcao)==1){
                    validador = true;
                }
            }
        } while (validador);
    }

    private static void menu3_3AdicionarDisciplinasAoCurso() {

    }
    //#endregion

    private static void menu4GerenciarOfertas() {

    }

    private static void menu5ConcluirMatriculas() {

    }

    //#endregion

    //#region MENU PROFESSOR
    public static void menuProfessor() {
        listaUsuario = daoUsuario.getAll();

        do {
            System.out.println("\n                 *****  Sistema de Matricula - PROFESSOR  *****            ");
            System.out.println("       ================================================================= ");
            System.out.println("      |                                                                 |");
            System.out.println("      |    1.  Solicitar Matrícula                                      |");
            System.out.println("      |    2.  Cancelar Matrícula                                       |");
            System.out.println("      |    0.  Salvar e sair                                            |");
            System.out.println("      *=================================================================*\n");
            System.out.print("Informe uma opcao: ");

            opcao = sc.next();
            System.out.println("");
            if (validarOpcao(opcao))

                switch (Integer.parseInt(opcao)) {
                    case 1:
                        menu1CadastrarUsuario();

                        break;

                    case 2:

                        break;

                    case 0:
                        break;
                }

        } while (!opcao.equals("0"));
        daoUsuario.salvarTodos(listaUsuario);
        System.out.println("Sistema encerrado!");
    }
    //#endregion

    //#region VALIDAÇÕES
    public static boolean validarOpcao(String opcao) {
        boolean ehValida = false;
        String expression = "[0-9]+";

        if (opcao.matches(expression)) {
            ehValida = true;
            if (Integer.parseInt(opcao) > 10 || Integer.parseInt(opcao) < 0){
                System.out.println("Favor inserir um valor entre 0 e 10!");
            }
        } else
            System.out.println("\nFavor inserir uma opção entre 0 e 10!\n");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ehValida;
    }

    public static boolean validarStringVazia(String dado){
        String dados[] = dado.split("");
        int qntEspacos = 0;

        for (String string : dados) {
            if (string.equals(" ")) {
                qntEspacos++;
            }
        } return dado.length()==qntEspacos;
    }

    public static boolean isValidPassword(String senha) {

        String regex = "(?=.*[a-z])"
                + "(?=\\S+$).{4,20}$";
        Pattern p = Pattern.compile(regex);
        if (senha == null) {
            return false;
        }
        Matcher m = p.matcher(senha);
        return m.matches();
    }

    public static void senhaInvalida() {
        System.out.println("\nFavor criar uma senha que respeita as sequintes regras:");
        System.out.println();
        System.out.println("conter entre 4 e 20 caracteres.");

    }
    //#endregion
}
