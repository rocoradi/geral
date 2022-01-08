package br.eu.coradi.estudos.gof.estruturais.adapter;

//Target
public abstract class Tomada<P> {

	public abstract String conecta(P plug);
	
	public abstract String getNomeRede();
}
