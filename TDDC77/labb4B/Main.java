package labb4B;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Write two numbers " + "\n");
		System.out.print("Number of rows: ");
		int rows = input.nextInt();
		System.out.print("Number of columns: ");
		int columns = input.nextInt();
		System.out.println("\n");

		/**
		 * Skapar objekt från klass Arithmetictable och initialiserar de olika
		 * operationsklasserna
		 */
		ArithmeticTable mT = new MultiplicationTable(rows, columns);
		ArithmeticTable dT = new DivisionTable(rows, columns);
		ArithmeticTable aT = new AdditionTable(rows, columns);
		ArithmeticTable sT = new SubtractionTable(rows, columns);

		/**
		 * Referens till print i Arithmetictable
		 * 
		 */
		mT.print();
		dT.print();
		aT.print();
		sT.print();

		input.close();

	}

}
