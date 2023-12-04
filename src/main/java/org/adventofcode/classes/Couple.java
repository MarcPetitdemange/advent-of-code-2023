package org.adventofcode.classes;

public class Couple {
    private int nbA;
    private int nbB;

    public Couple() {
    }

    public Couple(int nbA, int nbB) {
        this.nbA = nbA;
        this.nbB = nbB;
    }

    public int getNbA() {
        return nbA;
    }

    public void setNbA(int nbA) {
        this.nbA = nbA;
    }

    public int getNbB() {
        return nbB;
    }

    public void setNbB(int nbB) {
        this.nbB = nbB;
    }
}
