package org.adventofcode.ex2023;

import org.adventofcode.classes.NumberAvecPosAutour;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Exercice3_1 {
    
    private static final int X_MAX = 140;
    private static final int Y_MAX = 140;
    
    public static void main(String[] args) throws IOException {
        char table[][] = new char[X_MAX][Y_MAX];
        
        InputStream resource = Exercice2_1.class.getResourceAsStream("/Exercice_3.txt");
        BufferedReader bf = new BufferedReader(new InputStreamReader(Objects.requireNonNull(resource)));
        String line;
        int x = 0;
        int y = 0;
        while((line = bf.readLine()) != null){
            for(char c : line.toCharArray()){
                table[y][x] = c;
                x++;
            }
            x = 0;
            y++;
        }
        printTable(table);
        analyzeTable(table);
    }
    
    public static void printTable(char[][] table){
        for(char[] line : table){
            for(char character : line){
                System.out.print(character);
            }
            System.out.print("\n");
        }
        System.out.println("---------------------------------------------------------------");
    }
    
    public static void analyzeTable(char[][] table){
        ArrayList<NumberAvecPosAutour> arrayList = new ArrayList<NumberAvecPosAutour>();
        for(int y = 0; y < 140; y++){
            StringBuilder nombre = new StringBuilder();
            NumberAvecPosAutour numberAvecPosAutour = new NumberAvecPosAutour();
            char lastChar = table[y][0];
            for (int x = 1; x < 140; x++){
                if(!Character.isDigit(lastChar)){
                    nombre.setLength(0);
                    numberAvecPosAutour = new NumberAvecPosAutour();
                }

                if(Character.isDigit(table[y][x])){
                    nombre.append(table[y][x]);
                    numberAvecPosAutour.getArrayList().addAll(
                            List.of(new Point[]{
                                    new Point(x - 1, y),
                                    new Point(x - 1, y - 1),
                                    new Point(x - 1, y + 1),
                                    new Point(x, y + 1),
                                    new Point(x, y - 1),
                                    new Point(x + 1, y),
                                    new Point(x + 1, y - 1),
                                    new Point(x + 1, y + 1)
                                    ,})
                    );
                }

                if(Character.isDigit(lastChar) && !Character.isDigit(table[y][x])){
                    numberAvecPosAutour.setNumber(Integer.parseInt(nombre.toString()));
                    arrayList.add(numberAvecPosAutour);
                }
                lastChar = table[y][x];
            }
        }

        List<Integer> list = arrayList.stream().filter(x -> x.isAroundSymbol(table)).toList().stream().map(NumberAvecPosAutour::getNumber).toList();

        System.out.println("Valeur finale " + list.stream().reduce(0,Integer::sum));
    }

//    public static ArrayList<Point2D> calcCoordAutour(int x, int y){
//        if(x < 139){
//        }
//    }
    
    
}
