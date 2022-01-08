package br.eu.coradi.estudos.unidade4;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetApp {

    public static void main(String[] args) {
        Set<String> lista = new TreeSet<>();
        lista.add("Vermelho");
        lista.add("Verde");
        lista.add("Verde");
        lista.add("Amarelo");
        System.out.println(lista);
    }
}
