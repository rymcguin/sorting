//Ryan McGuiness
import java.util.Random;

public class Methods {
  public static void main(String[] args) {

   String subjectOfSentence = sentenceMethod();
   
    for (int i = 0; i < 10; i++) {
      if(i < 9){
        System.out.println(generateSentenceWithSubject(subjectOfSentence));
      }else{
      System.out.println("Finally the " + subjectOfSentence + verbMethod());
      }
    
    }
  }

  public static String adjectiveMethod() {
    Random randomNum = new Random();
    int random = randomNum.nextInt(10);
    String adj;
    switch (random) {
      case 1:
        adj = "fancy ";
        break;
      case 2:
        adj = "powerful ";
        break;
      case 3:
        adj = "grumpy ";
        break;
      case 4:
        adj = "famous ";
        break;
      case 5:
        adj = "drab ";
        break;
      case 6:
        adj = "adorable ";
        break;
      case 7:
        adj = "ugliest ";
        break;
      case 8:
        adj = "clever ";
        break;
      case 9:
        adj = "nervous ";
        break;
      default:
        adj = "quick brown ";
    }
    return adj;
  }
  
  // public String noun(String subject) {
  //   // code here
  //   return number;
  // }

  public static String nounMethod() {
    Random randomNumberGenerator = new Random();
    int random = randomNumberGenerator.nextInt(10);
    String noun;

    switch (random) {
      case 1:
        noun = "business";
        break;
      case 2:
        noun = "person";
        break;
      case 3:
        noun = "stuntman";
        break;
      case 4:
        noun = "dog";
        break;
      case 5:
        noun = "snake";
        break;
      case 6:
        noun = "driver";
        break;
      case 7:
        noun = "helicopter";
        break;
      case 8:
        noun = "room";
        break;
      case 9:
        noun = "comedian";
        break;
      default:
        noun = "fox";
    }
   return noun;
  }

  public static String verbMethod() {
    Random randomNum = new Random();
    int random = randomNum.nextInt(10);
    String verb;

    switch (random) {
      case 1:
        verb = "ran";
        break;
      case 2:
        verb = "left";
        break;
      case 3:
        verb = "began";
        break;
      case 4:
        verb = "turned";
        break;
      case 5:
        verb = "worked";
        break;
      case 6:
        verb = "spewed";
        break;
      case 7:
        verb = "put";
        break;
      case 8:
        verb = "wanted";
        break;
      case 9:
        verb = "moved";
        break;
      default:
        verb = "jumped";
    }
    return verb;
  }

  public static String objectMethod() {
    Random randomNum = new Random();
    int random = randomNum.nextInt(10);
    String obj;
    switch (random) {
      case 1:
        obj = "money";
        break;
      case 2:
        obj = "fame";
        break;
      case 3:
        obj = "sleep";
        break;
      case 4:
        obj = "time";
        break;
      case 5:
        obj = "bravery";
        break;
      case 6:
        obj = "intellegence";
        break;
      case 7:
        obj = "loyalty";
        break;
      case 8:
        obj = "talent";
        break;
      case 9:
        obj = "romance";
        break;
      default:
        obj = "energy";
    }
    return obj;
  }

  public static String sentenceMethod() {
    // Initialize Subject
    String subject = nounMethod();
    
    // Create Sentence
    String sentence = "The " + adjectiveMethod() + " " + subject + " " + verbMethod() + " the " + objectMethod();
    
    // Print out sentence
    System.out.println(sentence); 
    
    // Return subject
    return subject;
  }
  
  public static String generateSentenceWithSubject(String subject) {
    // code to print out sentence with subject
    Random randomNum = new Random();
    int random = randomNum.nextInt(2);
    String sentenceWithSubject;
    
    switch (random){
    case 1:
      sentenceWithSubject = "The " + adjectiveMethod() + "and " + adjectiveMethod()+ " " + subject + " " + verbMethod() + " " + objectMethod();
      break;
    case 2:
      sentenceWithSubject = "It " + verbMethod() + "with " + objectMethod();
      break;
    default:
      sentenceWithSubject = "This " + subject + "was " + adjectiveMethod();
      break;
    }
    
     return sentenceWithSubject;
  }
  
  
}
