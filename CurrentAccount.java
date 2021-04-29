class CurrentAccount extends Account{
    int numberOfChecksUsed; //Initalising number of checks
    public CurrentAccount(String accountID,double balance,int numberOfChecksUsed){
        super(accountID, balance);                          //Calling the super abstract class for initalisations of accountID and balance
        this.numberOfChecksUsed = numberOfChecksUsed;       //Initalisting in the constructor number of checks used
        Bank.listOfAccounts.add(this);                      //Adding this object to the list of accounts arraylist when object is instanciated 
    }
    
    boolean withdraw(double amount) {
        if((this.balance - amount - 1) < 0){               //Checking if withdrawal + fee goes below zero
            return false;                                  //If below zero return false
        }

        this.balance -= (amount+1);                         //If not below zero return true and take away fee+withdrawl
        return true;
    }

    void deposit(double amount){
        this.balance += (amount -1);                        //Deposit minus fee
    }
    void resetChecksUsed(){
        this.numberOfChecksUsed = 0;                        //Resets this accounts checks back to zero
    }

    boolean withdrawUsingCheck(double amount){              
        if(this.numberOfChecksUsed <= 3 && this.balance - amount >= -10){   //Checks if the number of checks is smaller than three and account is over negative 10 pounds
            this.balance -= amount;                         //If true takes out amount and increases number of checks by one
            this.numberOfChecksUsed++;                      
            return true;                                    //Returns true to confirm that transaction has gone through
        }
        else if(this.numberOfChecksUsed > 3 && this.balance - (amount+2) >= -10){   //Checks if number of checks is above three and checks if withdrawl + fee is below -10
            this.balance -= (amount+2);                     //If true takes out amount+fee and increases number of checks by one
            this.numberOfChecksUsed++;                          
            return true;                                    //Returns true to confirm that transaction has gone through
        }
        else{
            return false;                                   //If account is below -10 after withdrawl reject the transaction
        }
    }

    public String toString(){
        //Overriding the abstract class account version of toString to include number of checks 
        return "Account[accountID= "+this.accountID+", Balance= "+this.balance+", Number of checks used= "+ this.numberOfChecksUsed+"]";
    }
}