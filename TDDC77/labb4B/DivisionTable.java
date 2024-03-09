package labb4B;

public class DivisionTable extends ArithmeticTable {

	public DivisionTable(int rows, int columns) {
		super(rows, columns, "/ |");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate(int rows, int columns) {
		double dRader = rows;
		double dKolumner = columns;
		if (columns == 0) {
			return 0;
		} else {
			return dRader / dKolumner;
		}
		// TODO Auto-generated method stub

	}

	@Override
public int width(int rows, int columns) {
		
		int summa = rows;
		String s = "" + summa;
		
		return s.length()+3; 
	}
	
public String diggi() {
	
	return ".1f";
	
}

}
