import java.util.*;
import java.math.*;
public class Interview_test {

    /**
     * @param args the command line arguments
     */
//brings in users tex
    public static void sampleText(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a String:");
        String out=scan.nextLine();
        System.out.print("You entered:"+out);

    }
//prints out menu 
    public static void printMenu(){
        System.out.println("MENU");
        System.out.println("c - Number of non-whitespace characters");
        System.out.println("w - Number of words");
        System.out.println("f - Find text");
        System.out.println("r - Replace all !'s");
        System.out.println("s - Shorten spaces");
        System.out.println("q - Quit");
        System.out.println("Choose an option: ");

    }
 // replaces all exclamation points with a "." instead
    private static String replaceExclamation(String text) {
       String newString = text.replaceAll("!", ".");
       return newString;
   }
//Shortens all spaces in user input to one space
    public static String shortenSpace(String str){
        String newString=str.trim().replaceAll(" +", " ");
        return newString;
    }
//returns number of characters in the users input 
    public static int getNumOfNonWSCharacters(String str){
        int counter=0;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)!=' '){
                counter++;
            } 
        }
        return counter;
    }
//returns number of words in the users input
    public static int getNumOfWords(String str){
        int counter=1;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==' '){
                counter++;
            } 
        }
        return counter;
    }
 //Searches for word in the text and returns number of times in text
     private static int findText(String text, String find) {
       int counter = 0;
       int i = 0;

       while ((i = text.indexOf(find)) != -1) {
           text = text.substring(i + find.length());
           counter += 1;
       }

       return counter;
   }

//Calls all previous methods when prompted by user
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        //
        System.out.print("Enter sample text: ");
        String txt=scan.nextLine();
        printMenu();
        String opt=scan.nextLine();
        while(opt.charAt(0)!='q'){
        switch (opt.charAt(0)) {
           case 'q':
               System.exit(0);

           case 'c': 
               int ans = getNumOfNonWSCharacters(txt);
               System.out.println("Number of non-whitespace characters: " + ans);
               System.out.println("Choose an option: ");
               opt=scan.nextLine();

               break;

           case 'w':  
               int wordsCount = getNumOfWords(txt);
               System.out.println("Number of words: " + wordsCount);
               System.out.println("Choose an option: ");
               opt=scan.nextLine();

               break;

           case 'f':   
               System.out.println("Enter a word or phrase to be found: ");
               String findString = scan.nextLine();
               int findCount = findText(txt, findString);
               System.out.println("\"" + findString+ "\" instances: " + findCount);
               System.out.println("Choose an option: ");
               opt=scan.nextLine();

               break;

           case 'r':   
               String newstring = replaceExclamation(txt);
               System.out.println("Edited text: " + newstring);
               System.out.println("Choose an option: ");
               opt=scan.nextLine();

               break;
               
           case 's':
               String string = shortenSpace(txt);
               System.out.println("Edited text:" + string);
               System.out.println("Choose an option: ");
               opt=scan.nextLine();
               break;

           default: 
               System.out.println("Invalid option");
               printMenu();
               opt=scan.nextLine();
    }
    }
    }
}