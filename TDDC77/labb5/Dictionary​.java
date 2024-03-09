package labb5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Denna klass modellerar en ordlista (Dictionary). En ordlista associerar
 * termer med betydelser. En term kan mappas till flera betydelser. Både term
 * och betydelse representeras med klassen Word.
 */

public class Dictionary​ {

//	Map<Word,Set<Word>> map;

	HashMap<Word, HashSet<Word>> dictMap = new HashMap<Word, HashSet<Word>>(); //

	/**
	 * Lägger till termen t till ordlistan med betydelsen m. Om termen redan är
	 * tillagd med angiven betydelse händer ingenting.
	 */
	public void add(Word t, Word m) {
		
		if (dictMap.containsKey(t)) { // om nyckeln finns
			if (dictMap.get(t).contains(m)) {
			//	System.out.println("dublett");

			}

			else {
				dictMap.get(t).add(m); // lägg till ord i map
			}

		} else {

			HashSet<Word> nyttSet = new HashSet<Word>();// om det är en annan nyckel, skapa ny hashset
			nyttSet.add(m);
			dictMap.put(t, nyttSet);
		}

		//  System.out.println(dictMap);
	}

	public void add(String t, String m) {
		
		Word sT = new Word(t);			// Använder vår Word constructor för att omvandla till object,
		Word sM = new Word(m);			// för att sedan lägga till objekten i vår add() metod
		add(sT, sM);
	}

	/**
	 * Returnerar en icke-null mängd med ordlistans alla termer.
	 */
	 public Set<Word> terms(){
		 
		 return dictMap.keySet(); // returnerar nycklarna som är lagrade
		
		 
		 
	 }
	 

	/**
	 * Slår upp och returnerar en mängd av betydelser till t, eller null om t inte
	 * finns i ordlistan.
	 */
	 public Set<Word> lookup(Word t){
		return dictMap.get(t);
	 }

	/**
	 * Skapar och returnerar en ny ordlista på det motsatta språket, dvs, alla
	 * betydelser blir termer och alla termer blir betydelser. T.ex. en
	 * svensk-engelsk ordlista blir efter invertering engelsk-svensk.
	 */
	public Dictionary​ inverse() {
		
		Dictionary​ inverse = new Dictionary​();
		
		for(Word key : terms()) {
			
			for(Word sweng : lookup(key)) {

				inverse.add(sweng, key);
			}			
		} 
		return inverse;
	}

	/**
	 * Läser in orden från den givna strömmen och lägger dessa i ordlistan.
	 */
	 public void load(InputStream inStream)throws IOException{
		 /** inputStreamReader läser in bytes och konverterar till karaktärer */
		 BufferedReader input = new BufferedReader(new InputStreamReader(inStream)); 
		 while(input.ready()) {
			 String line = input.readLine();
			 String[] sweng = line.split("=");
			 add(sweng[0],sweng[1]);
		 }
		 
	 }

	/**
	 * Lagrar ordlistan på den givna strömmen.
	 */
	 
	public void save() throws IOException {
		
	//	String plats = "/home/arvat549/eclipse-workspace/lab5/src/labb5/glosor.txt";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Var vänlig skriv det svenska ordet:");
		String firstWord = scan.nextLine();
		System.out.println("Och skriv dess översättning:");
		String secondWord = scan.nextLine();
		
		File file =new File(Main.Directory());
		FileWriter fw = new FileWriter(file,true);
  	  	BufferedWriter bw = new BufferedWriter(fw);
  	  	PrintWriter pw = new PrintWriter(bw);
		
		
		try {
		//	OutputStream OutputStream1 = new FileOutputStream("/home/arvat549/eclipse-workspace/lab5/src/labb5/glosor.txt");
		//	Writer outputStreamWriter = new OutputStreamWriter(OutputStream1);

		  	pw.write("\n" + firstWord + "=" + secondWord);

		
			//outputStreamWriter.write(firstWord + '=' + secondWord);
			System.out.println("Vill du lägga till fler ord? (Ja/Nej)");
			String val = scan.nextLine();
			String alternativ = "Ja";


			

			while (val.equals(alternativ)) {
				System.out.println("Var vänlig skriv det svenska ordet:");
				String moreWord = scan.nextLine();
				System.out.println("Och skriv dess översättning:");
				String evenMoreWord = scan.nextLine();

				pw.write("\n" + moreWord + "=" + evenMoreWord);
				moreWord = "";
				evenMoreWord = "";
				System.out.println("Orden är tillagda.");
				System.out.println("Vill du lägga till fler ord? (Ja/Nej)");
				val = scan.nextLine();
				
				
			}
			
			System.out.println("Orden är tillagda.");
			pw.close();
			 
			
		} catch (Exception e) {
			
			e.getMessage();
		}
		scan.close();
		
		 	}
		 
		 

	/*
	 * Tänk på att om ordlistan ännu inte har några ord inlagda så ska ändå inte
	 * metoden ​terms returnera null utan en tom mängd/array. Skillnaden är bl.a.
	 * att en tom mängd ändå är en mängd som man kan använda t.ex. metoden
	 * ​isEmpty​. Ett null-värde kan man inte göra någonting speciellt med. Internt
	 * bör ordlistan använda sig av en ​Map​-struktur (se java.util​). Lämpligtvis
	 * mappar vi ord mot mängder av betydelser. Alltså ​Map<Word, Set<Word>>​. De
	 * konkreta typer som kommer på fråga är alltså: HashMap och HashSet. Se vidare
	 * föreläsningarna. Ni ska på ett översiktligt sätt förstå hur dessa fungerar
	 * och vilka krav som ställs på nycklarna. (Detaljer kommer i ​TDDC91​.) Ni ska
	 * också skriva metoder för att spara och ladda ord till och från en ström. Här
	 * får ni inte använda er av Serialization, vilket är Javas egna API för att
	 * skriva och läsa datastrukturer. Tanken är att ni ska hitta på ett eget sätt
	 * för detta. När programmet startas ska det fråga efter namnet på filen där
	 * ordlistan är lagrad.
	 */
	 }
