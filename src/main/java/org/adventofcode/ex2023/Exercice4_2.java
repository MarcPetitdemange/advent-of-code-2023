package org.adventofcode.ex2023;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercice4_2 {


    public static final int NB_LINE = 218;

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> gameResults = new ArrayList();
        
        InputStream resource = Exercice2_1.class.getResourceAsStream("/Exercice_4.txt");
        BufferedReader bf = new BufferedReader(new InputStreamReader(Objects.requireNonNull(resource)));
        String line;
        
        HashMap<Integer, Integer> countInstanceForEachGame = new HashMap<Integer, Integer>();
        
        for(int i = 1; i <= NB_LINE; i++){
            countInstanceForEachGame.putIfAbsent(i, 1);
        }
        
        while((line = bf.readLine()) != null){
            String regexAftl = "\\| (?<afterLane>(\\d+|\\s)+)$";
            analyzeGame(line, countInstanceForEachGame);
        }

        System.out.println("List count instance : " + countInstanceForEachGame.values());
        System.out.println("List count instance : " + countInstanceForEachGame.values().stream().reduce(Integer::sum));

    }
    
    private static void analyzeGame(String line, HashMap<Integer, Integer> countInstanceForEachGame) {
        
        String noCardPattern = "(Card(\\s+)(?<noCard>\\d+):)";
        Matcher noCardMatcher = Pattern.compile(noCardPattern).matcher(line);
        noCardMatcher.find();
        Integer noCard = Integer.valueOf(noCardMatcher.group("noCard"));
        
        
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
        
        System.out.println("\n\nNO CARD : " + noCard);
//
//        System.out.println("bf lane : " + bflInts);
//        System.out.println("aft lane " + aftlInts);
//        System.out.println("matchings " + matchings);
        
        System.out.println("Refresh for card n° " + noCard + " : matching " + matchings.size());
        for(int i = 1; (i <= matchings.size()); i++){
            int noNextCard = noCard + i;
            countInstanceForEachGame.compute(noNextCard, (k,v) -> v + countInstanceForEachGame.get(noCard));
            System.out.println("n°" + noNextCard + " --> " + countInstanceForEachGame.get(noNextCard) );
        }
    }
    
}
