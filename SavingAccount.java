class SavingsAccount extends Account{
    double intrestRate;                     //Initalisation of intrest rate
    public SavingsAccount(String accountID, double balance){
        super(accountID, balance);          //Calling the super abstract class for initalisations of accountID and balance
        if(this.balance >= 1000){           //Checks if the inital account is above £1000 to give a free tenner
            this.balance += 10;             
        }
        Bank.listOfAccounts.add(this);      //Adding this savings account to the list of accounts
    }

    boolean withdraw(double amount){
        double tempBalance = this.balance - 3 - amount;     //Storing the account minus withdrawl and fee
        if(tempBalance < 10){                               //If below 10 the withdrawl will bounce 
            return false;                   
        }
        this.balance = tempBalance;                         //If above 10 the withdraw and confirm 
        return true;
    }

    void deposit(double amount){                            //Adding to the account to deposit
        this.balance += amount;
    }

    void addIntrest(double rate){
        intrestRate = rate;                                //Saving intrest rate to the object
        this.balance *= (1+(rate/100));
    }

    public String toString(){
        return  "Account[accountID= "+this.accountID+", Balance= "+this.balance+", Intrest Rate = "+ intrestRate+"]"; //Return the print statement + the intrest rate
    }
}