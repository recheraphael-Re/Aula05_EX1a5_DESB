package Exercicios.Ex5Aula05DESB;

public class PagamentoBoleto extends Pagamento {

    private String codigoBarras;

    public PagamentoBoleto(double valor, String data, String codigoBarras){
        super(valor, data);
        this.codigoBarras = codigoBarras;
    }

    public String getCodigoBarras(){
        return codigoBarras;
    }

    // Boleto cobra 1% sobre o valor da compra
    @Override
    public double calcularTaxa(){
        return getValor() * 0.01;
    }

    @Override
    public void processarPagamento(){
        System.out.println("--- Pagamento via Boleto ---");
        System.out.println("Codigo de barras: " + codigoBarras);
        super.processarPagamento();
    }

}
