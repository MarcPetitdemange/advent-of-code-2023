package org.exercices.ex2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercice1_2 {
    
    public static void main(String[] args)
            throws IOException {
        List<Integer> addition = new ArrayList<>();
        
        InputStream is = Exercice1_2.class.getClassLoader().getResourceAsStream("Exercice_1.txt");
        Objects.requireNonNull(is);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        String line = "";
        while ((line = br.readLine()) != null) {
            addition.add(getCodeForLine(line));
            System.out.println("Chaine traitée : " + line + " -> " + getCodeForLine(line));
        }
        System.out.println("Result final : " + addition.stream().reduce(0, Integer::sum));
    }
    
    public static int getCodeForLine(String str) {
        
        //8five8vjnzglnrbsbxmjqzfvrsoneightlpx
        String result = "";
        String first = null;
        String last = null;
        ArrayList<String> matches = new ArrayList<>();
        Matcher matcherFirst =
                Pattern.compile("(?<first>[1-9]|(one)|(two)|(three)|(four)|(five)|(six)|(seven)|(eight)|(nine)).*").matcher(str);
        Matcher matcherLast = Pattern.compile(".*(?<last>[1-9]|(one)|(two)|(three)|(four)|(five)|(six)|(seven)|(eight)|(nine))").matcher(str);
        matcherFirst.find();
        matcherLast.find();
        first = checkIfConversionNeeded(matcherFirst.group("first"));
        last = checkIfConversionNeeded(matcherLast.group("last"));
        result =  new StringBuilder().append(first).append(last != null ? last : first).toString();
        return Integer.parseInt(result);
    }
    
    
    
    public static String checkIfConversionNeeded(String str) {
        
        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("one","1");
        hashMap.put("two","2");
        hashMap.put("three","3");
        hashMap.put("four","4");
        hashMap.put("five","5");
        hashMap.put("six","6");
        hashMap.put("seven","7");
        hashMap.put("eight","8");
        hashMap.put("nine","9");
        
        return Character.isDigit(str.charAt(0)) ? str : hashMap.get(str);
    }
    
}
