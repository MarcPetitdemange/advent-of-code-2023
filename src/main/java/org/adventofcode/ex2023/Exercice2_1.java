package org.adventofcode.ex2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercice2_1 {

   private static final int MAX_RED_C = 12;
   private static final int MAX_GREEN_C = 13;
   private static final int MAX_BLUE_C = 14;

   public static void main(String[] args) throws IOException {
      InputStream resource = Exercice2_1.class.getResourceAsStream("/Exercice_2.txt");
      BufferedReader bf = new BufferedReader(new InputStreamReader(Objects.requireNonNull(resource)));
      String line;
      int sum = 0;
      while((line = bf.readLine()) != null){
         System.out.println(line);
         sum += treatLine(line);
      }
      System.out.println("SUM : " + sum);
   }


   public static int treatLine(String str){
      Matcher matcherGameId =  Pattern.compile("(Game (?<gameid>\\d+))").matcher(str);
      matcherGameId.find();
      int gameIdNumber = Integer.parseInt(matcherGameId.group("gameid"));
      if(!checkGameisOkForColor("blue", str, MAX_BLUE_C) | !checkGameisOkForColor("green", str, MAX_GREEN_C) | !checkGameisOkForColor("red", str, MAX_RED_C)) {
         System.out.println("Game " + gameIdNumber + "NOK");
         return 0;
      }
      else return gameIdNumber;
   }

   public static boolean checkGameisOkForColor(String pattern, String str, int max){
      Matcher matcher =  Pattern.compile("((?<nbCube>\\d+) " + pattern + ")").matcher(str);
      while (matcher.find()){
         if (Integer.parseInt(matcher.group("nbCube")) > max) {
            return false;
         }
      }
      return true;
   }
}
