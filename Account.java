import java.util.ArrayList;
import java.util.Scanner;

import org.graalvm.compiler.nodes.ReturnNode;

class Account {
    private static Account[] accounts = new Account[0];
    private static int numberOfAccounts;
    protected final int id;
    protected String name;
    protected double bal;
    protected ArrayList<Transaction> transactions;
    // Add new created account object in Array(name:accounts)
    public static void addAccount(Account a){ // if we pass any subclass(Saving or checking account) upcasting is done implicitly
      Account[] newArr = new Account[accounts.length+1];
      for (int i = 0; i < accounts.length; i++) {
        newArr[i] = accounts[i];
      }
      newArr[accounts.length] = a;
      accounts = newArr;
      newArr = null;
      System.out.println("Account is created");
    }
    // For the immutability of accounts array this getter method is used
    public static Account[] getAccountsArray(){
      Account[] send = new Account[accounts.length];
      for (int i = 0; i < send.length; i++) {
        send[i] = accounts[i];
      }
      return send;
    } 
    @Override
    public String toString(){
      return "Account holder: " + this.name + "  Account id: "+ this.id + " Current Balance: "+ this.bal;
    }
    //This methods is Account creating & menu method,when we select account type then this method also creates account
    public static boolean accountsMenu(){
      System.out.print("\n Accounts Menu     0:back\n1: Normal Account\n2: Saving Account\n3: Checking Account\nEnter Choice: ");
      byte choice = new Scanner(System.in).nextByte();
      System.out.print("Enter Your Name: ");
      String name = choice != 0 ? new Scanner(System.in).next() : null;
  
      System.out.print("Enter initial amount: ");
      double bal = choice != 0 ? new Scanner(System.in).nextDouble() : 0;

      if (choice == 0){
        return false;
      }
      else if (choice == 1){
        Account newAcc = new Account(bal,name);
      }
      else if (choice ==2){
        SavingAccount newAcc = new SavingAccount(bal,name);
      }
      else if (choice == 3){
        CheckingAccount newAcc = new CheckingAccount(bal,name);
      }
      return false;
    }
  
    // Constructor
    Account(double bal,String name){
      this.name = name;
      this.id = numberOfAccounts++;
      this.bal = bal;
      this.transactions = new ArrayList<>();
      addAccount(this);
    }
    public double getbalance(){
      return this.bal;
    }
    public void deposit(double amount){
      this.bal += amount;
      transactions.add(new Transaction('D', this.bal, amount));
    }
    public void withdraw(double amount){
      if(amount > this.bal){
        System.out.println("Your Balance is insufiicient");
      }
      else{
        this.bal -= amount;
        transactions.add(new Transaction('W', this.bal, amount));
      }
    }
  }
  