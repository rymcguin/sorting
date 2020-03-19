import java.util.Scanner;
public class ArrayOfNumbers{
  public static void main(String [] args){
    Scanner scnr = new Scanner(System.in);
    final int SIZE_ARRAY = 5;
    double [] scores = new double[SIZE_ARRAY];
    double [] scores1 = new double[SIZE_ARRAY];
       //Sharon is first grade put in and so on
    String [] names = {"Sharon", "Bill", "Mary", "Joseph", "Paul"};
    double total = 0;
    double average = 0;
    int counter = 0;
    
    for(int i = 0; i < SIZE_ARRAY; i++){
      System.out.println("Enter a score for " + names[i]);
      scores[i] = scnr.nextDouble();
      total = total +scores[i];
    }
    average = total / SIZE_ARRAY;
    // or average = total / scores.length;
    for(int i = 0; i < SIZE_ARRAY; i++){
      if(scores[i] > average){
        counter++;
      }
    }
    
    for(int index = 0; index< SIZE_ARRAY; index++){
      System.out.println(names[index] + ":" + scores[index]);
    }
    for(int i = 0; i < SIZE_ARRAY; i++){
      scores[i] = scores[5] + scores[6];
      
    }
 
    
    System.out.println("The average scores is: " + average);
    System.out.println("Number of scores above average is: " + counter);
    //how to copy an arry from one array to another
    for(int index = 0; index < scores.length; index++){
      scores1[index] = scores[index];
    }
 } 
}