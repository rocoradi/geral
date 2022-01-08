package br.eu.coradi.estudos.unidade4;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapApp {

    public static void main(String[] args) {
        Map<Integer, String> mapa = new TreeMap<>();
        mapa.put(4, "Bruno");
        mapa.put(2, "Umberto");
        mapa.put(3, "Fernando");
        mapa.put(3, "Caetano");
        mapa.put(1, "Umberto");
        System.out.println(mapa);
    }
}
