package Exercicios.Ex3Aula05DESB;

public class Ex3 {

    public static void main(String[] args){

        // Referencia do tipo Produto apontando para as subclasses (polimorfismo)

        Produto produto1 = new ProdutoFisico("PF-100", "Teclado Mecanico", 320.00, 1.5);
        Produto produto2 = new ProdutoDigital("PD-200", "Curso de Java", 149.90, "Video online");

        produto1.exibirDetalhes();
        System.out.println("Frete: R$ " + produto1.calcularFrete());

        System.out.println();

        produto2.exibirDetalhes();
        System.out.println("Frete: R$ " + produto2.calcularFrete());

        System.out.println();
        System.out.println("--- Por que Produto pode guardar ProdutoFisico ou ProdutoDigital? ---");
        System.out.println("Porque as duas classes herdam de Produto, entao todo ProdutoFisico");
        System.out.println("e todo ProdutoDigital tambem E-UM Produto. A variavel do tipo da");
        System.out.println("superclasse aceita qualquer objeto das subclasses (upcasting).");
        System.out.println("O compilador olha o tipo da variavel para saber quais metodos podem");
        System.out.println("ser chamados, mas na execucao a JVM usa o metodo sobrescrito do");
        System.out.println("objeto real - por isso calcularFrete() devolve peso * 8.0 no fisico");
        System.out.println("e 0 no digital, mesmo as duas chamadas sendo feitas por Produto.");

    }

}
