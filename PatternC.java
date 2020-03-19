//Ryan McGuiness
//CSE-002

import java.util.Scanner;
public class PatternC {
  
  public static void main(String args[]){
    
    Scanner scnr = new Scanner(System.in);
    int userInt;

   
    System.out.println("Enter an interger between 1 and 10: ");
    userInt = scnr.nextInt();
    while(userInt<0 || userInt>10){
      System.out.print("Error: Enter interger between 1 and 10:");
      userInt = scnr.nextInt();
    }
    
    for (int a=1; a<=userInt; a++){
      for (int b=userInt-1; b>=a; b--){
        System.out.print(" ");
      }
      for (int c=1; c<=a; c++){
        System.out.print(c);
      }
      System.out.println("");
    }
  }
  
}
