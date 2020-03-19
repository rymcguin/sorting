//Ryan McGuiness
//CSE-002
import java.util.Scanner;
public class PatternD {
  public static void main(String[] args){
    Scanner scnr = new Scanner(System.in);
    int userInt;
    System.out.println("Enter an interger between 1 and 10: ");
    userInt = scnr.nextInt();
    while(userInt<0 || userInt>10){
      System.out.print("Error: Enter interger between 1 and 10:");
      userInt = scnr.nextInt();
    }
    
    
    for (int a=userInt; a>=1; a--){
      for (int b=a; b>=1; b--){
        System.out.print(" ");
        System.out.print(b);
 
      }
      System.out.println("");
    }

  
  }
}
