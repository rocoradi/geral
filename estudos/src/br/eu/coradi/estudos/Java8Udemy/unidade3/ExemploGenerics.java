package br.eu.coradi.estudos.Java8Udemy.unidade3;

// T é o nome do Tipo do Parâmetroc
public class ExemploGenerics <T>{

    // obj é do tipo T que será especificado
    // quando o objeto ExemploGenerics for criado.
    T obj;

    public ExemploGenerics(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void showType() {
        System.out.println(obj.getClass().getName());
    }
}
