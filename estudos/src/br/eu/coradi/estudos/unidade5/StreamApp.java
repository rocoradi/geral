package br.eu.coradi.estudos.unidade5;

import java.util.ArrayList;
import java.util.List;

public class StreamApp {

    static List<String> funcionarios = new ArrayList<>();

    public static void filtrar(String letra){
        funcionarios.stream().filter(f -> f.startsWith(letra)).forEach(System.out::println);
    }

    public static void ordenar(String letra){
        funcionarios.stream().sorted().filter(s->s.startsWith(letra)).forEach(System.out::println);
    }

    public static void contar(String letra) {
        Long resultado = funcionarios.stream().filter(s -> s.startsWith(letra)).count();
        System.out.println(resultado);
    }

    public static void main(String[] args) {
        funcionarios.add("Antonio");
        funcionarios.add("José");
        funcionarios.add("Pedro");
        funcionarios.add("João");
        funcionarios.add("Andreia");

        filtrar("A");
        ordenar("A");
        contar("A");
    }
}
