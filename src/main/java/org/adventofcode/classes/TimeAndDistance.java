package org.adventofcode.classes;

public class TimeAndDistance {
    private Long time;
    private Long distance;
    
    public TimeAndDistance() {
    }
    
    public Long getTime() {
        return time;
    }
    
    public void setTime(Long time) {
        this.time = time;
    }
    
    public Long getDistance() {
        return distance;
    }
    
    public void setDistance(Long distance) {
        this.distance = distance;
    }
    
    public long calcNbPossibilite(){
        int nbPossibilite = 0;
        for(int i = 0; i < time; i++){
            long delta = time - i;
            long distanceCalc =  i * delta;
            if(distanceCalc > getDistance()){
                nbPossibilite++;
            }
        }
        return nbPossibilite;
    }
}
