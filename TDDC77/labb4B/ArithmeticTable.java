package labb4B;

public abstract class ArithmeticTable {
	
	private int rows;
	private int columns;
	private String operator;
	
	/**
	 * metod för att beräkna de olika operationerna
	 */
	public abstract double evaluate(int rows, int columns);
	
	/**
	 * metod för att beräkna avståndet mellan strängarna
	 */
	public abstract int width(int rows, int columns);
	
	/**
	 * 
	 * metod för formatering av sträng i de olika tables
	 */
	public abstract String diggi();

	public ArithmeticTable(int r, int c, String op) {
		
		/**
		 * Refererar till rows, columns och operator i klassen
		 */
		this.rows = r;
		this.columns = c;
		this.operator = op;
	}
	
	/**
	 * metod för att printa ut de olika operationerna
	 */
	public void print() {

		System.out.printf("%5s", operator);
		System.out.print(" ");
		for (int k = 0; k <= columns; k++) {
			System.out.printf("%" + width(rows, columns) + "d", k);

		}
		System.out.println();
		System.out.printf("%s", "----+");

		for (int k = 0; k <= columns; k++) {
			System.out.printf("%s", "-".repeat(width(rows, columns)));
		}
		System.out.print("-");
		System.out.println();
		
		for (int i = 0; i <= rows; i++) {
			System.out.printf("%3d", i);

			System.out.printf("%2s", "|");
			System.out.print(" ");

			for (int k = 0; k <= columns; k++) {

				System.out.printf("%" + width(rows, columns) + diggi(), evaluate(i, k));

			}
			System.out.println();
		}
		System.out.println("\n".repeat(3));

	}
}
