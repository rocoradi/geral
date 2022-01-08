package br.eu.coradi.estudos.unidade5;

public class VlidadorApp {

    public static void main(String[] args) {
        String celular = "99634-4301";
        Validador<String> validacao = valor -> valor.matches("[0-9]{5}-[0-9]{4}");
        System.out.println(validacao.validar(celular));
    }
}
