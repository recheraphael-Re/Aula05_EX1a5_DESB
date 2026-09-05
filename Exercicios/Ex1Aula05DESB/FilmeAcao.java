package Exercicios.Ex1Aula05DESB;

public class FilmeAcao extends Filme {

    private String nivelViolencia;

    public FilmeAcao(String titulo, int duracao, String classificacao, String nivelViolencia){
        super(titulo, duracao, classificacao);
        this.nivelViolencia = nivelViolencia;
    }

    public String getNivelViolencia(){
        return nivelViolencia;
    }

    @Override
    public void exibirDetalhes(){
        System.out.println("--- Filme de Acao ---");
        super.exibirDetalhes();
        System.out.println("Nivel de violencia: " + nivelViolencia);
    }

}
