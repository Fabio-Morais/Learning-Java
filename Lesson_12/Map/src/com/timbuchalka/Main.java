package com.timbuchalka;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        /*
        * apenas insere 1
        * */
        languages.put("Java", "a compiled high level, object.....");
        languages.put("Python", "an interpreted, obect oriented, ....");
        languages.put("Algol", "an algorithmic language");
        languages.put("Basic", "Beginners all purposes symbolic....");
        languages.put("Lisp", "There in lies madness");

        if(languages.containsKey("Java")){
            System.out.println("already exist");
        }else
            languages.put("Java", "this course is about java");
        System.out.println(languages.get("Java"));

        //languages.remove("Lisp");
        if(languages.remove("Algol", "a family "))
            System.out.println("removed");
        else
            System.out.println("not found");

        System.out.println(languages.replace("Lisp", ".........."));
        System.out.println(languages.replace("lol", "asdasd"));

        System.out.println("===========================");
        for(String key : languages.keySet())
            System.out.println(key + " : "+ languages.get(key));


    }
}
