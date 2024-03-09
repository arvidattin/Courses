package lab2;

import java.util.Scanner;

public class AreaCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan = new Scanner(System.in);
System.out.println("Vad är basen på din triangel?");
double bas = scan.nextDouble();

System.out.println("Vad är höjden på din triangel?");
double hojd = scan.nextDouble();

double yta = ((bas * hojd) /  2);

System.out.println("Ytan är: " + yta);
	}

}
