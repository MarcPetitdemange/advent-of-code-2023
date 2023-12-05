package org.adventofcode.ex2023;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.adventofcode.classes.NumberAvecPosAutour;

public class Exercice4_1 {
    
    
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> gameResults = new ArrayList();
        
        InputStream resource = Exercice2_1.class.getResourceAsStream("/Exercice_4.txt");
        BufferedReader bf = new BufferedReader(new InputStreamReader(Objects.requireNonNull(resource)));
        String line;
        while((line = bf.readLine()) != null){
            gameResults.add(analyzeGame(line));
        }
        
       System.out.println("RESULTAT FINAL : " + gameResults.stream().reduce(0, Integer::sum));
        
    }
    
    private static int analyzeGame(String line) {
        String regexAftl = "\\| (?<afterLane>(\\d+|\\s)+)$";
        String regexBfl = ":(?<beforeLane>(\\d|\\s)+)\\|";
        Matcher matcherBfl = Pattern.compile(regexBfl).matcher(line);
        Matcher matcherAftl= Pattern.compile(regexAftl).matcher(line);
        matcherBfl.find();
        matcherAftl.find();
        String beforeLane = matcherBfl.group("beforeLane").trim().replaceAll(" +", " ");
        String afterLane = matcherAftl.group("afterLane").trim().replaceAll(" +", " ");
   
        
        List<Integer> bflInts = Arrays.stream(beforeLane.split(" +")).map(Integer::parseInt).toList();
        List<Integer> aftlInts = Arrays.stream(afterLane.split(" +")).map(Integer::parseInt).toList();
        
        List<Integer> matchings = aftlInts.stream().filter(bflInts::contains).toList();
        
        System.out.println("bf lane : " + bflInts);
        System.out.println("aft lane " + aftlInts);
        System.out.println("matchings " + matchings);
        
        int result = (int) Math.pow(2,matchings.size()-1);
        System.out.println("result " + result);
        
        return result;
    }
    
}
