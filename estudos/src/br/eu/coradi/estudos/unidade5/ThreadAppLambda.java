package br.eu.coradi.estudos.unidade5;

public class ThreadAppLambda {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i=0;i<=1000;i++) {
                System.out.println(i);
            }
        };

        new Thread(runnable).start();
    }
}
