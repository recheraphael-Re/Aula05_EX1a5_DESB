package Exercicios.Ex1Aula05DESB;

public class FilmeDocumentario extends Filme {

    private String tema;

    public FilmeDocumentario(String titulo, int duracao, String classificacao, String tema){
        super(titulo, duracao, classificacao);
        this.tema = tema;
    }

    public String getTema(){
        return tema;
    }

    @Override
    public void exibirDetalhes(){
        System.out.println("--- Documentario ---");
        super.exibirDetalhes();
        System.out.println("Tema: " + tema);
    }

}
