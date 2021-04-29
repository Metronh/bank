abstract class Account{
    String accountID;           //Initialisation for constructor
    double balance;
    public Account(String accountID,double balance){
        this.accountID = accountID;         //Initalisation constructor for abstract
        this.balance = balance;
    }

    
    public String toString(){
        return "Account[accountID= "+this.accountID+", Balance= "+this.balance+"]";     //Returns the account and balance in string format for the current object
    }

    abstract boolean withdraw(double amount);       //Abstract methods for currentAccount and SavingAccount these are mandatory functions
    abstract void deposit(double amount);           
}