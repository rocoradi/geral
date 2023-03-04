package br.eu.coradi.estudos.teste;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Meli {

    /*
    List<Integer> umADez =
Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)...
     */

    public static void main(String[] args) {
        List<Integer> umADez = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .map(item -> item ++ )
                .collect(Collectors.toList());
        System.out.println(umADez);

        umADez.stream().filter(item -> item%2 == 0).forEach(item -> System.out.println(item));


    }
}
