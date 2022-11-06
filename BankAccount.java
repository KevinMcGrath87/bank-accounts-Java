import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private long accountNumber;
    private static int numberOfAccounts;
    private static double accountsTotal;
    private static ArrayList<BankAccount> accountsList = new ArrayList<BankAccount>();
    // getters
    public double getChecking(){
        return this.checkingBalance;
    }
    public double getSavings(){
        return this.savingsBalance;
    }
    public long getAccountNumber(){
        return this.accountNumber;
    }
    public static int getNumberOfAccounts(){
        return numberOfAccounts;
    }
    public double getmyAccountTotal(){
        return(this.savingsBalance+this.checkingBalance);
    }

    //setters
    public void deposit(String accountType, double amount){
        if (amount > 0){
            if(accountType.equals("checking")){
                checkingBalance = checkingBalance + amount;
            }
            else if(accountType.equals("savings")){
                savingsBalance = savingsBalance +amount;
            }
            else {
                System.out.println("please determine which account checking or savings you would like to deposit to.");
            }
        }
    }

    // withdraw
    public void withdraw(String accountType, double amount){
        
        if (amount > 0){
            amount = amount*-1;
        }
        if(accountType.equals("checking")){
            if(checkingBalance >= Math.abs(amount)){
                checkingBalance = checkingBalance + amount;
            }
        }
        else if(accountType.equals("savings")){
            if(savingsBalance >= Math.abs(amount))
            savingsBalance = savingsBalance + amount;
        }
        else {
            System.out.println("please determine which account checking or savings you would like to withdraw from.");
        }
    }



    //account number generator
    private static long accountNumberGenerator(){
        Random numberGenerator = new Random();
        long acctNumber = 0;
        for(int x = 0; x < 10; x++){
            long number = numberGenerator.nextInt(10);
            System.out.println(Math.pow(10,x));
            acctNumber =  acctNumber + (long)(Math.pow(10,x))*number;
        }
        return acctNumber;
    }


    //constructor
    public BankAccount(double checking, double savings){
        this.checkingBalance = checking;
        this.savingsBalance = savings;
        this.accountNumber = accountNumberGenerator();
        numberOfAccounts++;
        accountsTotal = accountsTotal + (checking+savings);
        accountsList.add(this);
    }

}