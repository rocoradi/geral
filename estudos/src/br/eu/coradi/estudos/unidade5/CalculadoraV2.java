package br.eu.coradi.estudos.unidade5;

public class CalculadoraV2 {

    public static void main(String[] args) {
        CalculadoraV2 ex = new CalculadoraV2();
        IMath somar = (a,b) -> a+b;
        IMath subtrair = (a,b) -> a-b;
        IMath multiplicar = (a,b) -> a*b;
        IMath dividir = (a,b) -> a/b;

        System.out.println(ex.execOperacao(2,2, somar));
        System.out.println(ex.execOperacao(2,2, subtrair));
        System.out.println(ex.execOperacao(2,2, multiplicar));
        System.out.println(ex.execOperacao(4,2, dividir));
    }

    public int execOperacao(int a, int b, IMath op) {
        return op.operacao(a,b);
    }
}
