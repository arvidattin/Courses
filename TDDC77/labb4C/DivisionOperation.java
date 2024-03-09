package labb4C;

public class DivisionOperation implements Operation {

	public DivisionOperation() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public char symbol() {
		// TODO Auto-generated method stub
		return '/';
	}

	@Override
	public int width(int rows, int columns) {
		int summa = rows;
		String s = "" + summa;
		
		return s.length()+3; 
	}

	@Override
	public double evaluate(int a, int b) {
		double dRader = a;
		double dKolumner = b;
		if (b == 0) {
			return 0;
		} else {
			return dRader / dKolumner;
		}
	}

	@Override
	public String diggi() {
		return ".1f";
	}


}
