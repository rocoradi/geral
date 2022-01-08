package br.eu.coradi.estudos.gof.estruturais.bridge;

public class MinhaApp {

    public static void main(String[] args) {

        Professor grad = new ProfessorGraduacao(new ProfessorImplGraduacao());
        grad.op();
    }

}
