package br.eu.coradi.estudos.gof.criacional.builder;

public class Cozinha{

    public void fazSanduiche(SanduicheBuilder builder){
        builder.abrePao();
        builder.insereIngredientes();
        builder.fechaPao();
    }
}
