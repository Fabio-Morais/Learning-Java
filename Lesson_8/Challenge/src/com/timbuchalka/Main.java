package com.timbuchalka;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void array_challenge() {
        /**ARRAY CHALLENGE**/
        Array_chall array_chall = new Array_chall();
        int[] myArray = array_chall.getIntegers(5);
        array_chall.printArray(myArray);
        array_chall.sortIntegers(myArray);
        System.out.println("after sorting\r");
        array_chall.printArray(myArray);
    }

    public static void minim_elem() {
        Array_chall array_chall = new Array_chall();
        System.out.println("How many numbers do you want? ");
        int num = array_chall.scanner.nextInt();
        array_chall.scanner.nextLine();
        int[] array = array_chall.readIntegers(num);
        array_chall.printArray(array);
        System.out.println("Min: " + array_chall.findMin(array));
    }

    public static void reverseArray_chall() {
        Array_chall array_chall = new Array_chall();
        int[] array = {1, 2, 3, 4, 4, 5, 5, 6};
        array_chall.printArray(array);
        array_chall.reverse(array);
        array_chall.printArray(array);
    }

    public static void arrayList_chall1() {
        boolean exit = false;
        mobilePhone.startPhone();
        mobilePhone.menu();
        while (!exit) {
            int action;
            while(true) {
                if (scanner.hasNextInt()) {
                    action = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Wrong choice");
                }
                scanner.nextLine();
            }
            switch (action){
                case 0:
                    mobilePhone.menu();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    exit=true;
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }

    public static void autoBox_chall(){
        Bank bank = new Bank("BPI");
        bank.newBranch("fabio");
        bank.newCustomer("fabio", "ana", 10);
        bank.newCustomer("fabio", "bea", 10);
        bank.newCustomer("fabio", "rita", 10);
        bank.newBranch("lol");
        bank.addCustomerTransaction("fabio", "ana", 11.5);
        bank.addCustomerTransaction("fabio", "ana", 51.5);
        bank.addCustomerTransaction("fabio", "ana", 13.5);
        bank.addCustomerTransaction("fabio", "ana", 21.5);
        bank.printList("fabio",true);
        bank.newCustomer("asd", "rita", 10);
        bank.addCustomerTransaction("fabio", "ds", 51.5);
        bank.newCustomer("fabio", "rita", 10);




    }
    public static void main(String[] args) {
        //array_challenge();
        //minim_elem();
        //reverseArray_chall();
        //arrayList_chall1();
        autoBox_chall();

    }
    /**CHALLENGE CONTACT PHONE ARRAY LIST*/
    public static void addContact() {
        System.out.println("Insert the name: ");
        String name = scanner.nextLine();
        System.out.println("Insert the contact: ");
        String contact = scanner.nextLine();
        Contacts contacts = new Contacts(name, contact);
        if (mobilePhone.storeContact(contacts))
            System.out.println("New contact added successful: name " + name + " phone " + contact);
        else
            System.out.println("Contact already exists");
    }
    public static void updateContact(){
        System.out.println("Insert the name that you want to update");
        String name = scanner.nextLine();
        Contacts contactOld = mobilePhone.getContact(name);
        if(contactOld == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        if(mobilePhone.findName(newName) > -1){
            System.out.println("the name already exists");
            return;
        }
        Contacts newContact = new Contacts(newName, newNumber);

        mobilePhone.updateContacts(contactOld, newContact);

    }
    public static void findContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts contact = mobilePhone.getContact(name);
        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + contact.getName() + " phone number is " + contact.getPhoneNumber());

    }
    public static void removeContact(){
        System.out.println("What the name of the contact that you want to remove?");
        String name = scanner.nextLine();
        mobilePhone.removeContact(name);
    }

    /**CHALLENGE BANK AUTO BOX*/










}
