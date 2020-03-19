/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
public class PatternB{
  public static void main(String[]args){
    Scanner scnr = new Scanner(System.in);
    int userInt;
    int a;
    int b;
    
    System.out.print("Enter and integer between 1 and 10:");
    userInt = scnr.nextInt();
    while(userInt<0 || userInt>10){
      System.out.print("Error: Enter integer between 1 and 10:");
      userInt = scnr.nextInt();
    }
    for (a=userInt; a>=1; a++){
      for(b=1; b<=1; b++){
        System.out.print(b);
        System.out.print(" ");
      }
      System.out.print("");
    }
  }
 
  
}
