package org.adventofcode.ex2023;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.adventofcode.ex2023.classes.NumberAndNewX;

public class Exercice3_1 {
    
    private static final int X_MAX = 140;
    private static final int Y_MAX = 140;
    
    public static void main(String[] args) throws IOException {
        String table[][] = new String[X_MAX][Y_MAX];
        
        InputStream resource = Exercice2_1.class.getResourceAsStream("/Exercice_3.txt");
        BufferedReader bf = new BufferedReader(new InputStreamReader(Objects.requireNonNull(resource)));
        String line;
        int x = 0;
        int y = 0;
        while((line = bf.readLine()) != null){
            System.out.println("x : " + x + " y : " + y);
            for(char c : line.toCharArray()){
                table[y][x] = String.valueOf(c);
                x++;
            }
            x = 0;
            y++;
        }
        
        printTable(table);
        analyzeTable(table);
    }
    
    public static void printTable(String[][] table){
        for(String[] line : table){
            for(String character : line){
                System.out.print(character);
            }
            System.out.print("\n");
        }
    }
    
    public static void analyzeTable(String[][] table){
        ArrayList<Integer> listNumberIdentified = new ArrayList<Integer>();
        for(int y = 0; y < 140; y++){
            for (int x = 0; x < 140; x++){
                NumberAndNewX numberAndNewX = extractNumberWithPosition(x,y, table);
                listNumberIdentified.add(numberAndNewX.getNumber());
                x = numberAndNewX.getNewX();
            }
        }
        System.out.println(listNumberIdentified);
    }
    
    public static NumberAndNewX extractNumberWithPosition(int x, int y, String[][] table) {
        
        NumberAndNewX numberAndNewX = new NumberAndNewX();
        StringBuilder number = new StringBuilder();
        if(Character.isDigit(table[x][y].charAt(0))){
            number.append(table[x][y]);
            while (x+1 < 140 && Character.isDigit(table[x+1][y].charAt(0))){
                x++;
                number.append(table[x][y]);
            }
            numberAndNewX.setNumber(Integer.parseInt(number.toString()));
            number.setLength(0);
        } else {
            x = (x+1 < 140) ? x+1 : x;
        }
        numberAndNewX.setNewX(x);
      
        return numberAndNewX;
    }
    
    public static boolean isAdjacentWithSymbol(int x, int y, String[][] table){
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        return  (((x - 1) > 0 ) &&  special.matcher(table[x-1][y]).matches()) ||
                (((x + 1) < 140 ) && special.matcher(table[x+1][y]).matches()) ||
                (((y - 1) > 0 ) && special.matcher(table[x][y-1]).matches()) ||
                (((y + 1) < 140 ) && special.matcher(table[x][y+1]).matches()) ||
                (((y + 1 < 140) && (x + 1 < 140)) && special.matcher(table[x+1][y+1]).matches()) ||
                (((y + 1 < 140) && (x - 1 > 0)) && special.matcher(table[x-1][y+1]).matches()) ||
                (((y - 1> 0) && (x + 1 < 140)) && special.matcher(table[x+1][y-1]).matches()) ||
                (((y - 1 > 0) && (x - 1 > 0)) && special.matcher(table[x-1][y-1]).matches());
    }
    
}
