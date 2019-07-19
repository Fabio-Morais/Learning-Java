package com.timbuchalka;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches ;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean newCustomer (String nameBranch, String nameCustomer, double initialAmount){
        Branch branch= findBranch(nameBranch);
        if(branch == null){
            System.out.println("the branch don't exists");
            return false;
        }
        return branch.addCustomer(nameCustomer, initialAmount);

    }
    public boolean newBranch (String nameBranch){
        if(findBranch(nameBranch) != null){
            System.out.println("The branch already exists");
            return false;
        }
        /*OK, add branch*/
        return branches.add(new Branch(nameBranch));
    }

    public boolean printList (String branchName, boolean booleanTransactions){
        Branch branch = findBranch(branchName);
        if(branch == null){
            System.out.println("Branche don't exists");
            return false;
        }
        System.out.println("[" + branchName + "]");
        int numCustomers= branch.getCustomers().size();//numero de utilizadores
        for(int i = 0; i < numCustomers; i++ ){
            System.out.println("\t"+(i+1)+". - "+ branch.getCustomers().get(i).getName()+ ":");
            if(booleanTransactions){
                System.out.println("\t\tTransactions:");
                ArrayList<Double> transactions = branch.getCustomers().get(i).getTransactions();
                for(int j=0; j < transactions.size(); j++ ){
                    System.out.println("\t\t\t\t["+(j+1)+"]  "+transactions.get(j));
                }
            }
        }

        return true;
    }
    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch == null){
            System.out.println("the branch don't exists");
            return false;
        }
        return branch.newTransaction(customerName, amount);
    }

    /* return null if don't exists*/
    private Branch findBranch(String nameBranch){
        for(int i=0; i<branches.size(); i++){
            if(nameBranch.equals(branches.get(i).getName()) )
                return branches.get(i);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }
}
