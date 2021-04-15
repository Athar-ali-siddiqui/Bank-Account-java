
class SavingAccount extends Account{
  private double timeInterval;
  private StopWatch watch;
  SavingAccount(double bal,String name){
    super(bal,name);
    this.watch = new StopWatch();

    //TODO Auto-generated constructor stub
  }
  // this method increment balance after every second untill program runs
  private void savingAccountInterest(){
    if(this.watch.checkElapsedTime() >= 30){
      this.watch.stop(); // stopping stopwatch
      this.timeInterval = this.watch.elapsedTime(); // saving elapsed time in variable
      System.out.println("this.timeInterval == "+this.timeInterval);
      this.bal += this.bal * 0.05 * Math.floor(this.timeInterval/30); // incrementing balance by 5% every 30 seconds
      this.watch.start();
    }
  }
  @Override
  public double getbalance(){
    this.savingAccountInterest();
    return this.bal;
  }
  @Override
  public void deposit(double amount){
    this.savingAccountInterest();
    this.bal += amount;
    transactions.add(new Transaction('D', this.bal, amount));
  }
  @Override
  public void withdraw(double amount){
    this.savingAccountInterest();
    System.out.println("in this");
    if(amount > this.bal){
      System.out.println("Your Balance is insufiicient");
    }
    else if(amount > this.bal*0.2){ // As it si Saving Account so we can't withdraw large ammount 
      System.out.println("You can withdraw 20% of your total Amount");
    }
    else{
      this.bal -= amount;
      transactions.add(new Transaction('W', this.bal, amount));
    }
  }
}
