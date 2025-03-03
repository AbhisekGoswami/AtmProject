package org.example;

import org.example.Interface.AtmOperations;
import org.example.Interface.NotesImplementation;

public class AtmOperationImpl implements AtmOperations, NotesImplementation {
    ATM atm = new ATM();
    Notes note = new Notes();
    @Override
    public void deposit(double amount,int twoThousandNotes,int fiveHundredNotes,int oneHundredNotes) {
        atm.setBalance(atm.getBalance() + amount);
        note.setTwoThousandNotes(note.getTwoThousandNotes() + twoThousandNotes);
        note.setFiveHundredNotes(note.getFiveHundredNotes() + fiveHundredNotes);
        note.setOneHundredNotes(note.getOneHundredNotes() + oneHundredNotes);
        System.out.println("Amount deposited: " + amount);
        System.out.println("Total balance: " + atm.getBalance());
        System.out.println("2000 notes :"+note.getTwoThousandNotes());
        System.out.println("500 notes :"+note.getFiveHundredNotes());
        System.out.println("100 notes :"+note.getOneHundredNotes());
    }
    @Override
    public void withdraw(double amount) {

        this.withrawAmount(amount);
        if(atm.getBalance() < amount) {
            System.out.println("Insufficient balance");
        } else {
            atm.setBalance(atm.getBalance() - amount);
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Remaining balance: " + atm.getBalance());
            System.out.println("Number of 2000 notes: " + note.getTwoThousandNotes());
            System.out.println("Number of 500 notes: " + note.getFiveHundredNotes());
            System.out.println("Number of 100 notes: " + note.getOneHundredNotes());
        }


    }
    @Override
    public double checkBalance() {
        System.out.println("Balance: " + atm.getBalance());
        System.out.println("Number of 2000 notes: " + note.getTwoThousandNotes());
        System.out.println("Number of 500 notes: " + note.getFiveHundredNotes());
        System.out.println("Number of 100 notes: " + note.getOneHundredNotes());
        return 0;
    }

    public void withrawAmount(double val){

        while(val>0){
            if(val>=2000){
                if(val%2000==0){
                    int numOfNotesOf2000 = (int) (val/2000);
                    int available2000Notes=getavailable2000Notes();
                    if(numOfNotesOf2000<=available2000Notes){
                        debit2000(numOfNotesOf2000);
                        val=0;
                    }
                    else{
                        debit2000(available2000Notes);
                        val=val-(available2000Notes*2000);
                    }

                }
                else if(val>2000){
                    int numOfNotesOf2000= (int) ((val-val%2000)/2000);
                    int available2000Notes=getavailable2000Notes();
                    val=val%2000;
                    if(numOfNotesOf2000<=available2000Notes){
                        debit2000(numOfNotesOf2000);
                    }else{
                        debit2000(available2000Notes);
                    }
                }
            }
            if(val>=500){
                if(val%500==0){
                    int numOfNotesOf500 = (int) (val/500);
                    int available500Notes=getavailable500Notes();
                    if(numOfNotesOf500<=available500Notes){
                        debit500(numOfNotesOf500);
                        val=0;
                    }
                    else{
                        debit500(available500Notes);
                        val=val-(available500Notes*500);
                    }

                }
                else if(val>500){
                    int numOfNotesOf500= (int) ((val-val%500)/500);
                    int available500Notes=getavailable500Notes();
                    val=val%500;
                    if(numOfNotesOf500<=available500Notes){
                        debit500(numOfNotesOf500);
                    }else{
                        debit500(available500Notes);
                    }
                }

            }
            if(val>=100){
                if(val%100==0){
                    int numOfNotesOf100 = (int) (val/100);
                    int available100Notes=getavailable100Notes();
                    if(numOfNotesOf100<=available100Notes){
                        debit100(numOfNotesOf100);
                        val=0;
                    }
                    else{
                        debit100(available100Notes);
                        val=val-(available100Notes*100);
                    }

                }
                else if(val>100){
                    int numOfNotesOf100= (int) ((val-val%100)/100);
                    int available100Notes=getavailable100Notes();
                    val=val%100;
                    if(numOfNotesOf100<=available100Notes){
                        debit100(numOfNotesOf100);
                    }else{
                        debit100(available100Notes);
                    }
                }
            }
        }

    }

    @Override
    public int getavailable2000Notes(){
        return note.getTwoThousandNotes();
    }
    @Override
    public void debit2000(int numOfNotesOf2000){
        note.setTwoThousandNotes(note.getTwoThousandNotes()-numOfNotesOf2000);
    }

    @Override
    public int getavailable500Notes(){
        return note.getFiveHundredNotes();
    }
    @Override
    public void debit500(int numOfNotesOf500){
        note.setFiveHundredNotes(note.getFiveHundredNotes()-numOfNotesOf500);
    }
    @Override
    public int getavailable100Notes(){
        return note.getOneHundredNotes();
    }
    @Override
    public void debit100(int numOfNotesOf100){
        note.setOneHundredNotes(note.getOneHundredNotes()-numOfNotesOf100);
    }


}
