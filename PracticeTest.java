import java.util.Scanner;
import java.util.Random;

public class PracticeTest{
 public static void main(String[] args) {
  final int numElements = 15;
  int[] finalGrade = new int[numElements];
  int i;
  int userInput;
  Scanner scnr = new Scanner(System.in);
  System.out.println("Enter " + numElements + " ascending ints for final grades in CSE2: ");
//provides boundaries for integers entered
  for (i = 0; i < finalGrade.length; ++i){
   if (!scnr.hasNextInt()){
    scnr.next();
    System.out.println("Error: Enter an integer");
    --i;
    continue;
   }
   finalGrade[i] = scnr.nextInt();
   if (finalGrade[i] > 100 || finalGrade[i] < 0){
    System.out.println("Error: Integer must be between 0-100");
    --i;
    continue;
   }
   if (i != 0) {
    if (finalGrade[i] < finalGrade[i - 1]){
     System.out.println("Error: Integers must be in ascending order");
     --i;
     continue;
    }
   }
  }
  
  for (i = 0; i < finalGrade.length; i++) {
   System.out.print(finalGrade[i] + " ");
  }
  System.out.println();
  System.out.println("Enter a grade to search for: ");
  userInput = scnr.nextInt();
  
  binarySearch(finalGrade, userInput);
  int[] scrambledGrades = randomScramble(finalGrade);
  System.out.println("Scrambled: ");
 for(i = 0; i < scrambledGrades.length; i++) {
  System.out.print(scrambledGrades[i] + " ");
 }
 System.out.println(" ");
 System.out.print("Enter a grade to search for: ");
 userInput = scnr.nextInt();
  linearSearch(scrambledGrades, userInput);
 }

 public static void linearSearch(int[] finalGrade, int userInput) {
  int i;
  for (i = 0; i < finalGrade.length; i++) {
   if (finalGrade[i] == userInput) {
    System.out.println("Linear Search: " + userInput + " found after " + i + " iterations");
    break;
   }
   if (i == finalGrade.length - 1) {
    System.out.println("Linear Search: " + userInput + " not found after " + i + " iterations");
   }
  }
  System.out.println("");
 }

 public static void binarySearch(int[] finalGrade, int userInput) {
  boolean boolin = false;
  int low = 0;
  int high = finalGrade.length;
  int mid;
  int index = 0;
  while(low < high){
    mid = (high + low)/2;
    ++index;
    if(finalGrade[mid] == userInput){
      boolin = true;
      break;
    }
    if(finalGrade[mid] < userInput){
      low = mid + 1;
    }
    if(finalGrade[mid] > userInput){
      high = mid - 1;
    }
  }
  if(boolin == true){
    System.out.println("Binary Search: " + userInput + " was found in the list with " + index + " iterations");
  }else{
     System.out.println("Binary Search: Grade does not exist");
  }
 }

 public static int[] randomScramble(int[] finalGrade) {
  int[] scrambledGrades = new int[finalGrade.length];
  int i;
  Random rand = new Random();
  for (i = 0; i < finalGrade.length; i++) {
   scrambledGrades[i] = finalGrade[i];
  }
  for (i = 0; i < scrambledGrades.length; i++) {
   int randomIndex = rand.nextInt(scrambledGrades.length);
   int temp = scrambledGrades[i];
   scrambledGrades[i] = scrambledGrades[randomIndex];
   scrambledGrades[randomIndex] = temp;
  }
  
  return scrambledGrades;
 }

}


