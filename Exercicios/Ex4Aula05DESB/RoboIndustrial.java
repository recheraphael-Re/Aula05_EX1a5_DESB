package Exercicios.Ex4Aula05DESB;

public class RoboIndustrial extends Maquina {

    private int eixos;

    public RoboIndustrial(String codigo, String nome, String status, int eixos){
        super(codigo, nome, status);
        this.eixos = eixos;
    }

    public int getEixos(){
        return eixos;
    }

    @Override
    public void operar(){
        System.out.println("[" + getCodigo() + "] " + getNome() + " (" + getStatus() + ")");
        System.out.println("Realizando operacao de montagem com " + eixos + " eixos.");
    }

}
