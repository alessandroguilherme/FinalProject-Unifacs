//Tema: Sistema de cadastro geral para uma academia.
//Criadores:
//Alessandro Guilherme de Almeida Lopes 
//Anderson Santos Neris Silva
//Gabriel Antonio Lopes de Castro
//Ítalo Eustaquio Ferreira
//William das Dores
// ----------------------------------------------------------------------

import java.util.Scanner;
import Entities.Academia;
import Entities.Aluno;
import Entities.Instrutor;

public class Principal {
    public static void main(String[] args) {

        int seletor = 0;
        String senhaAdmin = "sla";
      

        Academia academia = new Academia("45.278.589/0001-22", "Familia Maromba", "Rua dos Maromba");
        System.out.println(academia);
        // Funcao para registrar 2 instrutores teste (popular ArrayList)
        academia.instrutoresCriados();
        // Funcao para registrar 5 alunos teste (popular ArrayList)
        academia.alunosCriados();

        do {
            // Funcao para fazer a chamada do menu geral
            menuDeRegistroGeral();
            // A variavel seletor recebe o comando do menu
            seletor = obterInteiroTeclado();
            int sairMenuGeral = 0;
            while (sairMenuGeral == 0) {
                if (seletor < 0 || seletor > 2) {

                    System.out.println("\nOPCAO INVALIDA, TENTE NOVAMENTE");
                    System.out.print("Informe aqui -> ");
                    seletor = obterInteiroTeclado();
                    sairMenuGeral = 0;
                    System.out.println();

                } else {
                    sairMenuGeral = 1;
                }
            }

            // Menu de registro do funcionario 1
            if (seletor == 1) {
                menuDeRegistroFuncionario1();
                seletor = obterInteiroTeclado();
                int sairMenuFuncio = 0;
                while (sairMenuFuncio == 0) {
                    if (seletor < 1 || seletor > 3) {

                        System.out.println("\nOPCAO INVALIDA, TENTE NOVAMENTE");
                        System.out.print("Informe aqui -> ");
                        seletor = obterInteiroTeclado();
                        sairMenuFuncio = 0;
                        System.out.println();

                    } else {
                        sairMenuFuncio = 1;
                    }
                }

                // A condicional if avalia se o usuario deseja logar no Administrador
                if (seletor == 1) {
                    
                    // A senha deve ser obrigatoriamente "admin" em letras minusculas
                    // Verifica se a senha digitada e a correta para ter acesso as funcoes de admin
                    
                    if(!senhaAdmin.equals("admin")){
                        menuDeLogin();
                        senhaAdmin = obterStringTeclado();
                        System.out.println();
                        
                        //Enquanto a senha nao for correta pedir para digitar a senha denovo ou digitar sair 
                        
                        while (!senhaAdmin.equals("admin") && !senhaAdmin.equals("sair")) {
                            System.out.println("SENHA INCORRETA, TENTE NOVAMENTE OU DIGITE 'sair' CASO NAO SAIBA!");
                            System.out.print("senha: ");
                            senhaAdmin = obterStringTeclado();
            
                        }
                    }
                    //so entra caso a senha digitada seja a certa, caso ele tenha optado por sair nao vai entrar nas funcoes de admin
                    
                    if(senhaAdmin.equals("admin")){
                        menuDeFuncoes();
                        seletor = obterInteiroTeclado();
                        int sairMenuFuncoes = 0;
                        while (sairMenuFuncoes == 0) {
                            if (seletor < 0 || seletor > 6) {

                                System.out.println("\nOPCAO INVALIDA, TENTE NOVAMENTE");
                                System.out.print("Informe aqui -> ");
                                seletor = obterInteiroTeclado();
                                sairMenuFuncoes = 0;
                                System.out.println();

                            } else {
                                sairMenuFuncoes = 1;
                            }
                        }

                        // Sequencia de if e else para avaliar qual função sera acessada
                        // Caso a opcao 1 seja escolhida sera exibido uma lista com todos os alunos
                        
                        if (seletor == 1) {
                            System.out.println("LISTA DE ALUNOS CADASTRADOS----------------------");
                            academia.listarAlunos();
                            System.out.println("-------------------------------------------------\n");

                            // Caso a opcao 2 seja escolhida sera exibido uma lista com todos os instrutores
                            // cadastrados
                            
                        } else if (seletor == 2) {

                            System.out.println("LISTA DE INSTRUTORES CADASTRADOS----------------------");
                            academia.listarInstrutores();
                            System.out.println("------------------------------------------------------\n");

                            // Caso a opcao 3 seja escolhida sera uma busca do instrutor com base na
                            // matricula digitada
                            
                        } else if (seletor == 3) {

                            System.out.println("\nDIGITE A MATRICULA PARA ENCONTRAR O INSTRUTOR: ");
                            int matriculaDigitada = obterInteiroTeclado();
                            academia.buscarInstrutor(matriculaDigitada);
                            System.out.println("------------------------------------------------------\n");

                            // Caso a opcao 4 seja escolhida sera uma busca do aluno com base na matricula
                            // digitada
                        } else if (seletor == 4) {

                            System.out.println("\nDIGITE A MATRICULA PARA ENCONTRAR O ALUNO: ");
                            int matriculaDigitada = obterInteiroTeclado();
                            academia.buscarAluno(matriculaDigitada);
                            System.out.println("------------------------------------------------------\n");

                        } else if (seletor == 5) {

                            System.out.print("\nINFORME A MATRICULA DO ALUNO QUE VOCE DESEJA REMOVER DO REGISTRO: ");
                            int matriculaDigitada = obterInteiroTeclado();
                            academia.removerAluno(matriculaDigitada);

                        } else if (seletor == 6) {
                            System.out
                                    .print("\nINFORME A MATRICULA DO INSTRUTOR QUE VOCE DESEJA REMOVER DO REGISTRO: ");
                            int matriculaDigitada = obterInteiroTeclado();
                            academia.removerInstrutor(matriculaDigitada);
                        }
                    }
                }

                // Acesso ao menu de instrutor caso a opção 2 for escolhida
                else if (seletor == 2) {

                    // Menu de registro do Instrutor
                    
                    System.out.println();
                    System.out.println("---------BEM VINDO INSTRUTOR--------");
                    System.out.println("\nREGISTRE-SE AQUI\n");
                    // Gerador de matriculas aleatorio entre 10000 e 99999
                    int matriculaFuncionario = (int) (Math.random() * 90000) + 10000;
                    // Coleta das informação pessoais do instrutor
                    System.out.print("Informe seu Nome: ");
                    String nome = obterStringTeclado();
                    System.out.print("Informe Sua Data de nascimento em (DD/MM/YYYY): ");
                    String dNascimento = obterStringTeclado();
                    System.out.print("Informe apenas os numeros de seu CPF: ");
                    String cpf = obterStringTeclado();
                    System.out.print("Informe o Salario Atual: ");
                    double salario = obterDoubleTeclado();
    

                    // Menu de Turno - Insere o turno de trabalho do instrutor
                    menuDeTurno();
                    int addTurno = obterInteiroTeclado();
                    String turno = null;
                    if (addTurno == 1) {
                        turno = "Manha";
                    } else if (addTurno == 2) {
                        turno = "Tarde";
                    } else if (addTurno == 3) {
                        turno = "Noite";
                    } else if (addTurno == 4) {

                    }
                    // Criando objeto instrutor
                    Instrutor instrutor = new Instrutor(matriculaFuncionario, nome, dNascimento, cpf, salario, turno);
                    // Adcionando instrutor na lista de instrutores de academia
                    academia.registrarInstrutor(instrutor);

                    System.out.println("\nINSTRUTOR REGISTRADO, SUA MATRICULA EH - " + matriculaFuncionario);
                    System.out.println("BEM VINDO A FAMILIA MAROMBA!");

                }

            }
            // Se a opção 2 for escolhida, o menu de registro de Aluno será exibido
            else if (seletor == 2) {

                System.out.println();
                System.out.println("---------BEM VINDO ALUNO--------");
                System.out.println("\nREGISTRE-SE AQUI\n");
                // Gerador de matriculas aleatorio entre 100000 e 999999
                int matricula = (int) (Math.random() * 900000) + 100000;
                // Coleta das informação pessoais do aluno
                System.out.print("Informe seu Nome: ");
                String nome = obterStringTeclado();
                System.out.print("Informe Sua Data de nascimento em (DD/MM/YYYY): ");
                String dNascimento = obterStringTeclado();
                System.out.print("Informe apenas os numeros de seu CPF: ");
                String cpf = obterStringTeclado();
                System.out.println();

                // Menu de registro da condicao fisica do aluno
                menuDeCondicaoFisica();

                // Registro da condicao fisica do aluno
                int addCondicao = obterInteiroTeclado();
                String condicaoFisica = null;
                if (addCondicao == 1) {
                    condicaoFisica = "Sedentario";
                } else if (addCondicao == 2) {
                    condicaoFisica = "Parado";
                } else if (addCondicao == 3) {
                    condicaoFisica = "Saudavel";
                } else if (addCondicao == 4) {
                    condicaoFisica = "Ativo";
                }

                System.out.println();
                // Menu para escolher a intensidade do treino do aluno
                menuDeIntensidade();

                // Cadastro da intensidade do treino do aluno
                int addNivel = obterInteiroTeclado();
                String nivelAluno = null;
                if (addNivel == 1) {
                    nivelAluno = "Leve";
                } else if (addNivel == 2) {
                    nivelAluno = "Moderado";
                } else if (addNivel == 3) {
                    nivelAluno = "Intenso";
                }

                // Criando objeto aluno
                Aluno aluno = new Aluno(matricula, nome, dNascimento, cpf, condicaoFisica, nivelAluno);
                // Adcionando aluno na lista de alunos da academia
                academia.registrarAluno(aluno);
                System.out.println("\nALUNO REGISTRADO, SUA MATRICULA EH - " + matricula);
                System.out.println("BEM VINDO A FAMILIA MAROMBA!");

                // Opção de retornar ao menu ou sair do sistema
                System.out.println();
                System.out.println("ESCOLHA UMA OPCAO: ");
                System.out.println("1 - RETORNAR AO MENU");
                System.out.println("2 - ENCERRAR SISTEMA\n");
                System.out.println("INFORME AQUI -> ");
                int continuar = obterInteiroTeclado();
                if (continuar == 1) {
                } else {
                    break;
                }
            }

        } while (seletor != 0);
        System.out.println("\nSistema encerrado!\nObrigado pelo seu acesso");
        System.out.println("-------------------------------------------------");
    }

