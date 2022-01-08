package br.eu.coradi.estudos.gof.criacional.factoryMethod;

import java.util.Calendar;

//Fábrica concreta
public class EmpresaOnibusInterestadual extends Empresa {

    public Passagem emitePassagem(String origem, String destino, Calendar dataHoraPartida) {

        return new PassagemOnibusInterestadual(origem, destino, dataHoraPartida);
    }
}
