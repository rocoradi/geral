package br.eu.coradi.estudos.unidade5;

public class Calculadora implements Formula{

    public static void main(String[] args) {
        IMatematica anonimo = new IMatematica() {
            @Override
            public int somar(int a, int b) {
                return a+b;
            }

            @Override
            public int subtrair(int a, int b) {
                return a-b;
            }

            @Override
            public int multiplicar(int a, int b) {
                return a*b;
            }

            @Override
            public int dividir(int a, int b) {
                return a/b;
            }
        };
        System.out.println("anônimo: " + anonimo.getClass());
        System.out.println("=> " + anonimo.somar(5,5));
        System.out.println("=> " + anonimo.subtrair(6,4));
        System.out.println("=> " + anonimo.multiplicar(3,4));
        System.out.println("=> " + anonimo.dividir(10,2));
    }

    @Override
    public double calcular(int a) {
        return 0;
    }
}
