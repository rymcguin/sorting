import java.util.Random;
public class Arrays{
  public static void main(String[] args){
    Random rand = new Random();
    int [] arrayOneHundred = new int[100];
    int [] arrayCount = new int[100];
    int i;
    
    for(i = 0; i < 100; i++){
      int rando=rand.nextInt(100);
      arrayOneHundred [i] = rando;
      arrayCount[rando]+=1;
      System.out.print(arrayOneHundred[i] + ", ");
    }
    for(i=0; i < 100; i++){
    System.out.println(i + " occurs "+ arrayCount[i]+ " times." );
    }
  }
}

