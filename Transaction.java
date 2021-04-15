import java.util.*;

public class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance ;

    Transaction( char type , double balance, double amount){
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
        this.type = type;
    }
    // if transaction type is 'W'(withdraw) then this method returns amount else 0.0
    private double getWithdraw(){
        return (this.type == 'W'? this.amount: 0);
    }
    // if transaction type is 'D'(Deposit) then this method returns amount else 0.0
    private double getDeposit(){
        return (this.type == 'D'? this.amount: 0);
    }
    // Returns the Transaction string representation
    @Override
    public String toString(){

        return 
        this.date.toString() +" | " + (this.type == 'W'? this.amount: null) + " | "+ 
        (this.type == 'D'? this.amount: null) +" | " + this.balance;
    }
    // print the table of all transaction of an account
    public static void printTransactionsDetail(ArrayList<Transaction> list){
        int withLen = 8;
        int depLen = 7;
        int balLen = 7;
        // in this loop we are finding number of digits of highest of value in withdraw/deposit/balance
        for (int i = 1; i < list.size(); i++) { 
            if( withLen < String.valueOf( list.get(i).getWithdraw() ).length()){
                withLen = String.valueOf( list.get(i).getWithdraw() ).length();
            }
            if( depLen < String.valueOf( list.get(i).getDeposit() ).length()){
                depLen = String.valueOf( list.get(i).getDeposit() ).length();
            }
            if( balLen < String.valueOf( list.get(i).balance ).length()){
                balLen = String.valueOf( list.get(i).balance ).length();
            }
        }
        printHorizontaldashes(withLen, depLen, balLen);
        // printing table header
        System.out.print("| DATE & TIME                  | WITHDRAW");
        for (int j = 8; j < withLen; j++) {
            System.out.print(" ");
        }
        System.out.print(" | DEPOSIT");
        for (int j = 7; j < depLen; j++) {
            System.out.print(" ");
        }
        System.out.print(" | BALANCE");
        for (int j = 7; j < balLen; j++) {
            System.out.print(" ");
        }
        System.out.println(" |");
        printHorizontaldashes(withLen, depLen, balLen);
        // printing all transactions in table
        for (int i = 0; i < list.size(); i++) {
            System.out.print("| "+ list.get(i).date + " | ");

            System.out.print( list.get(i).getWithdraw() );
            for (int j = String.valueOf(list.get(i).getWithdraw()).length(); j < withLen; j++) System.out.print( " " );

            System.out.print(" | "+ list.get(i).getDeposit() );
            for (int j = String.valueOf(list.get(i).getDeposit()).length(); j < depLen; j++) System.out.print( " " );

            System.out.print(" | "+ list.get(i).balance );
            for (int j = String.valueOf(list.get(i).balance).length(); j < balLen; j++) System.out.print( " " );

            System.out.println(" |");
        }
        printHorizontaldashes(withLen, depLen, balLen);
    }
    // this private static method prints the horizontal lines for transaction table
    private static void printHorizontaldashes( int withLen, int depLen , int balLen ){
        for (int i = 0; i < 28+ 12 + (withLen > 8 ?withLen:8) + (depLen > 8 ?depLen:8) + (balLen > 8 ?balLen:8); i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
