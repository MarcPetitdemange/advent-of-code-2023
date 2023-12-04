package org.adventofcode.ex2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            System.out.println("x : " + x + " y : " + y);
            for(char c : line.toCharArray()){
                table[y][x] = c;
                x++;
            }
            x = 0;
            y++;
        }
        printTable(table);
    }
    
    public static void printTable(char[][] table){
        for(char[] line : table){
            for(char character : line){
                System.out.print(character);
            }
            System.out.print("\n");
        }
    }
    
    public static void analyzeTable(char[][] table){
        for(int x = 0; x <= 140; x++){
            for (int y = 0; y <= 140; y++){
            
            }
        }
    }
    
    public static extractNumberWithPosition(){
    
    }
    
    
}
