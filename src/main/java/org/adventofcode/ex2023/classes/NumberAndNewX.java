package org.adventofcode.ex2023.classes;

public class NumberAndNewX {
    private int newX;
    private int number;
    
    public NumberAndNewX() {
    }
    
    public NumberAndNewX(int newX, int number) {
        this.newX = newX;
        this.number = number;
    }
    
    public int getNewX() {
        return newX;
    }
    
    public void setNewX(int newX) {
        this.newX = newX;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
}