    public static void menuDeRegistroGeral() {
        System.out.println();
        System.out.println("---------BEM VINDO AO SISTEMA DE REGISTRO--------\n");
        System.out.println("ESCOLHA UMA DAS \n");
        System.out.println("0 - SAIR");
        System.out.println("1 - MENU FUNCIONARIO");
        System.out.println("2 - REGISTRAR ALUNO\n");
        System.out.print("Informe aqui -> ");
    }

    public static void menuDeRegistroFuncionario1() {
        System.out.println("---------BEM VINDO FUNCIONARIO--------\n");
        System.out.println("ESCOLHA A OPCAO QUE VOCE DESEJA \n");
        System.out.println("1 - OPCOES DE ADMINISTRADOR");
        System.out.println("2 - REGISTRAR INSTRUTOR");
        System.out.println("3 - SAIR\n");
        System.out.print("Informe aqui -> ");
    }

    public static void menuDeLogin() {
        System.out.println();
        System.out.println("---------BEM VINDO ADMINSTRADOR--------");
        System.out.println("\nTELA DE VALIDACAO\n");
        System.out.println("Por favor, insira a senha para poder acessar as funcoes de Administrador");
        System.out.print("Senha: ");// A senha deve ser obrigatóriamente "admin" em letras minúsculas
    }

