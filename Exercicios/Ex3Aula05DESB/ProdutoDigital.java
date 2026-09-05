package Exercicios.Ex3Aula05DESB;

public class ProdutoDigital extends Produto {

    private String formato;

    public ProdutoDigital(String codigo, String nome, double preco, String formato){
        super(codigo, nome, preco);
        this.formato = formato;
    }

    public String getFormato(){
        return formato;
    }

    // Produto digital nao tem custo de entrega
    @Override
    public double calcularFrete(){
        return 0;
    }

    @Override
    public void exibirDetalhes(){
        System.out.println("--- Produto Digital ---");
        super.exibirDetalhes();
        System.out.println("Formato: " + formato);
    }

}
