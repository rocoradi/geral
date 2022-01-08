package br.eu.coradi.estudos.unidade5;

public class ThreadApp {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i <= 1000; i++) {
                    System.out.println(i);
                }
            }
        };

        new Thread(runnable).start();
    }
}
