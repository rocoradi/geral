package br.eu.coradi.estudos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> listOfListofInts = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList( 7, 8, 9));
        System.out.println(listOfListofInts.stream().flatMap(List::stream).collect(Collectors.toList()));
        System.out.println(listOfListofInts.stream().map(i -> i.get(0)).collect(Collectors.toList()));

        // Testando Iterate
        Stream.iterate(1, n->n<=10, n->n+1).forEach(System.out::println);
        Stream.iterate(1, n->n+1).limit(10).forEach(System.out::println);
    }
}
