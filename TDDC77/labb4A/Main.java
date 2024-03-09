package labb4A;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Write two numbers ");
		System.out.println();
		System.out.print("Number of rows: ");
		int rows = input.nextInt();
		System.out.print("Number of columns: ");
		int columns = input.nextInt();
		System.out.println();
		
		/** Skapar objekt och initaliserar objektet*/
		MultiplicationTable mT = new MultiplicationTable(columns, rows); 
		/** referens till metod print i multiplikationtable */
		mT.print();  
		
		input.close();

	}

}
