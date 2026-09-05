package Exercicios.Ex4Aula05DESB;

public class Prensa extends Maquina {

    private double toneladas;

    public Prensa(String codigo, String nome, String status, double toneladas){
        super(codigo, nome, status);
        this.toneladas = toneladas;
    }

    public double getToneladas(){
        return toneladas;
    }

    @Override
    public void operar(){
        System.out.println("[" + getCodigo() + "] " + getNome() + " (" + getStatus() + ")");
        System.out.println("Executando processo de conformacao com " + toneladas + " toneladas de forca.");
    }

}
