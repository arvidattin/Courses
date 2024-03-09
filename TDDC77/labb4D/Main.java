package labb4D;

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
		
		/** Skapar ett objekt från Arithmetictable och
		 * initialiserar med "konstanterna" i enumOperation"
		 */
		ArithmeticTable table1 = new ArithmeticTable(EnumOperation.ADDITION, rows, columns);
		ArithmeticTable table2 = new ArithmeticTable(EnumOperation.SUBTRACTION, rows, columns);
		ArithmeticTable table3 = new ArithmeticTable(EnumOperation.DIVISION, rows, columns);
		ArithmeticTable table4 = new ArithmeticTable(EnumOperation.MULTIPLICATION, rows, columns); // Subtraktion
		
		/** referens till print metod i Arithmetictable
		 * 
		 */
		table1.print();
		table2.print();
		table3.print();
		table4.print();

		input.close();
	}
}
