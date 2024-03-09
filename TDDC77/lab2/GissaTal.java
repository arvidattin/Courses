package lab2;

import java.util.Scanner;

public class GissaTal {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Spelare ett, mata in ett tal mellan 0-100");
		int Korrekt = scan.nextInt();
		System.out.println(Korrekt);
		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
		int AntalGissningar = 1;
		/* Gissa på ett tal */
		
		System.out.println("Spelare två, chansa på ett tal mellan 0-100");
		int Gissning = scan.nextInt();
		
		while (Gissning != Korrekt) {
			AntalGissningar++;
			if (Gissning < Korrekt ) {
				System.out.println("För lågt! Testa igen." + "\n" );
							
			}
			
			else System.out.println("För högt! Testa igen." + "\n" ); 
			
			Gissning = scan.nextInt();
			
			}
		
			System.out.println(Gissning + " är korrekt gissat!");
			System.out.println("Det tog dig: " + AntalGissningar + " försök");
		
		
	
	}

}
