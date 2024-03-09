package labb5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

static String directory = "";
	
	public static void main(String[] args) throws IOException {
		
		/** constructs an object in Dictionary*/
		Dictionary​ dicky = new Dictionary​();
		/** construct and initialize an object in WordQuiz */
		WordQuiz wordQuiz = new WordQuiz(dicky);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Vilken textfil vill du använda?");
		System.out.println("Vänligen skriv in ditt directory till din textfil");
		System.out.println("");
		Main.directory = scan.nextLine();
		
		
		File file = new File(directory);
		System.out.println("");
		
		/** Läser filen*/
		InputStream inStream = new FileInputStream(file);
		/** referens till load metoden. initialiserar texten från filen*/
		dicky.load(inStream);
		wordQuiz.showMenu();
		
		inStream.close();

	    	}
	
		public static String Directory() {
			
			return directory;
			
			
			
			
		}


	}



