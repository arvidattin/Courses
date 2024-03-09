import java.util.Scanner;

public class HurGammal{
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.println("Hur gammal är du?");
      String input = scan.nextLine();
      System.out.println("Du är " + input + " år gammal");
}
}
