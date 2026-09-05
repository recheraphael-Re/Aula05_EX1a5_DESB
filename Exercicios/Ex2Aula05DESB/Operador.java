package Exercicios.Ex2Aula05DESB;

public class Operador extends Funcionario {

    private int horasExtras;
    private double valorHoraExtra;

    public Operador(String nome, String matricula, double salarioBase, int horasExtras, double valorHoraExtra){
        super(nome, matricula, salarioBase);
        this.horasExtras = horasExtras;
        this.valorHoraExtra = valorHoraExtra;
    }

    public int getHorasExtras(){
        return horasExtras;
    }

    public double getValorHoraExtra(){
        return valorHoraExtra;
    }

    // salarioBase + (horasExtras * valorHoraExtra)
    @Override
    public double calcularSalario(){
        return getSalarioBase() + (horasExtras * valorHoraExtra);
    }

    @Override
    public void exibirDados(){
        System.out.println("--- Operador ---");
        super.exibirDados();
        System.out.println("Horas extras: " + horasExtras);
        System.out.println("Valor da hora extra: R$ " + valorHoraExtra);
    }

}
