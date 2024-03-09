package labb4A;

public class MultiplicationTable {
	private int rows;
	private int columns;

	public MultiplicationTable(int c, int r) { // skapar en constructer
		/** referens till rows och columns i classen */
		this.columns = c;
		this.rows = r;

	}

	public void print() {

		String str = "" + columns * rows;
		String s = "-";
		String widthD = "%" + (str.length() + 1) + "d"; // fulkodar formateringen Digit
		String widthS = "%" + (str.length() + 1) + "s"; // fulkodar formateringen String

		System.out.println("största sträng element har längden: " + widthD + " + 1");
		System.out.printf("%5s", "* |");

		for (int k = 0; k <= columns; k++) { // skriver ut antalet kolumner
			System.out.printf(widthD, k);

		}
		System.out.println();
		System.out.printf("%s", "----+");

		for (int i = 0; i < str.length(); i++) { // används för att få rätt antal "-" tecken
			s += "-";
		}

		for (int k = 0; k <= columns; k++) {// skriver ut "-" tecken

			System.out.printf(widthS, s);
		}
		System.out.println();
		for (int i = 0; i <= rows; i++) { // skriver ut tabellen
			System.out.printf("%3d", i);

			System.out.printf("%2s", "|");

			for (int k = 0; k <= columns; k++) {

				System.out.printf(widthD, i * k);

			}
			System.out.println();
		}

	}

}
