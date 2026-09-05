package Exercicios.Ex3Aula05DESB;

// Classe base dos produtos do e-commerce
public class Produto {

    private String codigo;
    private String nome;
    private double preco;

    public Produto(String codigo, String nome, double preco){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    // Na classe base ainda nao existe regra de frete
    public double calcularFrete(){
        return 0;
    }

    public void exibirDetalhes(){
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Preco: R$ " + preco);
    }

}
