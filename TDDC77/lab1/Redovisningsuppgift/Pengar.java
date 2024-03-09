import java.util.Scanner;

public class Pengar{
    public static void main(String[] args){
      double pris;
      double betalt;
      double växel;
      double växeltotalt;

      Scanner scan = new Scanner(System.in);
      System.out.println("Hur mycket kostar varan?");
      pris = scan.nextDouble();
      System.out.println("Hur mycket vill du betala?");
      betalt = scan.nextDouble();

      int[] sedel = new int[8];
      double[] valörer = {500, 100, 50, 20, 10, 5, 1, 0.50};
      växel = betalt - pris;
      växeltotalt = betalt - pris;


      for(int i = 0; i < valörer.length; i++){
        while(växel >= valörer[i]){
          sedel[i]++;
          växel = växel -valörer[i];
        }}

        System.out.println(sedel[0] + " st femhundralappar " + sedel[1] + " st hundralappar " + sedel[2] + " st femtiolappar " + sedel[3] + " st tjugolappar " + sedel[4] + " st tiokronor " + sedel[5] + " st femkronor " + sedel[6] + " st enkronor " + sedel[7] + " st femtioöringar ");

    }
}
