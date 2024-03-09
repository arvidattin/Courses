package labb4D;

public class ArithmeticTable {
	private int rows;
	private int columns;
	private Operation operator;

	public ArithmeticTable(Operation op, int r, int c) {
		this.rows = r;
		this.columns = c;
		this.operator = op;
	}
	
	/** metod som printar ut de olika strängarna
	 * 
	 */
	public void print() {
		System.out.printf("%3c", operator.symbol());
		System.out.print(" |");
		System.out.print(" ");
		for (int k = 0; k <= columns; k++) {
			System.out.printf("%" + operator.width(rows, columns) + "d", k);

		}
		System.out.println();
		System.out.printf("%s", "----+");

		for (int k = 0; k <= columns; k++) {
			System.out.printf("%s", "-".repeat(operator.width(rows, columns)));
		}
		System.out.print("-");
		System.out.println();
		for (int i = 0; i <= rows; i++) {
			System.out.printf("%3d", i);

			System.out.printf("%2s", "|");
			System.out.print(" ");

			for (int k = 0; k <= columns; k++) {

				System.out.printf("%" + operator.width(rows, columns) + operator.diggi(), operator.evaluate(i, k));

			}
			System.out.println();
		}
		System.out.println("\n" + "\n");
	}
}
