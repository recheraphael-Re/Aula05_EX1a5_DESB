package Exercicios.Ex2Aula05DESB;

public class Supervisor extends Funcionario {

    private double bonus;

    public Supervisor(String nome, String matricula, double salarioBase, double bonus){
        super(nome, matricula, salarioBase);
        this.bonus = bonus;
    }

    public double getBonus(){
        return bonus;
    }

    // salarioBase + bonus
    @Override
    public double calcularSalario(){
        return getSalarioBase() + bonus;
    }

    @Override
    public void exibirDados(){
        System.out.println("--- Supervisor ---");
        super.exibirDados();
        System.out.println("Bonus: R$ " + bonus);
    }

}
