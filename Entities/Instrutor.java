package Entities;

public class Instrutor extends Funcionario implements Comparable<Instrutor> {

    // Construtor de Instrutor
    public Instrutor(Integer matriculaFuncionario, String nome, String dNascimento, String cpf, Double salario,
            String turno) {

        this.matriculaFuncionario = matriculaFuncionario;
        this.nome = nome;
        this.dNascimento = dNascimento;
        this.cpf = cpf;
        this.salario = salario;
        this.turno = turno;

    }

    // Getters e Setters
    public Integer getMatriculaFuncionario() {
        return matriculaFuncionario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

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

    @Override
    public int compareTo(Instrutor instrutor) {
        return (this.nome.compareTo(instrutor.getNome()));
    }

}
