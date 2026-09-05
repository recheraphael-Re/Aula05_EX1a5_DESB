package Exercicios.Ex1Aula05DESB;

// Classe base do catalogo de streaming
public class Filme {

    private String titulo;
    private int duracao;
    private String classificacao;

    // Cria o construtor

    public Filme(String titulo, int duracao, String classificacao){
        this.titulo = titulo;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getDuracao(){
        return duracao;
    }

    public String getClassificacao(){
        return classificacao;
    }

    // metodo para exibir os detalhes

    public void exibirDetalhes(){
        System.out.println("Titulo: " + titulo);
        System.out.println("Duracao: " + duracao + " minutos");
        System.out.println("Classificacao: " + classificacao);
    }

}
