import java.util.ArrayList;

public class Bank{
    String name;           //Initalising name and intrestrate of the bank                                             
    Double intrestRate;         
    static ArrayList<Account> listOfAccounts = new ArrayList<Account>(); //Initalising the listOfAccounts to store the list of accounts at the bank
    
    public Bank(String name, Double intrestRate){
        this.name = name;                                   //Constructor for the bank and declaring the local variables
        this.intrestRate = intrestRate;
    }
    
    boolean deposit(String accountID, double amount){               
        
        for (int i = 0; i < listOfAccounts.size(); i++) {       //Searching through listOfAccounts 
            if(listOfAccounts.get(i).accountID == accountID){   //If found it calls the deposit method on that account
                listOfAccounts.get(i).deposit(amount);
                return true;                                    //returns true to confirm the deposit
            }
        }
        return false;                                           //Else it returns false to show the rejection
    }

    boolean withdraw(String accountID, double amount){
        for (int i = 0; i < listOfAccounts.size(); i++) {        //Searching through list of accounts
            if(listOfAccounts.get(i).accountID == accountID){    
                if(listOfAccounts.get(i).withdraw(amount)){       //If found call the withdraw function
                    return true;                                  //If withdraw function returns withdraw returns true to confirm
                }               
            }
        }
        return false;                                             //If the account isn't found or account doesn't exist returns false
    }

    boolean transfer(String fromAccountID, String toAccountID, double amount){
        int indexFrom = -1;                                      //A place to store the index of the from account
        int indexTo = -1;                                        //A place to store the index of the to account
        for (int i = 0; i < listOfAccounts.size(); i++) {        //Searching the array to find the from index
            if(listOfAccounts.get(i).accountID == fromAccountID){
                indexFrom = i;
                break;
            }
        }

        for (int i = 0; i < listOfAccounts.size(); i++) {          //Searching the array to find the to index
            if(listOfAccounts.get(i).accountID == toAccountID){    
                indexTo = i;
                break;
            }
        }

        if(indexFrom == -1 || indexTo == -1 ){                      //Checks if both accounts exist
            return false;
        }

        if(listOfAccounts.get(indexFrom).withdraw(amount)){         //First withdraws from the from account and then if true does deposit and confirms transfer
            listOfAccounts.get(indexTo).deposit(amount);
            return true;
        }

        return false;               //Else returns false
    }
}