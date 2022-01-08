package br.eu.coradi.estudos.gof.criacional.builder;


public class HamburguerBuilder extends SanduicheBuilder{

    private Sanduiche s = new Hamburguer();

    public void abrePao() {
        System.out.println("Abre pão de hamburguer.");
    }

    public void insereIngredientes() {
        System.out.println("Insere carne e queijo.");
    }

    public void fechaPao() {
        System.out.println("Fecha pão de hamburguer.");
    }

    public Sanduiche getSanduiche() {
        System.out.println("Hamburguer está pronto !");
        return s;
    }
}
