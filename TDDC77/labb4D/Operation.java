package labb4D;

public interface Operation {
	
	/** Metod för operator i ArithmeticTable*/
	public char symbol(); 
	/** Metod för att modifiera avstånd mellan strängar i ArithmeticTable*/
	public int width(int rows, int columns);
	/** Metod för att beräkna operation i ArithmeticTable*/
	public double evaluate(int a, int b);
	/** Metod för modifiera formatering i ArithmeticTable*/
	public String diggi();

}
