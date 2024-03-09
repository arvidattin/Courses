package labb4B;

public class AdditionTable extends ArithmeticTable {

	public AdditionTable(int rows, int columns) {
		super(rows, columns, "+ |");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate(int rows, int columns) {
		double result = rows + columns;
		// TODO Auto-generated method stub
		
		return result;
	}
	
	
	@Override
	public int width(int rows, int columns) {
		
		int summa = rows + columns;
		String s = "" + summa;
		
		return s.length()+1; 
		
		
	}
	
	public String diggi() {
		
		return ".0f";
		
	}
	
}
