import java.util.concurrent.TimeUnit;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		String ciphertext = "VIEOEGMOCIGOHHJGBALOTMRJBHUMPXRJKQAMMBZAZKLMROROMQRAAUMNFWUGKXRNGKKUCTXKXJLXGNXAFWQCHLBIAJLJVVQSHLVBVSXQZBUIKSGBBUEUELFZNXPKNXXZLTYEMBVIIGBFRJYKUIFSFGGXUWAUMZFZTKMNYIGNXVZOTKLNSWBQBMZVGNXCEBRXGYK";
		String plaintext = "CONGRATULATIONSYOUSUCEEDINDECRYPTINGTHISMESSAGEITWASNOTTOOHARDAFTERALLKEEPUPTHEGOODWORKANDSPENDMORETIMEWITHCRYPTOOLANDSTUDYCAREFULLYTHEAVAILABLEBOOKSANDDONOTFORGETTHATHEBIGGESTBOOKISINTHEINTERNET";
		start(ciphertext ,plaintext);
	}
	
	public static void start(String ciphertext, String plaintext) {
		System.out.println("-------------------\n");

		long startTime = System.currentTimeMillis();

		Vigenere bf = new Vigenere(ciphertext, plaintext);
		bf.Decode();


		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("-------------------\nElapsed time od Decoding in milliseconds: " + totalTime);
		System.out.println("-------------------\nElapsed time od Decoding in minutes: " + TimeUnit.MILLISECONDS.toMinutes(totalTime));

	}

}
