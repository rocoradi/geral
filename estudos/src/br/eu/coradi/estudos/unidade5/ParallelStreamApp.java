package br.eu.coradi.estudos.unidade5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStreamApp {

    static void colecaoStream() {
        List<String> lista = new ArrayList<>();
        int max = 1000000;

        for (int i =0; i <max; i++) {
            lista.add("=>"+i);
        }
        long t0 = System.currentTimeMillis();
        lista.stream().sorted().forEach(System.out::println);
        long t1 = System.currentTimeMillis();
        System.out.println("TEMPO STREAM:" + (t1 - t0));
    }

    static void colecaoParallelStream() {
        List<String> lista = new ArrayList<>();
        int max = 1000000;

        for (int i =0; i <max; i++) {
            lista.add("=>"+i);
        }
        long t0 = System.currentTimeMillis();
        lista.parallelStream().sorted().forEach(System.out::println);
        long t1 = System.currentTimeMillis();
        System.out.println("PARALLEL STREAM: " + (t1 - t0));
    }

    public static void main(String[] args) {
        //colecaoStream();
        colecaoParallelStream();
    }

}
