package arbitrMeth;

public class ArbithMethodTest {
	
	static void printMany(String ...strings) {
		for(String word: strings) {
			System.out.println(word);
		}
	}

	public static void main(String[] args) {
		printMany("Ikotika","Sokol","CutTheCrap");
	}

}
