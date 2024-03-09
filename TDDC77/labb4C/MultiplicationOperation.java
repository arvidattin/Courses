package labb4C;

public class MultiplicationOperation implements Operation {

	public MultiplicationOperation() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public char symbol() {
		// TODO Auto-generated method stub
		return '*';
	}

	@Override
	public int width(int rows, int columns) {
		int summa = rows * columns;
		String s = "" + summa;

		return s.length()+1;
	}

	@Override
	public double evaluate(int a, int b) {
		double result = a * b;

		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public String diggi() {
		return ".0f";
	}


}
