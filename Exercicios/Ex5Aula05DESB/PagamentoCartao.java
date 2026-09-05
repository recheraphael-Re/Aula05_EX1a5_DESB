package Exercicios.Ex5Aula05DESB;

public class PagamentoCartao extends Pagamento {

    private String numeroCartao;
    private int parcelas;

    public PagamentoCartao(double valor, String data, String numeroCartao, int parcelas){
        super(valor, data);
        this.numeroCartao = numeroCartao;
        this.parcelas = parcelas;
    }

    public String getNumeroCartao(){
        return numeroCartao;
    }

    public int getParcelas(){
        return parcelas;
    }

    // Cartao cobra 3% sobre o valor da compra
    @Override
    public double calcularTaxa(){
        return getValor() * 0.03;
    }

    @Override
    public void processarPagamento(){
        System.out.println("--- Pagamento via Cartao ---");
        System.out.println("Cartao: " + numeroCartao);
        System.out.println("Parcelas: " + parcelas + "x");
        super.processarPagamento();
    }

}
