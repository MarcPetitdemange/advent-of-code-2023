package org.adventofcode.classes;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberAvecPosAutour {

    private int number;
    private ArrayList<Point> arrayList = new ArrayList<>();

    public NumberAvecPosAutour() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Point> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Point> arrayList) {
        this.arrayList = arrayList;
    }

    public boolean isAroundSymbol(char[][] table){
        for(Point p : arrayList){
            if(p.getY() < 140 &&
                    p.getY() >= 0 &&
                    p.getX() < 140 &&
                    p.getX() >= 0 &&
                    Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]/~-]").matcher(String.valueOf(table[(int) p.getY()][(int) p.getX()])).matches()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "NumberAvecPosAutour{" +
                "number=" + number +
                ", arrayList=" + arrayList +
                '}' + "\n";
    }
}
