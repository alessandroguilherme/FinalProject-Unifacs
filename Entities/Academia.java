package Entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Academia {

    // Atributos academia
    private String CNPJ;
    private String nome;
    private String endereco;
    private ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
    private ArrayList<Instrutor> listaDeIstrutores = new ArrayList<>();

    // Construtor Academia
    public Academia(String CNPJ, String nome, String endereco) {
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.endereco = endereco;
    }

    // Getters e setters
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Aluno> getAlunos() {
        return listaDeAlunos;
    }

    public ArrayList<Instrutor> getInstrutor() {
        return listaDeIstrutores;
    }

    public ArrayList<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public ArrayList<Instrutor> getListaDeIstrutores() {
        return listaDeIstrutores;
    }

    // Métodos Academia
    // Método que busca instrutor atraves do numero da matricula
    public void buscarInstrutor(Integer matriculaDigitada) {
        int posicaoNaFila = 0;
        int continuarWhile = 1;
        while (true) {

            for (int j = 0; j < listaDeIstrutores.size(); j++) {
                // Compara a matricula digitada com todas as matriculas registradas no ArrayList
                if ((listaDeIstrutores.get(j).getMatriculaFuncionario()).equals(matriculaDigitada)) {
                    posicaoNaFila = j;

                    System.out.println("\nINSTRUTOR ENCONTRADO!");
                    System.out.println();
                    System.out.print("Instrutor #" + (posicaoNaFila + 1) + "\n");
                    System.out.print("Matricula: " + listaDeIstrutores.get(posicaoNaFila).matriculaFuncionario + "\n");
                    System.out.print("Nome: " + listaDeIstrutores.get(posicaoNaFila).nome + "\n");
                    System.out.print("Data de Nascimento: " + listaDeIstrutores.get(posicaoNaFila).dNascimento + "\n");
                    System.out.print("CPF: " + listaDeIstrutores.get(posicaoNaFila).cpf + "\n");
                    System.out.print("Salario atual: R$ " + listaDeIstrutores.get(posicaoNaFila).salario + "\n");
                    System.out.print("Turno: " + listaDeIstrutores.get(posicaoNaFila).turno + "\n");
                    System.out.println();
                    continuarWhile = 2;
                    System.out.println("DESEJA ALTERAR OS DADOS DO INSTRUTOR?");
                    System.out.println("1 - SIM");
                    System.out.println("2 - NAO");
                    System.out.print("Informe aqui -> ");
                    int certeza = obterInteiroTeclado();
                    if (certeza == 1) {
                        menuEditarInstrutor(j);
                    }
                }
            }
            if (continuarWhile == 2) {
                break;
            } else {
                System.out.println("\nMATRICULA NÃO EXISTENTE!, TENTE NOVAMENTE");
                System.out.print("DIGITE A MATRICULA PARA ENCONTRAR O INSTRUTOR: ");
                matriculaDigitada = obterInteiroTeclado();
            }

        }
    }

    // Metodo para listar instrutores
    public void listarInstrutores() {
        Collections.sort(listaDeIstrutores);

        for (int i = 0; i < listaDeIstrutores.size(); i++) {

            System.out.println();
            System.out.print("Instrutor #" + (i + 1) + "\n");
            System.out.print("Matricula: " + listaDeIstrutores.get(i).matriculaFuncionario + "\n");
            System.out.print("Nome: " + listaDeIstrutores.get(i).nome + "\n");
            System.out.print("Data de Nascimento: " + listaDeIstrutores.get(i).dNascimento + "\n");
            System.out.print("CPF: " + listaDeIstrutores.get(i).cpf + "\n");
            System.out.print("Salario atual: R$ " + listaDeIstrutores.get(i).salario + "\n");
            System.out.print("Turno: " + listaDeIstrutores.get(i).turno + "\n");
            System.out.println();
        }
    }

    // Metodo que adiciona um novo aluno
    public void registrarAluno(Aluno aluno) {
        listaDeAlunos.add(aluno);
    }

    // Metodo que adiciona um novo instrutor
    public void registrarInstrutor(Instrutor instrutor) {
        listaDeIstrutores.add(instrutor);
    }

    // Metodo para buscar aluno pelo numero de matricula
    public void buscarAluno(int matriculaDigitada) {
        int posicaoNaFila = 0;
        int continuarWhile = 1;

        while (true) {

            for (int j = 0; j < listaDeAlunos.size(); j++) {
                // Compara a matricula digitada com todas as matriculas registradas no ArrayList
                if ((listaDeAlunos.get(j).getMatricula()).equals(matriculaDigitada)) {
                    posicaoNaFila = j;
                    System.out.println("\nALUNO ENCONTRADO!");
                    System.out.println();
                    System.out.print("Aluno #" + (posicaoNaFila + 1) + "\n");
                    System.out.print("Matricula: " + listaDeAlunos.get(posicaoNaFila).getMatricula() + "\n");
                    System.out.print("Nome: " + listaDeAlunos.get(posicaoNaFila).nome + "\n");
                    System.out.print("Data de Nascimento: " + listaDeAlunos.get(posicaoNaFila).dNascimento + "\n");
                    System.out.print("CPF: " + listaDeAlunos.get(posicaoNaFila).cpf + "\n");
                    System.out.print("Condicao Fisica: " + listaDeAlunos.get(posicaoNaFila).getCondicaoFisica() + "\n");
                    System.out
                            .print("Intensidade do Treino: " + listaDeAlunos.get(posicaoNaFila).getNivelAluno() + "\n");
                    System.out.println();

                    continuarWhile = 2;

                    System.out.println("DESEJA ALTERAR OS DADOS DO ALUNO?");
                    System.out.println("1 - SIM");
                    System.out.println("2 - NAO");
                    System.out.print("Informe aqui -> ");
                    int certeza = obterInteiroTeclado();
                    if (certeza == 1) {
                        menuEditarAluno(j);
                    }
                }

            }
            if (continuarWhile == 2) {
                break;
            } else {
                System.out.println("\nMATRICULA NÃO EXISTENTE!, TENTE NOVAMENTE");
                System.out.print("DIGITE A MATRICULA PARA ENCONTRAR O ALUNO: ");
                matriculaDigitada = obterInteiroTeclado();
            }
        }

    }

    // Metodo para listar todos os alunos
    public void listarAlunos() {
        Collections.sort(listaDeAlunos);
        for (int i = 0; i < listaDeAlunos.size(); i++) {
            System.out.print("\n");
            System.out.print("Aluno #" + (i + 1) + "\n");
            System.out.print("Matricula: " + listaDeAlunos.get(i).getMatricula() + "\n");
            System.out.print("Nome: " + listaDeAlunos.get(i).nome + "\n");
            System.out.print("Data de Nascimento: " + listaDeAlunos.get(i).dNascimento + "\n");
            System.out.print("CPF: " + listaDeAlunos.get(i).cpf + "\n");
            System.out.print("Condicao Fisica: " + listaDeAlunos.get(i).getCondicaoFisica() + "\n");
            System.out.print("Intensidade do Treino: " + listaDeAlunos.get(i).getNivelAluno() + "\n");
        }
    }

    public void removerAluno(int matriculaDigitada) {

        int continuarWhile = 1;

        while (true) {

            for (int j = 0; j < listaDeAlunos.size(); j++) {
                if ((listaDeAlunos.get(j).getMatricula()).equals(matriculaDigitada)) {
                    System.out.println("\nDESEJA REALMENTE REMOVER ESTE ALUNO DA ACADEMIA?");
                    System.out.println("1 - SIM");
                    System.out.println("2 - NAO\n");
                    System.out.print("Informe aqui -> ");
                    int certeza = obterInteiroTeclado();
                    if (certeza == 1) {

                        listaDeAlunos.remove(j);
                        System.out.println("\nALUNO REMOVIDO COM SUCESSO!");
                        System.out.println("-1 FRANGO\n");
                        System.out.println();
                        continuarWhile = 2;
                    } else {
                        System.out.println("OPCAO CANCELADA");
                        continuarWhile = 2;
                    }
                }

            }
            if (continuarWhile == 2) {
                break;
            } else {
                System.out.println("\nMATRICULA NÃO EXISTENTE!, TENTE NOVAMENTE");
                System.out.print("DIGITE A MATRICULA PARA REMOVER O ALUNO DO REGISTRO: ");
                matriculaDigitada = obterInteiroTeclado();
            }

        }

    }

    public void removerInstrutor(int matriculaDigitada) {
        int continuarWhile = 1;
        while (true) {

            for (int j = 0; j < listaDeIstrutores.size(); j++) {
                if ((listaDeIstrutores.get(j).getMatriculaFuncionario()).equals(matriculaDigitada)) {
                    System.out.println("\nDESEJA REALMENTE REMOVER ESTE INSTRUTOR DA ACADEMIA?");
                    System.out.println("1 - SIM");
                    System.out.println("2 - NAO\n");
                    System.out.print("informe aqui -> ");
                    int certeza = obterInteiroTeclado();
                    if (certeza == 1) {
                        listaDeIstrutores.remove(j);
                        System.out.println("\nINSTRUTOR REMOVIDO COM SUCESSO!");
                        System.out.println("MENOS 1 COM TREINO FOFO\n");
                        continuarWhile = 2;
                    } else {
                        System.out.println("OPCAO CANCELADA");
                        continuarWhile = 2;
                    }

                }

            }
            if (continuarWhile == 2) {
                break;

            } else {
                System.out.println("\nMATRICULA NÃO EXISTENTE!, TENTE NOVAMENTE");
                System.out.print("DIGITE A MATRICULA PARA REMOVER O INSTRUTOR DO REGISTRO: ");
                matriculaDigitada = obterInteiroTeclado();
            }

        }
    }

    public void menuEditarAluno(int j) {
        do {

            System.out.println("\nINFORME QUAL INFORMACAO VOCE DESEJA EDITAR\n");
            System.out.println("1 - NOME");
            System.out.println("2 - DATA DE NASCIMENTO");
            System.out.println("3 - CPF");
            System.out.println("4 - CONDICAO FISICA");
            System.out.println("5 - INTENSIDADE\n");
            System.out.print("Informe aqui -> ");
            int seletor = obterInteiroTeclado();
            if (seletor >= 1 && seletor <= 5) {
                System.out.println();
                if (seletor == 1) {
                    System.out.print("DIGITE O NOVO NOME: ");
                    listaDeAlunos.get(j).setNome(obterStringTeclado());
                } else if (seletor == 2) {
                    System.out.print("DIGITE A NOVA DATA DE NASCIMENTO: ");
                    listaDeAlunos.get(j).setdNascimento(obterStringTeclado());
                } else if (seletor == 3) {
                    System.out.print("DIGITE O NOVO CPF: ");
                    listaDeAlunos.get(j).setCpf(obterStringTeclado());
                } else if (seletor == 4) {
                    System.out.println("ESCOLHA ABAIXO A NOVA CONDICAO FISICA---------");
                    System.out.println("1 - SEDENTARIO");
                    System.out.println("2 - PARADO");
                    System.out.println("3 - SAUDAVEL");
                    System.out.println("4 - ATIVO\n");
                    System.out.print("Informe Aqui -> ");
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
                    listaDeAlunos.get(j).setCondicaoFisica(condicaoFisica);

                } else if (seletor == 5) {
                    System.out.println("ESCOLHA ABAIXO O NOVO NIVEL DE INTENSIDADE---------");
                    System.out.println("1 - LEVE");
                    System.out.println("2 - MODERADO");
                    System.out.println("3 - INTENSO\n");
                    System.out.print("Informe Aqui -> ");
                    int addNivel = obterInteiroTeclado();
                    String nivelAluno = null;
                    if (addNivel == 1) {
                        nivelAluno = "Leve";
                    } else if (addNivel == 2) {
                        nivelAluno = "Moderado";
                    } else if (addNivel == 3) {
                        nivelAluno = "Intenso";
                    }
                    listaDeAlunos.get(j).setNivelAluno(nivelAluno);

                }

            } else {
                System.out.println("\nOPCAO INVALIDA, TENTE NOVAMENTE!");
                System.out.print("Informe aqui -> ");
                seletor = obterInteiroTeclado();

            }
            System.out.println("DESEJA ALTERAR MAIS ALGUMA COISA?");
            System.out.println("1 - SIM");
            System.out.println("2 - NAO");
            System.out.print("Informe aqui -> ");
            int certeza = obterInteiroTeclado();
            if (certeza == 2) {
                break;
            }
        } while (true);

    }

    public void menuEditarInstrutor(int j) {

        do {
            System.out.println("\nINFORME QUAL INFORMACAO VOCE DESEJA EDITAR\n");
            System.out.println("1 - NOME");
            System.out.println("2 - DATA DE NASCIMENTO");
            System.out.println("3 - CPF");
            System.out.println("4 - SALARIO");
            System.out.println("5 - TURNO\n");
            System.out.print("Informe aqui -> ");
            int seletor = obterInteiroTeclado();
            if (seletor >= 1 && seletor <= 5) {
                System.out.println();
                if (seletor == 1) {
                    System.out.print("DIGITE O NOVO NOME: ");
                    listaDeIstrutores.get(j).setNome(obterStringTeclado());
                } else if (seletor == 2) {
                    System.out.print("DIGITE A NOVA DATA DE NASCIMENTO: ");
                    listaDeIstrutores.get(j).setdNascimento(obterStringTeclado());
                } else if (seletor == 3) {
                    System.out.print("DIGITE O NOVO CPF: ");
                    listaDeIstrutores.get(j).setCpf(obterStringTeclado());
                } else if (seletor == 4) {
                    System.out.print("DIGITE O NOVO SALARIO: ");
                    listaDeIstrutores.get(j).setSalario(obterDoubleTeclado());

                } else if (seletor == 5) {
                    System.out.println("ESCOLHA ABAIXO O NOVO TURNO DO FUNCIONARIO---------");
                    System.out.println("1 - MANHA");
                    System.out.println("2 - TARDE");
                    System.out.println("3 - NOITE\n");
                    System.out.print("Informe Aqui -> ");
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
                    listaDeIstrutores.get(j).setTurno(turno);

                }

            } else {
                System.out.println("\nOPCAO INVALIDA, TENTE NOVAMENTE!");
                System.out.print("Informe aqui -> ");
                seletor = obterInteiroTeclado();

            }
            System.out.println("DESEJA ALTERAR MAIS ALGUMA COISA?");
            System.out.println("1 - SIM");
            System.out.println("2 - NAO\n");
            System.out.print("Informe aqui -> ");
            int certeza = obterInteiroTeclado();
            if (certeza == 2) {
                break;
            }
        } while (true);
    }

    // Metodo que retorna as insformacoes da academia
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("-------------- Seja Bem-Vindo ---------------\n");
        sBuilder.append("Academia: " + nome + "\n");
        sBuilder.append("CNPJ: " + CNPJ + "\n");
        sBuilder.append("Endereco: " + endereco + "\n");
        sBuilder.append(
                "\nRegras:\nNao tirar fotos no espelho\nNao entrar com o celular\nNao usar regata que vaza o mamilo\n");
        return sBuilder.toString();
    }

    // Metodo para registrar instrutores e popular ArrayList para teste
    public void instrutoresCriados() {
        Instrutor instrutorTeste1 = new Instrutor(11111, "Mario Azevedo", "12/04/2002", "61582145237", 1260.20,
                "Manha");
        this.listaDeIstrutores.add(instrutorTeste1);
        Instrutor instrutorTeste2 = new Instrutor(22222, "Astrogildo Neres", "03/01/1999", "43423347635", 1600.00,
                "Tarde");
        this.listaDeIstrutores.add(instrutorTeste2);
    }

    // Metodo para registrar alunos e popular ArrayList para teste
    public void alunosCriados() {
        Aluno aluno1 = new Aluno(111111, "Maria Silva", "04/01/1995", "93318680737", "Sedentaria", "Leve");
        this.listaDeAlunos.add(aluno1);
        Aluno aluno2 = new Aluno(222222, "Roberto Silva", "21/02/1990", "12133962476", "Parado", "Leve");
        this.listaDeAlunos.add(aluno2);
        Aluno aluno3 = new Aluno(333333, "Mariele Brasil", "27/07/2001", "66851485435", "Ativo", "Moderado");
        this.listaDeAlunos.add(aluno3);
        Aluno aluno4 = new Aluno(444444, "Agnaldo Timotio", "17/12/2002", "21803429429", "Saudavel", "Moderado");
        this.listaDeAlunos.add(aluno4);
        Aluno aluno5 = new Aluno(555555, "Neymar Junior", "05/02/1992", "87748573204", "Ativo", "Intenso");
        this.listaDeAlunos.add(aluno5);
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
