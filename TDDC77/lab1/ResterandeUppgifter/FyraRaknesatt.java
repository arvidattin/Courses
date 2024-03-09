import java.util.Scanner;

public class FyraRaknesatt{
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.println("Skriv ett tal");
      double input = scan.nextDouble();
      System.out.println("Skriv ett till tal");
      double input2 = scan.nextDouble();
      System.out.println(input + " + " + input2 + " = " + (input + input2));
      System.out.println(input + " - " + input2 + " = " + (input - input2));
      System.out.println(input + " * " + input2 + " = " + (input * input2));
      System.out.println(input + " / " + input2 + " = " + (input / input2));
}
}
