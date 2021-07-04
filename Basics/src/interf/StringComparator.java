package interf;

import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;
import java.util.Random;

/*
 * Создание кастомного компаратора.
 * Creating a custom String comparator.
 */
public class StringComparator {
	
	private static final Random rnd = new Random();
	
	/**
	 * Создаёт случайную строку со случайной длиной от 0 до 20.
	 * Create a random string with random length from 0 to 20.
	 * @return random string with length from 0 to 20.
	 */
	public static String createRndStr() {
		String res = "";
		for(int i = 0; i < rnd.nextInt(20); i++) {
			res += (char)((int)(Math.random()*45) + 50);
		}
		return res;
	}

	public static void main(String[] args) {
		var words = new String[15];
		for(int i = 0; i < words.length; i++) {
			words[i] = createRndStr();
		}
		
		Arrays.sort(words, new LengthComparator());
		System.out.println(Arrays.toString(words));
	}
}

/**
 * Класс реализует интерфейса Comparator<String> для создания кастомного компаратора.
 * Class implements Comparator<String> interface meant for creating custom comparator.
 * @author SarcasticNickname.
 */
class LengthComparator implements Comparator<String>{
	public int compare(String first, String second) {
		return Integer.compare(first.length(), second.length());
	}
}
