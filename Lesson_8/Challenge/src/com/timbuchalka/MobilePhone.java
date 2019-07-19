package com.timbuchalka;

import java.util.ArrayList;

public class MobilePhone {

    private static ArrayList<Contacts> myContacts= new ArrayList<Contacts>();
    public void startPhone(){
        System.out.println("Starting phone.....");
    }
    public boolean storeContact(Contacts contact){
        if(findName(contact.getName())<0)
        {
            myContacts.add(contact);
            return true;
        }
        else
        {
            System.out.println("Contact already exists");
            return false;
        }
    }
    public void printContacts (){
        for(int i=0; i<myContacts.size(); i++)
            System.out.println((i+1)+" "+ myContacts.get(i).getName() + "-"+ myContacts.get(i).getPhoneNumber());
    }
    public boolean updateContacts(Contacts oldContact, Contacts newContact){
        int pos= myContacts.indexOf(oldContact);
        if(pos> -1) {
            myContacts.set(pos,newContact);
            System.out.println("Updated");
            return true;
        }
        else{
            System.out.println("Error! Not updated");
            return false;
        }

    }
    public void menu (){
        System.out.println("Choose one option:\r");
        System.out.println("\t0-Print the menu");
        System.out.println("\t1-Print list of contacts");
        System.out.println("\t2-Add new contact");
        System.out.println("\t3-Update existing contact");
        System.out.println("\t4-Remove contact");
        System.out.println("\t5-Find contact");
        System.out.println("\t6-Exit");
    }
    public int findName(String name){
        for(int i=0; i<myContacts.size(); i++){
            if(name.equals(myContacts.get(i).getName()))
                return i;
        }
        return -1;
    }
    public String getNumber(String name){
        if(findName(name) > -1)
            return myContacts.get(findName(name)).getPhoneNumber();
        else
            return null;

    }
    public Contacts getContact(String name){
        int position = findName(name);
        if(position >=0) {
            return myContacts.get(position);
        }

        return null;
    }
    public boolean removeContact (String name){
        Contacts contact = getContact(name);
        if(contact == null){
            System.out.println("The contact don't exists");
            return false;
        }
        myContacts.remove(contact);
        System.out.println("Contact removed");
        return true;
    }
}
