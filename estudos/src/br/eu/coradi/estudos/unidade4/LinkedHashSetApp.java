package br.eu.coradi.estudos.unidade4;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetApp {

    public static void main(String[] args) {
        Set<String> lista = new LinkedHashSet<>();
        lista.add("Vermelho");
        lista.add("Verde");
        lista.add("Verde");
        lista.add("Amarelo");
        System.out.println(lista);
    }
}
