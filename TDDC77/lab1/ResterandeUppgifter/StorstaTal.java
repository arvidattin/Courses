import java.util.Scanner;

public class StorstaTal{
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.println("Skriv ett heltal");
      int input = scan.nextInt();
      System.out.println("Skriv ett till heltal");
      int input2 = scan.nextInt();
      if (input > input2){
        System.out.println(input + " är störst");
      }else{
        System.out.println(input2 + " är störst");
      }
}
}
