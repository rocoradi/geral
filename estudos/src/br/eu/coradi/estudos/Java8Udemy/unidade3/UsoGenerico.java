package br.eu.coradi.estudos.Java8Udemy.unidade3;

public class UsoGenerico {

    public static void main(String[] args) {
        // T foi definido como Integer com valor 88.
        ExemploGenerics<Integer> iob = new ExemploGenerics<>(88);
        iob.showType();

        // T foi definido como String “Coradi”.
        ExemploGenerics<String> sob = new ExemploGenerics<>("Coradi");
        sob.showType();
    }
}
