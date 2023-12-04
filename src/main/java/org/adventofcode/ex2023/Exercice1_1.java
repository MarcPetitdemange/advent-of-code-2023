package org.exercices.ex2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exercice1_1 {
    
    public static void main(String[] args)
            throws IOException {
        List<Integer> addition = new ArrayList<>();
        
        InputStream is = Exercice1_1.class.getClassLoader().getResourceAsStream("./Exercice_1.txt");
        Objects.requireNonNull(is);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        String line = "";
        while ((line = br.readLine()) != null) {
            addition.add(getCodeForLine(line));
            System.out.println(getCodeForLine(line));
        }
        System.out.println("result final : " + addition.stream().reduce(0, Integer::sum));
    }
    
    public static int getCodeForLine(String str) {
        String result = "";
        Character first = null;
        Character last = null;
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                if(Objects.isNull(first)){
                    first = c;
                } else {
                    last = c;
                }
            }
        }
        result =  new StringBuilder().append(first).append(last != null ? last : first).toString();
        return Integer.parseInt(result);
    }
    
    public static boolean checkIfBasement(int count) {
        return count < 0;
    }
    
}
