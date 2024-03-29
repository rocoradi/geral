package br.eu.coradi.estudos.Java8Udemy.unidade3;

public class ExemploGenerics2<T,V> {

    T obj1;
    V obj2;

    public ExemploGenerics2(T obj1, V obj2) {
        super();
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public V getObj2() {
        return obj2;
    }

    public void setObj2(V obj2) {
        this.obj2 = obj2;
    }

    public void showType() {
        System.out.println(obj1.getClass().getName());
        System.out.println(obj2.getClass().getName());
    }
}
