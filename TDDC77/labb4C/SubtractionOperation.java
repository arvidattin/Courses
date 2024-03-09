package labb4C;

public class SubtractionOperation implements Operation {

	public SubtractionOperation() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public char symbol() {
		
		return '-';
	}

	@Override
	public int width(int rows, int columns) {
		int summa = rows;
		String s = "" + summa;

		return s.length() + 2;
	}

	@Override
	public double evaluate(int a, int b) {
		double result = a - b;
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public String diggi() {
		return ".0f";
	}


}
