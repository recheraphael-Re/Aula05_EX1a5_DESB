package Exercicios.Ex2Aula05DESB;

public class Ex2 {

    public static void main(String[] args){

        // Referencia do tipo Funcionario apontando para as subclasses (polimorfismo)

        Funcionario funcionario1 = new Operador("Carlos Silva", "OP-1001", 2500.00, 12, 25.50);
        Funcionario funcionario2 = new Supervisor("Marina Souza", "SU-2002", 4800.00, 1200.00);

        funcionario1.exibirDados();
        System.out.println("Salario final: R$ " + funcionario1.calcularSalario());

        System.out.println();

        funcionario2.exibirDados();
        System.out.println("Salario final: R$ " + funcionario2.calcularSalario());

    }

}
