package org.exercices.ex2015;

import java.util.Scanner;

public class ExerciceDay2_2 {
    
    public static void main(String[] args) {
        int countFloor = 0;
        int i = 0;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ecrire la séquence : ");
        String str = scanner.nextLine();
        for(char c : str.toCharArray()){
            i++;
            if(c == '(') {
                countFloor++;
            } else if (c == ')') {
                countFloor--;
            }
            
            if(checkIfBasement(countFloor)){
                System.out.println(i);
                return;
            }
        }
    }
    
    public static boolean checkIfBasement(int count){
        return count < 0;
    }
    
}
