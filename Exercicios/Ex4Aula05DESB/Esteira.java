package Exercicios.Ex4Aula05DESB;

public class Esteira extends Maquina {

    private double velocidade;

    public Esteira(String codigo, String nome, String status, double velocidade){
        super(codigo, nome, status);
        this.velocidade = velocidade;
    }

    public double getVelocidade(){
        return velocidade;
    }

    @Override
    public void operar(){
        System.out.println("[" + getCodigo() + "] " + getNome() + " (" + getStatus() + ")");
        System.out.println("Transportando materiais a " + velocidade + " m/s.");
    }

}
