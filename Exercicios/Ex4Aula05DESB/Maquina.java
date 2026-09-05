package Exercicios.Ex4Aula05DESB;

// Classe base das maquinas da linha de producao
public class Maquina {

    private String codigo;
    private String nome;
    private String status;

    public Maquina(String codigo, String nome, String status){
        this.codigo = codigo;
        this.nome = nome;
        this.status = status;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    public String getStatus(){
        return status;
    }

    // Comportamento generico, cada subclasse define o seu
    public void operar(){
        System.out.println("[" + codigo + "] " + nome + " (" + status + ") esta em operacao.");
    }

}
