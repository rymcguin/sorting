import java.util.Scanner; 
public class VenmoMenuMethods{ 
    public static void main(String [] args){ 
        Scanner input = new Scanner(System.in); 
        int choice; 
        double balance = 100; 
        double money = 0; 
        String friend; 
        String[] friendNames = new String[5]; 
        friendNames[0] = "Joe"; 
        friendNames[1] = "Bob"; 
        friendNames[2] = "Sam"; 
        double[] moneySent = new double[5]; 
        double[] moneyReceived = new double[5]; 
        int count = 3; 
        do{ 
            printMenu(); 
            choice = getInt();    
            switch (choice){ 
                case 1: getBalance(balance); 
                balance = sendMoney(balance,friendNames);
                
                break; 
                case 2: balance = requestMoney(balance,friendNames); 
                break; 
                case 3: getBalance(balance); 
                break; 
                case 4: if(count<5){ 
                            addFriend(friendNames,count); 
                            count ++; 
                        }else{ 
                            System.out.println("Your friends list is full."); 
                        } 
                         
                break; 
                case 5: friendReport(friendNames, moneySent, moneyReceived); 
                break; 
                case 6: System.out.println("Goodbye"); 
                break; 
                default: System.out.println("you entered an invalid value -- try again"); 
                break; 
            } 
        }while(choice != 6); 
    } 
 
    //print Venmo Main Menu 
    public static void printMenu(){ 
        System.out.println("Venmo Main Menu"); 
        System.out.println("1. Send Money"); 
        System.out.println("2. Request Money"); 
        System.out.println("3. Check Balance"); 
        System.out.println("4. Add Friend"); 
        System.out.println("5. Friend Report"); 
        System.out.println("6. Quit"); 
    } 
 
    //get a number and check for an integer 
    public static int getInt(){ 
        Scanner input = new Scanner(System.in); 
        while(input.hasNextInt() == false){ 
            System.out.println("You entered and invalid value -- try again"); 
            input.nextLine();//clear buffer 
        } 
        return input.nextInt(); 
    }  
 
    public static void getBalance(double balance){ 
        System.out.println("You have $" + balance + " in your account" ); 
    } 
 
    //get a number and check for a double 
    public static double getDouble(){ 
        Scanner input = new Scanner(System.in); 
        while(input.hasNextDouble() == false){ 
            System.out.println("You entered and invalid value -- try again"); 
            input.nextLine(); //clear buffer 
        }  
        return input.nextDouble(); 
    } 
 
    //driver method for sendMondy 
    public static double sendMoney(double balance,String[] friendNames){ 
        double money = 0; 
        System.out.println("How much money do you want to send?"); 
        money = getDouble();//get and check user input for a double 
        balance = checkMoney(money,balance,friendNames); //check valid amount no negative and if enough money is in balance to send money  
        return balance; 
    } 
 
    //method prints friend and money sent to friend 
    public static boolean getFriend(double money,String[] friendNames){ 
        Scanner input = new Scanner(System.in); 
        boolean match=false;         
        System.out.print("Who do you want to send your money to?"); 
        String friend=input.nextLine(); 
        for(int i=0;i<friendNames.length;i++) 
        { 
            if(friend.equalsIgnoreCase(friendNames[i])) 
            { 
                match=true; 
                break; 
            } 
        } 
        if(match==false) 
        { 
            System.out.println("Error, not on friends list."); 
        } 
        else 
        { 
            System.out.println("You have successfully sent "+ money +" to "+ friend); 
        } 
        return match; 
    } 
 
    /*method that makes sure money entered is greater than 0,  
     * there are sufficient funds in balance, if sufficient funds the balance is changed 
     * and returned. if funds are not sufficient the user is taken back to the main menu 
     */ 
    public static double checkMoney(double money, double balance,String[] friendNames){ 
        boolean validFriend; 
        while (money <= 0){ 
            System.out.println("Invalid amount entered"); 
            money = getDouble(); 
        } 
        if (money <= balance){ 
            validFriend=getFriend(money,friendNames); 
            if(validFriend==true){ 
                balance -= money; 
            } 
        } 
        else{ 
            System.out.println("You do not have sufficient funds for this transaction."); 
        } 
        return balance; 
    } 
 
    //driver method for requestMonday 
    public static double requestMoney(double balance,String[] friendNames){ 
        System.out.println("How much money do you want to request?"); 
        double money = getDouble();  
        balance = checkRequestMoney(money,balance,friendNames); 
        return balance; 
 
    } 
 
    //gets friends information for the Request menu item and prints the amount requested from friend 
    public static boolean getFriendRequest(double money,String[] friendNames){ 
        Scanner input = new Scanner(System.in); 
        System.out.println("Who do you want to request money from?"); 
        String friend = input.nextLine();   
        boolean match=false; 
        for(int i=0;i<friendNames.length;i++) 
        { 
            if(friend.equalsIgnoreCase(friendNames[i])) 
            { 
                match=true; 
                break; 
            } 
              
        } 
        if(match==false) 
        { 
            System.out.println("Error, not on friends list."); 
        } 
        else 
        { 
            System.out.println("You are requesting $" + money + " from "+ friend); 
        } 
        return match;        
    } 
 
    //method makes sure money is greater than 0 and adds requested amount to balance and returns new balance 
    public static double checkRequestMoney(double money, double balance, String[] friendNames){ 
        while (money <= 0){ 
            System.out.println("Invalid amount entered"); 
            money = getDouble(); 
        } 
        boolean validFriend = getFriendRequest(money,friendNames); 
        if(validFriend==true) 
        { 
            balance += money; 
            System.out.println("Once confirmed, your new balance will be $" + balance); 
        } 
        return balance; 
    } 
 
    public static String addFriend(String[] friendNames, int count) 
    { 
            Scanner kb = new Scanner (System.in); 
            System.out.print("What friend would you like to add? "); 
            String newFriend = kb.nextLine(); 
            friendNames[count]=newFriend; 
            System.out.println("You successfully added "+friendNames[3]+" to your friends list!"); 
            return newFriend;        
    } 
    public static void friendReport(String friendNames[], double moneySent[], double moneyRecieved[]){
      System.out.println("Friends Name:");
      for(int i = 0; i < friendNames.length; i++){
        System.out.println(friendNames[i]);
      }
      System.out.println("Money Sent:");
      for(int i = 0; i < moneySent.length; i++){
        System.out.println(moneySent[i]);
      }
      System.out.println("Money Recieved:");
      for(int i = 0; i < moneyRecieved.length; i++){
        System.out.println(moneyRecieved[i]);
      }
     }
      
  
}               
