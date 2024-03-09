package labb4D;

/**
 * 
 * enum där vi utför de olika operationerna och formatering av strängar
 * används i Arithmetictable
 */
public enum EnumOperation implements Operation {

	ADDITION('+') {
		@Override
		public int width(int rows, int columns) {
			int summa = rows + columns;
			String s = "" + summa;

			return s.length() + 1;
		}

		@Override
		public double evaluate(int a, int b) {
			return a + b;
		}

		public String diggi() {

			return ".0f";
		}
	},

	SUBTRACTION('-') {
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
	},

	DIVISION('/') {
		@Override
		public int width(int rows, int columns) {
			int summa = rows;
			String s = "" + summa;

			return s.length() + 3;
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
	},

	MULTIPLICATION('*') {
		@Override
		public int width(int rows, int columns) {
			int summa = rows * columns;
			String s = "" + summa;

			return s.length() + 1;
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
	};

	private final char symbol;

	/** Enum constructer */
	private EnumOperation(char symbol) {
		this.symbol = symbol;
	}

	@Override
	public char symbol() {
		return symbol;
	}

}
