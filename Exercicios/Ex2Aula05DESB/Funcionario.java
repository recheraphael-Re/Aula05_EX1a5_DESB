package Exercicios.Ex2Aula05DESB;

// Classe base dos funcionarios da industria
public class Funcionario {

    private String nome;
    private String matricula;
    private double salarioBase;

    public Funcionario(String nome, String matricula, double salarioBase){
        this.nome = nome;
        this.matricula = matricula;
        this.salarioBase = salarioBase;
    }

    public String getNome(){
        return nome;
    }

    public String getMatricula(){
        return matricula;
    }

    public double getSalarioBase(){
        return salarioBase;
    }

    // Na classe base o salario e apenas o salario base
    public double calcularSalario(){
        return salarioBase;
    }

    public void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Matricula: " + matricula);
        System.out.println("Salario base: R$ " + salarioBase);
    }

}
