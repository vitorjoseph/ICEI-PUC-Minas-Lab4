package org.application;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.DAO;
import dao.DaoGenerico;
import entities.Usuario;
import excecao.TipoInvalidoExcecao;

public class Main {

    static List<Usuario> listaUsuario;
    
    private static String opcao;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        DAO<Usuario> daoUsuario = new DaoGenerico<>("Usuarios.DAT");
        listaUsuario = daoUsuario.getAll();


        do {
            System.out.println("\n                  *****      Xulamb Games 03      *****                ");
            System.out.println("       ================================================================= ");
            System.out.println("      |                                                                 |");
            System.out.println("      |    1.  Cadastrar Usuario                                        |");
            System.out.println("      |                                                                 |");
            System.out.println("      |    0. Salvar e sair                                             |");
            System.out.println("      *=================================================================*\n");
            System.out.print("Informe uma opcao: ");

            opcao = sc.next();
            System.out.println("");
            if (validarOpcao(opcao))

                switch (Integer.parseInt(opcao)) {
                    case 1:
                    cadastrarUsuario();
                        
                        break;

                    case 2:
                        
                        break;

                    case 0:
                        break;
                }

        } while (!opcao.equals("0"));
        }

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

        public static void cadastrarUsuario() {

            sc.nextLine();
    
            System.out.println("Informe qual o tipo do Usuario entre Cadastrado, Empolgado e Fanatico: ");
            String tipo = sc.nextLine();
            try {
                Usuario Usuario = UsuarioFactory.creator(tipo);
                
                System.out.println("Informe o seu nome: ");
                String nome = sc.nextLine();
    
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

            String regex = "^(?=.*[0-9])"
                    + "(?=.*[a-z])"
                    + "(?=\\S+$).{8,20}$";
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
            System.out.println("conter entre 8 e 20 caracteres.");

        }
    }
