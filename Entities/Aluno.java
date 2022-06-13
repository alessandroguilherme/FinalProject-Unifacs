package Entities;

public class Aluno extends Pessoa implements Comparable<Aluno> {
    // Atributos de aluno
    private Integer matricula;
    private String condicaoFisica;
    private String nivelAluno;

    // Construtor de aluno
    public Aluno(Integer matricula, String nome, String dNascimento, String cpf, String condicaoFisica,
            String nivelAluno) {
        this.matricula = matricula;
        this.nome = nome;
        this.dNascimento = dNascimento;
        this.cpf = cpf;
        this.condicaoFisica = condicaoFisica;
        this.nivelAluno = nivelAluno;
    }

    // Getters e Setters
    public void setCondicaoFisica(String condicaoFisica) {
        this.condicaoFisica = condicaoFisica;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setdNascimento(String dNascimento) {
        this.dNascimento = dNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getdNascimento() {
        return dNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getCondicaoFisica() {
        return condicaoFisica;
    }

    public void setCondicaofisica(String condicaofisica) {
        this.condicaoFisica = condicaofisica;
    }

    public String getNivelAluno() {
        return nivelAluno;
    }

    public void setNivelAluno(String nivelAluno) {
        this.nivelAluno = nivelAluno;
    }

    public void buscarAluno(Aluno aluno) {

    }

    @Override
    public int compareTo(Aluno aluno) {
        return (this.nome.compareTo(aluno.getNome()));
    }
}
