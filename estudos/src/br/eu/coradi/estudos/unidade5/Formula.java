package br.eu.coradi.estudos.unidade5;

@FunctionalInterface
public interface Formula {

    double calcular(int a); // apenas 1 método abstrato

    // varios métodos default
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    default double sqrtX(int a, int b) {
        return Math.pow(a, 1/b);
    }
}
