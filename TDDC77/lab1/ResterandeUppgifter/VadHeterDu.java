import java.util.Scanner;

public class VadHeterDu{
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.println("Vad heter du?");
      String input = scan.nextLine();
      System.out.println("Hej, " + input + "!");
}
}
