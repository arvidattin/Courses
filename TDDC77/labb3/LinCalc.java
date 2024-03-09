package labb3;

import java.util.Scanner;
//import lincalc.LinCalcJohn; // importerar för närvarande från Johns kod
//import se.liu.ida.tddc77.lab03.LinCalcDaniel; // Här importerar vi in paketet som vi skapat. Behövs för att köra "lex" metoden

public class LinCalc {

	public static void printArray(String[] array) {
		StringBuffer sb = new StringBuffer();// är buffer per default vilket ger 16 reserverade karaktärer att spara
		sb.append("[");
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			sb.append(", ");
		}
		// Replace the last ", " with "]"
		sb.replace(sb.length() - 2, sb.length(), "]");
		System.out.println(sb);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String expression;
		double result;

		System.out.print("Enter expression: ");
		expression = in.nextLine();

		do {
			result = evaluate(expression);
			System.out.println("Result was: " + result);
			System.out.print("Enter expression: ");

		} while (!"".equals(expression = in.nextLine()));
		in.close();
	}

	public static double calc(String[] lexedPostfix) {
		return LinCalcDRA.calc(lexedPostfix);
	}

	public static String[] toPostfix(String[] inputData) {
		// printArray(LinCalcJohn.toPostfix(inputData));
		// printArray(LinCalcDRA.toPostfix(inputData));
		return LinCalcDRA.toPostfix(inputData);

	}

	public static double evaluate(String expression) {
		String[] lexedInfix = lex(expression);
		String[] lexedPostfix = toPostfix(lexedInfix);
		return calc(lexedPostfix);
	}

	public static String[] lex(String expression) {
		// printArray(LinCalcJohn.lex(expression));
		// printArray(LinCalcDRA.lex(expression));
		return LinCalcDRA.lex(expression);

	}
}
