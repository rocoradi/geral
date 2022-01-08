package br.eu.coradi.estudos.gof.estruturais.bridge;


public class ProfessorPosGraduacao extends Professor{

    public ProfessorPosGraduacao(Implementador imp){
        super(imp);
    }

    public void op() {
        imp.opImpl();
    }
}
