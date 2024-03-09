package labb4C;

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
		 * Skapar objekt genom klassernas constructers som
		 * implementerar interfacet Operation
		 */
		Operation multiplikation = new MultiplicationOperation();
		Operation subtraction = new SubtractionOperation();
		Operation division = new DivisionOperation();
		Operation addition = new AdditionOperation();
		/**
		 * Skapar objekt från klassen Arithmetictable och 
		 * initialiserar
		 */
		ArithmeticTable add = new ArithmeticTable(addition, rows, columns);
		ArithmeticTable div = new ArithmeticTable(division, rows, columns);
		ArithmeticTable multi = new ArithmeticTable(multiplikation, rows, columns);
		ArithmeticTable subtr = new ArithmeticTable(subtraction, rows, columns); 
		
		/**
		 * referens till print i Aritmetictable
		 */
		add.print();
		div.print(); 
		multi.print();
		subtr.print();

		input.close();

	}

}
