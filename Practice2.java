import java.util.Scanner;
public class Practice2{
  public static void main(String[]args){
    int i;
    int a=1;
    int userInt;
    int low = 0;
    int high = 9;
    int mid = 4;
    int index = 
      0;
    int [] arrayRand = new int [10];
    Scanner scnr = new Scanner(System.in);
    for(i = 0; i<arrayRand.length; i++){
      arrayRand[i]=a;
      System.out.print(arrayRand[i] + " ");
      ++a;
    }
    System.out.println("Enter an integer between 1-10:");
    userInt = scnr.nextInt();
    for(i=0; i<1; i++){  
    while(userInt != arrayRand[mid]){
      if(userInt > arrayRand[mid]){
        low = mid + 1;
        mid = (high + low)/2;
      }
      if(userInt < arrayRand[mid]){
        high = mid + 1;
        mid = (high + low)/2;
      }
      if(high<low){
        System.out.println("Number not in range");
        break;
      }
    ++index;
      }
    if(high<low){
        System.out.println("Number not found");
        break;
    }
    System.out.println(userInt + " found after " + index + " iterations.");
    
    System.out.println(mid);
    }
    
  } 
  }