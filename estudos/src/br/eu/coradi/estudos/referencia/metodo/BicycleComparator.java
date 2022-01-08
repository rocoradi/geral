package br.eu.coradi.estudos.referencia.metodo;

import java.util.Comparator;

public class BicycleComparator implements Comparator {

    @Override
    public int compare(Bicycle a, Bicycle b) {
        return a.getFrameSize().compareTo(b.getFrameSize());
    }
}