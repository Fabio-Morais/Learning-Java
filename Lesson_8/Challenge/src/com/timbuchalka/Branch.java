package com.timbuchalka;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }
    public boolean addCustomer(String nameCustomer, double initialAmount){
        if(findCustomer(nameCustomer) == null)
        {
            Customer customer = new Customer(nameCustomer);

            return customers.add(customer) && customer.getTransactions().add(initialAmount);
        }
        System.out.println("The customer name already exists");
        return false;
    }
    public boolean newTransaction(String nameCostumer, double amount){
        Customer customer = findCustomer(nameCostumer);
        if(customer == null){
             System.out.println("Costumer don't exists");
             return false;
         }
        return customer.getTransactions().add(amount);
    }

    public Customer findCustomer(String nameCustomer){
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getName().equals(nameCustomer))
                return customers.get(i);
        }
        return null;
    }
    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
