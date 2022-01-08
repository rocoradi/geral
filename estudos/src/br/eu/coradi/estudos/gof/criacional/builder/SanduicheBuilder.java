package br.eu.coradi.estudos.gof.criacional.builder;

//Builder
public abstract class SanduicheBuilder {
    public abstract void abrePao();
    public abstract void insereIngredientes();
    public abstract void fechaPao();
    public abstract Sanduiche getSanduiche();
}