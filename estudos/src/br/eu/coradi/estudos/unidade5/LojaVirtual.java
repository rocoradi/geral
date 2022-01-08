package br.eu.coradi.estudos.unidade5;

import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;

public class LojaVirtual {

    static Map<Cliente, List<Curso>> pagamentos = new HashMap<>();

    public static void listarCursos(List<Curso> lista) {
        // lista.forEach(p-> System.out.println(p.getCdCurso() +"<=>"+p.getNome()));
        lista.forEach(System.out::println);
    }

    public static void main(String[] args) {
        // Criar os cursos disponiveis no site para venda
        Curso java8 = new Curso(1, "Java 8 para Web", 2000, Paths.get("/java8"));
        Curso oracle12c = new Curso(2, "Oracle 12c", 2500, Paths.get("/oracle12c"));
        Curso php7 = new Curso(3, "PHP 7", 1500, Paths.get("/php7"));

        // Cadastrar o cliente
        Cliente antonio = new Cliente("123.123.123-00", "Antonio Sampaio Junior", "email@email.com");

        // Criar a lista de cursos do cliente
        List<Curso> cursosAntonio = new LinkedList<>();

        // Fazer um checkout dos cursos escolhidos
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("Qual curso deseja adquirir: [1-Java8], [1-Oracle12c], [1-Php7] ,[1-Finalizar Compra]");
            opcao = entrada.nextInt();
            if (opcao == 1) {
                cursosAntonio.add(java8);
            } else if (opcao == 2) {
                cursosAntonio.add(oracle12c);
            } else if (opcao == 3) {
                cursosAntonio.add(php7);
            } else {
                opcao = 4;
            }
        }
        entrada.close();
        pagamentos.put(antonio, cursosAntonio);
        System.out.println(pagamentos);
        // listarCursos(cursosAntonio);

        Consumer<List<Curso>> consumer = LojaVirtual::listarCursos;
        consumer.accept(cursosAntonio);
    }
}
