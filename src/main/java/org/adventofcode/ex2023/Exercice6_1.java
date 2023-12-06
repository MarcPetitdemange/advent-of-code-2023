package org.adventofcode.ex2023;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.adventofcode.classes.TimeAndDistance;

public class Exercice6_1 {
    public static void main(String[] args) throws Exception {
        List<Long> times = new ArrayList();
        List<Long> distances = new ArrayList();
        List<TimeAndDistance> timesAndDistances = new ArrayList();
        
        InputStream resource = Exercice2_1.class.getResourceAsStream("/Exercice_6.txt");
        BufferedReader bf = new BufferedReader(new InputStreamReader(Objects.requireNonNull(resource)));
        String line;
        
        while ((line = bf.readLine()) != null) {
            String regex = "(?<number>\\d+)";
            Matcher matcher = Pattern.compile(regex).matcher(line);
            while (matcher.find()) {
                times.add(Long.valueOf(matcher.group("number")));
            }
        }
        distances = times.subList(times.size() / 2, times.size());
        times =  times.subList(0, times.size() / 2);
        System.out.println(times);
        System.out.println(distances);
        
        for(int i = 0; i < times.size(); i++){
            TimeAndDistance timeAndDistance = new TimeAndDistance();
            timeAndDistance.setTime(times.get(i));
            timeAndDistance.setDistance(distances.get(i));
            timesAndDistances.add(timeAndDistance);
        }
        List<Long> possibilites = new ArrayList<>();
        for(TimeAndDistance obj : timesAndDistances){
            possibilites.add(obj.calcNbPossibilite());
        }
        System.out.println(possibilites);
        System.out.println(possibilites.stream().reduce(1L, (a, b) -> a * b));
    }
}
