package com.timbuchalka;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit,"Sydney" );
        addInOrder(placesToVisit,"Andorra" );
        addInOrder(placesToVisit,"Brux" );
        addInOrder(placesToVisit,"Aorto" );

        /*placesToVisit.add("Sydney");
        placesToVisit.add("Melbourn");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Sydney");*/
        printList(placesToVisit);
        placesToVisit.add(1, "Alice Springs");
        printList(placesToVisit);
        placesToVisit.remove(4);
        printList(placesToVisit);
        visit(placesToVisit);
    }
    private static void printList(LinkedList<String> linkedList){
        Iterator<String> i=linkedList.iterator();
        while(i.hasNext()){
            System.out.println("Now visiting " +i.next());
        }
        System.out.println("==============================");
    }
    private static boolean addInOrder (LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while(stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0){
                //equal
                System.out.println(newCity + "is already included as a destination");
                return false;
            }else if(comparison > 0){
                //newcity should appear before this one
                //Brisbane -> Adelaide, swap
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if(comparison < 0){
                //move to next
            }

        }
        stringListIterator.add(newCity);
        return true;
    }
    private static void visit(LinkedList<String> cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit= false;
        boolean goingForward=true;
        ListIterator<String> listIterator = cities.listIterator();
        if(cities.isEmpty()){

        }else{
            System.out.println("now visiting "+ listIterator.next());
            printMenu();
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("vacation");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext())
                            listIterator.next();
                        goingForward=true;
                    }
                    if(listIterator.hasNext())
                        System.out.println("now visiting "+ listIterator.next());
                    else {
                        System.out.println("reached the end of the list");
                        goingForward=false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious())
                            listIterator.previous();
                        goingForward=false;
                    }

                    if(listIterator.hasPrevious())
                        System.out.println("now visiting "+ listIterator.previous());
                    else {
                        System.out.println("we are at strat of the list");
                        goingForward=true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }
    private static void printMenu(){
        System.out.println("0- quit");
        System.out.println("1- next city");
        System.out.println("2- previous city");
        System.out.println("3- print menu");
    }
}
