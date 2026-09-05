package Exercicios.Ex5Aula05DESB;

public class PagamentoPix extends Pagamento {

    private String chavePix;

    public PagamentoPix(double valor, String data, String chavePix){
        super(valor, data);
        this.chavePix = chavePix;
    }

    public String getChavePix(){
        return chavePix;
    }

    // PIX nao cobra taxa
    @Override
    public double calcularTaxa(){
        return 0;
    }

    @Override
    public void processarPagamento(){
        System.out.println("--- Pagamento via PIX ---");
        System.out.println("Chave PIX: " + chavePix);
        super.processarPagamento();
    }

}
