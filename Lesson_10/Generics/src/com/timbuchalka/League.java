package com.timbuchalka;

import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team> {
    private String name;
    private ArrayList<T> league;

    public League(String name) {
        this.name = name;
        this.league = new ArrayList<>();
    }

    public boolean addToLeague(T team){
        if(this.league.contains(team)){
            System.out.println("The team already exists");
            return false;
        }
        return this.league.add(team);
    }
    public void printOrder(){
        Collections.sort(league);

        for(T t : league)
            System.out.println(t.getName() + " - "+ t.ranking() );
    }
}
