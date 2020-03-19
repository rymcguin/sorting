public class SnippetB{
public static void main(String[] args){
  methodB(5);
}
public static void methodB(int x){
  for(int i = 0; i < x; i++){
    for ( int j = 0; j < 1; j++){
      System.out.print("#");
    }
    if(i < 2){
      continue;
    }
    System.out.println();
  }
}
}