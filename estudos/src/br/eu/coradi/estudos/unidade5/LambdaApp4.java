package br.eu.coradi.estudos.unidade5;

import java.util.Arrays;
import java.util.List;

public class LambdaApp4 {

    static int numero;
    int somatorio;

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        LambdaApp4 app = new LambdaApp4();
        integers.forEach(x ->{
            // Diferentemente das variáveis locais, o acesso aos atributos de objeto e de
            // classe (static) podem ser lidos e modificados
            numero = 10;
            x = x + numero;
            app.somatorio = app.somatorio + x;
            System.out.println(x);
        });
        System.out.println(app.somatorio);
    }
}
