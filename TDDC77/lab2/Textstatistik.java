package lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Textstatistik {		

	public static void main(String[] args) throws IOException {
		 
	BufferedReader reader = new BufferedReader(new FileReader(args[0]));
	
	
	int mening = 0;
	int skiljetecken = 0;
	double bokstaver = 0;
	double ord = 0;
	String meningsavslut = ".?!:";
	
	
			
	while (reader.ready()) {
		String line = reader.readLine();
		/* System.out.println(line); */
		
		for(int i = 0; i < line.length(); i++) {
		
			if(Character.isAlphabetic(line.charAt(i))){
				
				bokstaver++;
				
				}	
			
			else if(Character.isSpaceChar(line.charAt(i))){
				
				ord++;
				
				}	

			 else {
				if(memberOfst(line.charAt(i))){
				skiljetecken++; 
				
				} 
				
				if(memberOf(line.charAt(i), meningsavslut)){
					mening++; 
					
					} 
					
			} 
		}
		if(line.length() > 0) {
			ord++;
		}
	}
	double medellängd = (bokstaver / ord);
	double roundOff = Math.round(medellängd * 100.0) / 100.0;
	System.out.println("Antal ord: " + ord);
	System.out.println("Antal meningar: " + mening);
	System.out.println("Antal bokstäver: " + bokstaver);
	System.out.println("Antal skiljetecken: " + skiljetecken);
	System.out.println("Medellängden på ord: " + roundOff);
	reader.close();
	}
	
	
	public static boolean memberOfst(char Skiljetecken) {
		boolean skiljetecken = false;
		
		if(Skiljetecken >= 32 || Skiljetecken <= 63) {
			skiljetecken = true;
			return skiljetecken;
		}
		else {
			return skiljetecken;
		}
	
	} 
	public static boolean memberOf(char tecken, String meningsavslut) {
		
		for (int i = 0; i < meningsavslut.length(); i++) {
			if (tecken == meningsavslut.charAt(i)) {
				return true;
		    }
			else {continue;}
			}
		
		
		return false;
	
	}
}



