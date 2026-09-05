package Exercicios.Ex1Aula05DESB;

public class Ex1 {

    public static void main(String[] args){

        // Referencia do tipo Filme apontando para as subclasses (polimorfismo)

        Filme filme1 = new FilmeAcao("Velocidade Maxima", 118, "16 anos", "Alto");
        Filme filme2 = new FilmeDocumentario("Oceanos Profundos", 95, "Livre", "Vida marinha");

        filme1.exibirDetalhes();
        System.out.println();
        filme2.exibirDetalhes();

    }

}
