package br.eu.coradi.estudos.gof.criacional.singleton;

//Singleton
public class Janela {

    private static Janela janela = null;

    private Janela() {
        // atributos default
    }

    public static Janela getInstance() {
        if (janela == null) {
            janela = new Janela();
        }

        return janela;
    }
}
