package br.eu.coradi.estudos.unidade5;

import java.util.Arrays;
import java.util.List;

public class LambdaApp3 {

    public static void main(String[] args) {
        // variavel local nao se pode alterar dentro do lambda
        int numero = 10;
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.forEach(x ->{
            // Variaveis fora do escopo podem ser lidas mas não alteradas
            // numero = 20;
            x = x + numero;
            System.out.println(x);
        });
    }
}
