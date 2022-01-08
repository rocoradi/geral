package br.eu.coradi.estudos.referencia.metodo;

import java.util.Arrays;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        List<String> messages = Arrays.asList("hello", "baeldung", "readers!");

        // apache commons a lib
        // Pode ser usado dessa forma
        messages.forEach(word -> StringUtils.capitalize(word));
        // ou utilizando referencia de metodocc
        messages.forEach(StringUtils::capitalize);


        List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);
        // expressão lambda clássica
        numbers.stream().sorted((a, b) -> a.compareTo(b));
        // uso de uma referência de método
        numbers.stream().sorted(Integer::compareTo);

        // assim
        createBicyclesList().stream().sorted((a, b) -> bikeFrameSizeComparator.compare(a, b));

        // ou
        createBicyclesList().stream().sorted(bikeFrameSizeComparator::compare);
    }
}
