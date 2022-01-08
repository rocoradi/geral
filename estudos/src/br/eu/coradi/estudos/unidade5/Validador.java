package br.eu.coradi.estudos.unidade5;

@FunctionalInterface
public interface Validador <T> {

    boolean validar(T t);
}
