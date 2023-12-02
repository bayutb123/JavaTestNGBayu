package com.juaracoding;

public class Main {

    static BankAccount bankAccount;
    public static void main(String[] args) {
        bankAccount = new BankAccount();

        bankAccount.setAccount(
                1, "Data", 20.50
        );

        System.out.println(bankAccount.amount);
    }
}