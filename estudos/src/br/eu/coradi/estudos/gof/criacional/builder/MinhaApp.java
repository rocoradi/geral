package br.eu.coradi.estudos.gof.criacional.builder;

public class MinhaApp {

    public static void main(String[] args) {
        Cozinha cozinha = new Cozinha();

        //Builders
        SanduicheBuilder hamburguer = new HamburguerBuilder();
        SanduicheBuilder fish = new FishBuilder();

        cozinha.fazSanduiche(hamburguer);
        hamburguer.getSanduiche();

        cozinha.fazSanduiche(fish);
        fish.getSanduiche();
    }

}
