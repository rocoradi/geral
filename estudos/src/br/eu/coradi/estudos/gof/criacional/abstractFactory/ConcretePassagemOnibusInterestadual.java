package br.eu.coradi.estudos.gof.criacional.abstractFactory;

import java.util.Calendar;

public class ConcretePassagemOnibusInterestadual extends PassagemOnibusInterestadual {

    public ConcretePassagemOnibusInterestadual(String origem, String destino, Calendar dataHoraPartida) {

        super(origem, destino, dataHoraPartida);
    }

    public void exibeDetalhes() {
        System.out.println("Passagem de ônibus interestadual: " + this.getOrigem() +
                " para " + this.getDestino() +
                ", Data/Hora: " + super.df.format(this.getDataHoraPartida().getTime()));
    }
}
