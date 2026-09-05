package Exercicios.Ex3Aula05DESB;

public class ProdutoFisico extends Produto {

    private double peso;

    public ProdutoFisico(String codigo, String nome, double preco, double peso){
        super(codigo, nome, preco);
        this.peso = peso;
    }

    public double getPeso(){
        return peso;
    }

    // Frete do produto fisico: peso * 8.0
    @Override
    public double calcularFrete(){
        return peso * 8.0;
    }

    @Override
    public void exibirDetalhes(){
        System.out.println("--- Produto Fisico ---");
        super.exibirDetalhes();
        System.out.println("Peso: " + peso + " kg");
    }

}
