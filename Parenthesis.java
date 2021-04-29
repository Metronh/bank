import java.util.*;
class Parenthesis{
    static boolean balancedParenthesis(String inputString){
        char[] charArray = inputString.toCharArray();               //Converting String to array of chars 
        Stack<Character> balanceStack = new Stack<Character>();     //Initalising stack  for checking
        char checker;                                               //Checker to  store top of stack 
        for (char c : charArray) {                                  //Looping through the String elemeny by element
            if(c == '(' || c == '['){                               //If opening parenthisis push onto array
                balanceStack.push(c);
            }
            if(c == ')' || c == ']'){                              //If closing parenthisis  

                if(balanceStack.isEmpty()){                             //Stack can't be empty in this situation so return false
                    return false;
                }
                checker = balanceStack.peek();                          //Storing the top of stack
                
                // If top of array is opening parenthisis and current element is a closing matching parenthesis remove from top of stack
                if(c == ')' && checker == '('){                        
                    balanceStack.pop();
                }
                else if(c == ']' && checker == '['){
                    balanceStack.pop();
                }
            }
        }
        
        if(!balanceStack.isEmpty()){    //The stack has any elements inside return false because no closing brackets
            return false;
        }
        return true;        //If whole function completes return true
    }
}