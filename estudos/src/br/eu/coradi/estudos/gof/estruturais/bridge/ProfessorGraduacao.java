package br.eu.coradi.estudos.gof.estruturais.bridge;


public class ProfessorGraduacao extends Professor{

    public ProfessorGraduacao(Implementador imp){
        super(imp);
    }

    public void op() {
        System.out.println("Olá");
        imp.opImpl();
    }
}
