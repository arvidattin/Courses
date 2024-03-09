package labb4B;

public class SubtractionTable extends ArithmeticTable {

	public SubtractionTable(int rows, int columns) {
		super(rows, columns, "- |");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate(int rows, int columns) {
		double result = rows - columns;
		// TODO Auto-generated method stub
		return result;
	}

	public int width(int rows, int columns) {

		int summa = rows;
		String s = "" + summa;

		return s.length() + 2;
	}

	public String diggi() {

		return ".0f";

	}
}
