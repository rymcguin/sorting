//Ryan McGuiness
//cse-002
//October 10,2018

import java.util.Scanner; 
  public class Pyramid{
  public static void main(String [] args){
    Scanner scnr = new Scanner(System.in);
    int input;
    int counter = 1;
    System.out.print("Enter a number between 1-10 : ");
    input = scnr.nextInt();
    
                     do {
                       System.out.print(counter++);
                     } while (counter <= input);
    
    
  }
}