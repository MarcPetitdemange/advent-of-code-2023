package org.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercice2_2 {

   private static final int MAX_RED_C = 12;
   private static final int MAX_GREEN_C = 13;
   private static final int MAX_BLUE_C = 14;

   public static void main(String[] args) throws IOException {
      InputStream resource = Exercice2_2.class.getResourceAsStream("/Exercice_2.txt");
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

      int calcPower = getFewerNumberOfCubesToMakeGamePossible("green", str) * getFewerNumberOfCubesToMakeGamePossible("red",str) * getFewerNumberOfCubesToMakeGamePossible("blue",str);
      return calcPower;
   }

   public static int getFewerNumberOfCubesToMakeGamePossible(String pattern, String str){
      Matcher matcher =  Pattern.compile("((?<nbCube>\\d+) " + pattern + ")").matcher(str);
      int maxValue = 1;
      while (matcher.find()){
        int nbCube = Integer.parseInt(matcher.group("nbCube"));
        if(nbCube > maxValue){
           maxValue = nbCube;
        }
      }
      return maxValue;
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
