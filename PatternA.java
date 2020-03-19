/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
public class PatternA {
  public static void main(String [] args){
    Scanner scnr = new Scanner(System.in);
    int userInt;
    int a;
    int b;
    
    System.out.println("Enter an interger between 1 and 10: ");
    userInt = scnr.nextInt();
   
    while(userInt<0 || userInt>10){
      System.out.print("Error: Enter interger between 1 and 10:");
      userInt = scnr.nextInt();
    }

    for (a=1; a<=userInt; a++){
      for(b=1; b<=a; b++){
        System.out.print(b);
        System.out.print(" ");
      }
      System.out.println("");
    }
  }
  
}
