package labb5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordQuiz {

	private Scanner input = new Scanner(System.in);
	private Dictionary​ dicky;


	public WordQuiz(Dictionary​ dictionary) {
		// Er kod ska in här...
		this.dicky = dictionary;
	}

	public void showMenu() throws IOException {

		System.out.println("Vänligen välj ett alternativ:");
		System.out.println("______________________________");
		System.out.println();
		System.out.println("1. Glosförhör - (Svenska till Engelska)");
		System.out.println("2. Glosförhör - (Engelska till Svenska)");
		System.out.println("3. Lägg till ord");
		System.out.println();
		System.out.println("______________________________");

		Scanner alternativ = new Scanner(System.in);
		int val = alternativ.nextInt();

		switch (val) {

		case 1:
			System.out.println("Du valde 1");
			runQuiz();

			break;
			

		case 2:
			System.out.println("Du valde 2");
			dicky = dicky.inverse();				// Ersätter dicky dictionary med dicky inverse
			runQuiz();

			break;
			
		case 3:
			System.out.println("Du valde 3");
			dicky.save();
			break;

		}
	}


	public void runQuiz() {

		HashSet<Word> OrdattTabort = new HashSet<Word>();					// Vi skapar ett nytt istället för 
		ArrayList<Word> OrdLista = new ArrayList<Word>(dicky.terms());		// att ta bort från ordlista, förklaring längre ner
		int AntalRätt = 0;
		int AntalFel = 0;
		int AntalFörsök = 0;

		
		while (!(OrdLista.isEmpty())) {					

			Scanner scan = new Scanner(System.in);
			
			
			for (Word t : OrdLista) {									// itererar genom varje nyckel i ordlistan
				
				

				Set<Word> betydelser = dicky.lookup(t);		// Vi gjorde om till ett set istället för att jämföra
															// keys, för vi fick alltid false ifall vi gjorde det
				System.out.println("Ordet är: " + t); 		
				System.out.println("Svar: ");
				
				Word svar = new Word(scan.nextLine());
				

				if (betydelser.contains(svar)) {

					System.out.println("Rätt");
					

					OrdattTabort.add(t);			// lägger till i nytt Set istället för att ta bort från
													// ordlista eftersom det kraschar ifall man tar bort medan
					AntalRätt++;					// den itererar
					
				} else {

					System.out.println("Fel");
					AntalFel++;
				}

			}
			
			OrdLista.removeAll(OrdattTabort);		// tar bort från Ordlista efter att den har itererat
			AntalFörsök++;




			
			if(AntalFel > 0) {						// Har man inte alla rätt har man ett fel, och man ska fortsätta testas
				System.out.println("Du hade " + AntalRätt + " rätt" + " och " + AntalFel + " fel " );
				System.out.println("Vet du vad? Testa igen.");
				AntalFel = 0;
				AntalRätt = 0;
			}
			
			else {
				System.out.println("wow du klarade det");
				System.out.println("Det har tagit dig " + AntalFörsök + " försök");
				
			}
		
			
		}
		
	}
}
