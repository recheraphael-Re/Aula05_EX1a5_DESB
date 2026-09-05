package Exercicios.Ex5Aula05DESB;

// Classe base das formas de pagamento da loja virtual
public class Pagamento {

    private double valor;
    private String data;

    public Pagamento(double valor, String data){
        this.valor = valor;
        this.data = data;
    }

    public double getValor(){
        return valor;
    }

    public String getData(){
        return data;
    }

    // Na classe base nao ha taxa definida
    public double calcularTaxa(){
        return 0;
    }

    public void processarPagamento(){
        System.out.println("Processando pagamento de R$ " + valor + " em " + data);
        System.out.println("Taxa: R$ " + calcularTaxa());
        System.out.println("Total: R$ " + (valor + calcularTaxa()));
    }

}
