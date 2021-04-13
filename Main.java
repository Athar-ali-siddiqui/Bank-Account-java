
import java.util.*;




class Main{ //main class

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
   
    byte choice ;
    Account a = null;
    //MAIN MENU
    while (true) {
      System.out.println(Arrays.toString(Account.getAccountsArray()));
      System.out.print
      ("\nMain Menu          0: To Exit\n1: Check balance \n2: Deposit \n3: Withdraw \n4: Create Account\nEnter Choice :");
      choice = in.nextByte();
      if(choice != 0 && choice != 4){
        System.out.print("Enter Account id: ");
        a =  Account.getAccountsArray()[in.nextInt()];
      }
      if (choice == 0) {
        break;
      } else if (choice == 1){
        System.out.println("Account Balance is : "+a.getbalance());
      }
      else if (choice == 2){
        System.out.print("Enter Deposit ammount :");
        a.deposit(in.nextDouble());
      }
      else if (choice == 3){
        System.out.print("Enter Withdrawal ammount :");
        a.withdraw(in.nextDouble());
      }
      else if(choice == 4){
        Account.accountsMenu();
      }
      else{
        continue;
      }

    }
  }
}
