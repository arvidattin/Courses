package labb3;

import java.util.Stack;
import java.lang.Character;

public class LinCalcDRA {

	static double evaluatePostfix(char eval, double value2, double value1) { // metod för beräkning av postfix

		double calculate = 0;

		switch (eval) {

		case '-':
			calculate = value1 - value2;
			return calculate;

		case '+':
			calculate = value1 + value2;
			return calculate;

		case '*':
			calculate = value1 * value2;
			return calculate;

		case '/':
			calculate = value1 / value2;
			return calculate;

		case '~':
			if (value2 == 0) {// om stacken endast innehåller en operand och vi får in ett tilde --> värdet i
								// stacken är negativt
				calculate = -1 * value1;
				return calculate;
			} else {
				calculate = -1 * value2;
				return calculate;
			}
		}
		return calculate;
	}

	static int opValue(String operatorValue) {// metod för att kontrollera prioriteringsordning för operator och tilde

		switch (operatorValue) {
		case "+":
		case "-":

			return 1;

		case "*":
		case "/":
			return 2;

		case "~":
			return 3;

		case "(":
		case ")":
			return -1;

		}
		return -1;

	}

	static boolean doesOpExists(char operatorExists) // En metod som används för att kontrollera om en operator
														// existerar
	{
		switch (operatorExists) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '(':
		case ')':
		case '~':
			return true;

		}
		return false;
	}

	public static String[] lex(String expression) {

		Stack<String> stackLex = new Stack<String>();

		String operand = "";
		String operator = "";
		char a;
		int storlek = expression.length();

		for (int i = 0; i < storlek; i++) {

			a = expression.charAt(i);

			if (Character.isLetterOrDigit(a) || (a == '.' || a == ',')) {

				if (a == ',') {
					a = '.';
				}
				operand += a;

				if ((operand.length() == storlek)) { // Indata är endast en operand --> pusha till stack

					stackLex.push(operand);
				} else if ((i == storlek - 1) && (stackLex.peek() == operator)) { // Sista indata i sträng är operand &
																					// föregående i stack är operator
																					// --> pusha operand

					stackLex.push(operand);
				}
			} else if ((operand != "" && doesOpExists(a) == true)) { // här vet vi att det inte är ett negativt tal -->
																		// då är det en operator --> pusha

				operator = Character.toString(a);
				stackLex.push(operand);
				stackLex.push(operator);
				operand = "";
			} else if (operand == "" && doesOpExists(a) == true) { // Mer än en operator på rad --> fortsätta pusha
																	// operator till påstående falskt
				if (a == '-') {// om två efterföljande minus --> pusha det andra minus som tilde
					stackLex.push("~");
					operator = "~";
				} else {
					operator = Character.toString(a);
					stackLex.push(operator);
				}

			}

		} // loop slutar här

		return stackLex.toArray(new String[0]);
	} // lex metod slutar här

	public static String[] toPostfix(String[] inputData) { // metod som gör infix till postfix

		Stack<String> postfixStack = new Stack<String>();
		Stack<String> operatorStack = new Stack<String>();

		String sträng = "";
		char c;

		for (int i = 0; i < inputData.length; i++) {
			sträng = inputData[i];
			c = sträng.charAt(0);

			if (Character.isLetterOrDigit(c)) {

				postfixStack.push(sträng);
			}
			if (opValue(sträng) > 0) {// om en av operatorerna '+', '-', '*', '/' är sant

				while (!operatorStack.isEmpty() && opValue(operatorStack.peek()) >= opValue(sträng)) {// Järnvägsalgoritmen

					postfixStack.push(operatorStack.pop()); // Villkor sant --> pushar varje operator till postfixStack
				}
				operatorStack.push(sträng);// när stack är tömd --> pusha den nya operatorn till stacken
			}

			else if (c == ')') {

				while (opValue(operatorStack.peek()) != -1) {

					postfixStack.push(operatorStack.pop()); // sålänge vi inte stöter på en '(' --> pusha alla
															// operatorer till postfixStack
				}
				operatorStack.pop(); // När '(' upptäcks --> ta bort '(' ur operatorStacken

			} else if (c == '(') {

				operatorStack.push(sträng);
			}

		} // loop slutar här

		while (!operatorStack.isEmpty()) {// Om något skulle ligga kvar i operatorStacken efter vi itererat genom
											// for-loop --> pusha allt till postfixStack

			postfixStack.push(operatorStack.pop());
		}

		return postfixStack.toArray(new String[0]);
	}

	// to postfix metod slutar här

	public static double calc(String[] lexedPostfix) { // Metod där du kan kommentera ut beroende på vilken calc metod
														// man vill köra

		 //return calcArvid(lexedPostfix);

		 return calcDaniel(lexedPostfix);

		// return calcRasmus(lexedPostfix);

	}

	public static double calcArvid(String[] lexedPostfix) { // Arvids calc
		Stack<Double> Evalstack = new Stack<Double>(); // ny tom stack
		double d = 0;
		double värde1 = 0;
		double värde2 = 0;

		for (String s : lexedPostfix) { // loopar genom alla element i stringarrayen
			char c = s.charAt(0); // omvandlar string på index 0 till char

			if (Character.isDigit(c)) { // kollar om char är en siffra
				d = Double.parseDouble(s); // om det är en siffra gör den om den till en double
				Evalstack.push(d); // pushar till stacken om det är en siffra

			} else {

				switch (c) { // switch case, som sätter upp alla fall om det inte är en siffra
				case '+':
					värde1 = Evalstack.pop();
					värde2 = Evalstack.pop();
					Evalstack.push(värde2 + värde1); // poppar de två första värdena i stacken, och plussar dessa ihop
														// om det dyker upp ett "+"
					break;
				case '-':
					värde1 = Evalstack.pop();
					värde2 = Evalstack.pop();
					Evalstack.push(värde2 - värde1); // poppar de två första värdena i stacken, och subtraherar dessa om
														// det dyker upp ett "-"
					break;
				case '*':
					värde1 = Evalstack.pop();
					värde2 = Evalstack.pop();
					Evalstack.push(värde2 * värde1); // poppar de två första värdena i stacken, och subtraherar dessa om
														// det dyker upp ett "*"
					break;
				case '~':
					värde1 = Evalstack.pop();
					Evalstack.push(värde1 * -1); // eftersom vi hade tilde istället för unärt minus, var jag tvungen att
													// lägga till en sats för det, -1 gör om den till positiv
					break;
				case '/':
					värde1 = Evalstack.pop();
					värde2 = Evalstack.pop();
					Evalstack.push(värde2 / värde1); /// poppar de två första värdena i stacken, och dividerar dessa om
														/// det dyker upp ett "/"
					break;
				}
			}
		}
		return Evalstack.pop(); // returnerar stacken
	}

	public static double calcDaniel(String[] lexedPostfix) { // Daniels metods

		Stack<Double> operandStack = new Stack<Double>();
		double operand;
		double eval = 0;
		char c;

		for (String sträng : lexedPostfix) {

			c = sträng.charAt(0);

			if (Character.isLetterOrDigit(c)) {
				operand = Double.parseDouble(sträng);
				operandStack.push(operand);

			} else if (doesOpExists(c) == true) {

				if (operandStack.size() == 1) {// Om endast ett element i stack så ska endast denna beräknas.
												// (möjligt tilde som operator här)
					eval = evaluatePostfix(c, 0, operandStack.pop());
					operandStack.push(eval);

				} else if (c == '~' && operandStack.size() == 2) {// Om två element i stack och tilde upptäcks så
																	// sätts översta element till negativt
					eval = evaluatePostfix(c, operandStack.pop(), 0);
					operandStack.push(eval);

				} else {
					eval = evaluatePostfix(c, operandStack.pop(), operandStack.pop());// Om två element i stack så
																						// beräkna uttrycket
					operandStack.push(eval);

				}
			}

		}
		if (!operandStack.isEmpty()) { // Om endast en operand skrivs in så töm stacken och ingen operator upptäckts
			eval = operandStack.pop();
		}

		return eval;

	}

	public static double calcRasmus(String[] lexedPostfix) { // Rasmus metod

		double d = 0;
		Stack<Double> operandStack = new Stack<Double>();
		double p = 0;
		double q = 0;

		for (String s : lexedPostfix) { // Loopar genom uttrycket
			char a = s.charAt(0); // Kollar första symbolen för alla strängar i uttrycket
			if (Character.isLetterOrDigit(a)) { // Om symbol är nummer
				d = Double.parseDouble(s); // Gör om sträng till double
				operandStack.push(d); // pusha talet till stack

			} else if (a == '+') { // Alla dessa kollar om det är en operator, om det är en operator, poppa de två
									// talen i stacken om
				p = operandStack.pop(); // och utför räkneopertionen. Pusha sedan till stacken igen
				q = operandStack.pop();
				operandStack.push(p + q);
			} else if (a == '-') {
				p = operandStack.pop();
				q = operandStack.pop();
				operandStack.push(q - p);
			} else if (a == '*') {
				p = operandStack.pop();
				q = operandStack.pop();
				operandStack.push(p * q);

			} else if (a == '/') {
				p = operandStack.pop();
				q = operandStack.pop();
				operandStack.push(q / p);
			} else if (a == '~') {
				p = operandStack.pop();
				operandStack.push(p * -1);
			}
		}
		return operandStack.pop();
	}
}
