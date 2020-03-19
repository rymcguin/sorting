//Ryan McGuiness
//CSE-002
import java.util.Scanner;
public class EncryptedX {
  public static void main(String[]args){
    Scanner scnr = new Scanner(System.in);
    int userInt;
    int i;
    int j;
     System.out.print("Enter and integer between 1 and 100:");
    userInt = scnr.nextInt();
    while(userInt<0 || userInt>100){
      System.out.print("Error: Enter integer between 1 and 100:");
      userInt = scnr.nextInt();
    }
    for (i=1; i<userInt; i++){
      for (j=1; j<userInt; j++){
        if (i==j || (i+j)==userInt){
          System.out.print(" ");
        }
        else{
          System.out.print("*");
        }
      }
      System.out.println();
    }
    
  }
}
