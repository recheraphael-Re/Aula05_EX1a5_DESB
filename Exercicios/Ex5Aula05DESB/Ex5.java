package Exercicios.Ex5Aula05DESB;

import java.util.ArrayList;
import java.util.List;

public class Ex5 {

    public static void main(String[] args){

        // A lista guarda qualquer forma de pagamento (polimorfismo)
        List<Pagamento> pagamentos = new ArrayList<>();

        pagamentos.add(new PagamentoPix(250.00, "05/09/2026", "raphael@email.com"));
        pagamentos.add(new PagamentoCartao(400.00, "05/09/2026", "**** **** **** 1234", 3));
        pagamentos.add(new PagamentoBoleto(180.00, "05/09/2026", "34191.79001 01043.510047"));

        for (Pagamento pagamento : pagamentos){
            pagamento.processarPagamento();
            System.out.println();
        }

    }

}
