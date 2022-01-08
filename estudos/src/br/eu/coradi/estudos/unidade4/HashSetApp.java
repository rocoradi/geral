package br.eu.coradi.estudos.unidade4;

import java.util.HashSet;
import java.util.Set;

public class HashSetApp {

    public static void main(String[] args) {
        Set<String> lista = new HashSet<>();
        lista.add("Vermelho");
        lista.add("Verde");
        lista.add("Verde");
        lista.add("Amarelo");
        System.out.println(lista);
    }
}
