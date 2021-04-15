class CheckingAccount extends Account{
  
    CheckingAccount( double bal,String name){
      super(bal,name);
      //TODO Auto-generated constructor stub
    }
    @Override
    public void withdraw(double amount){
      if(amount >= this.bal*1.3){ // You can Overdraft only 30% of your Balance as it is Checking Account
        System.out.println("You can Overdraft only 30% of your Balance ");
      }
      else{
        this.bal -= amount;
        transactions.add(new Transaction('W', this.bal, amount));
      }
    }
  
  }
  