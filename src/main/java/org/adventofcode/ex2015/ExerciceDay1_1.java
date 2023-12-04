package org.exercices.ex2015;

import java.util.Scanner;

public class ExerciceDay1_1 {
    
    
    public static void main(String[] args) {
        int count = 0;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ecrire la séquence : ");
        String str = scanner.nextLine();
        for(char c : str.toCharArray()){
            if(c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
        }
        System.out.println(count);
    }
}