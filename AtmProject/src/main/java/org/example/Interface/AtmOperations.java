package org.example.Interface;

public interface AtmOperations {
    void deposit(double amount,int twoThousandNotes,int fiveHundredNotes,int oneHundredNotes);
    void withdraw(double amount);
    double checkBalance();
}
