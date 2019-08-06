package com.timbuchalka;

import java.util.ArrayList;

public class Account {
    private String accountName;
    public int balance = 0;
    public ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }
    public void deposit(int amount){
        if(amount > 0)
        {
            transactions.add(amount);
            balance+=amount;
            System.out.println("deposited, balance is now " + balance);

        }else
            System.out.println("cannot deposit negative ");
    }

    public void withDraw(int amount){
        int withDrawal = -amount;
        if(withDrawal < 0){
            this.transactions.add(withDrawal);
            this.balance+=withDrawal;
            System.out.println(amount+ " withDrwa. balacnce is "+ balance);
        }
    }
    public void calculateBalance(){
        this.balance = 0;
        for(int i : transactions)
            this.balance+=i;
        System.out.println("balance is "+ balance);
    }
}
