package ohtu;

import java.util.*;

public class Submission {

    private int week;
    int teht = 0;
//    int[] exercises;
    List<Integer> exercises = new ArrayList<>();
    int[] exer;
    private int hours;
    

    public void setWeek(int week) {
        this.week = week;
    }

    public void setHours(int h) {
        hours = h;
    }
    
    public int getHours(){
        return hours;
    }

    public int getWeek() {
        return week;
    }
    
    public void setExercises(int i){
        
        exercises.add(i);
        exer[teht] = i;
        teht++;
        System.out.println("setting");
        System.out.println(i);
    }
 
    @Override
    public String toString() {
        String t = "";
        teht = 0;
        for(int i = 0; i< exercises.size(); i++){
            t += exercises.get(i) + " ";
            teht++;
        }
        
        return "Viikko: " + week + ", tehtyjä tehtäviä: " + teht + ", tunnit: " + hours + ", tehdyt tehtävät: " + t;
    }

}
