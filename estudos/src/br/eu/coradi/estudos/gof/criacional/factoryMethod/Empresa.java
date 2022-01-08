package br.eu.coradi.estudos.gof.criacional.factoryMethod;

import java.util.Calendar;

// Fabrica
public abstract class Empresa {

    public abstract Passagem emitePassagem(String origem, String destino, Calendar dataHoraPartida);
}