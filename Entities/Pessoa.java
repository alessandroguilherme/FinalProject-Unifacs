package Entities;

public class Pessoa {

    // Atributos pessoa
    protected String nome;
    protected String dNascimento;
    protected String cpf;

    // Construtores
    public Pessoa() {
    }

    public Pessoa(String nome, String dNascimento, String cpf) {
        this.nome = nome;
        this.dNascimento = dNascimento;
        this.cpf = cpf;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getdNascimento() {
        return dNascimento;
    }

    public void setdNascimento(String dNascimento) {
        this.dNascimento = dNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
