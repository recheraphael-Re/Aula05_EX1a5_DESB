package Exercicios.Ex4Aula05DESB;

import java.util.ArrayList;
import java.util.List;

public class Ex4 {

    public static void main(String[] args){

        // Uma unica lista guarda objetos de subclasses diferentes
        List<Maquina> maquinas = new ArrayList<>();

        maquinas.add(new Esteira("MQ-01", "Esteira Principal", "Ativa", 1.2));
        maquinas.add(new RoboIndustrial("MQ-02", "Robo de Montagem", "Ativa", 6));
        maquinas.add(new Prensa("MQ-03", "Prensa Hidraulica", "Manutencao", 150.0));

        // O mesmo operar() se comporta de forma diferente conforme o objeto
        for (int i = 0; i < maquinas.size(); i++){
            maquinas.get(i).operar();
            System.out.println();
        }

    }

}