    public static void menuDeFuncoes() {
        System.out.println("\nFUNCOES DO ADMINISTRADOR\n");
        System.out.println("1 - LISTAR ALUNOS");
        System.out.println("2 - LISTAR INSTRUTORES");
        System.out.println("3 - BUSCAR ISNTRUTORES");
        System.out.println("4 - BUSCAR ALUNOS");
        System.out.println("5 - REMOVER ALUNO CADASTRADO");
        System.out.println("6 - REMOVER INSTRUTOR CADASTRADO\n");
        System.out.print("Informe aqui -> ");
    }

    public static void menuDeTurno() {
        System.out.println("ESCOLHA ABAIXO SEU TURNO DE TRABALHO---------");
        System.out.println("1 - MANHA");
        System.out.println("2 - TARDE");
        System.out.println("3 - NOITE\n");
        System.out.print("Informe Aqui -> ");
    }

    public static void menuDeCondicaoFisica() {
        System.out.println("ESCOLHA ABAIXO SUA CONDICAO FISICA ATUAL---------");
        System.out.println("1 - SEDENTARIO");
        System.out.println("2 - PARADO");
        System.out.println("3 - SAUDAVEL");
        System.out.println("4 - ATIVO\n");
        System.out.print("Informe Aqui -> ");
    }

    public static void menuDeIntensidade() {
        System.out.println("ESCOLHA ABAIXO EM QUAL NIVEL DE INTENSIDADE VOCE DESEJA INICIAR---------");
        System.out.println("1 - LEVE");
        System.out.println("2 - MODERADO");
        System.out.println("3 - INTENSO\n");
        System.out.print("Informe Aqui -> ");

    }

    // Funcao para obter um valor inteiro do teclado
    public static int obterInteiroTeclado() {
        Scanner leitor = new Scanner(System.in);
        return leitor.nextInt();
    }

    // Funcao para obter uma String do teclado
    public static String obterStringTeclado() {
        Scanner leitor = new Scanner(System.in);
        return leitor.nextLine();
    }

    // Funcao para obter um valor double do teclado
    public static double obterDoubleTeclado() {
        Scanner leitor = new Scanner(System.in);
        return leitor.nextDouble();
    }


}
