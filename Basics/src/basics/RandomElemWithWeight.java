package basics;

import java.util.Random;

public class RandomElemWithWeight {
	
	static final Random rnd = new Random();
	
	int [] array;

	public RandomElemWithWeight(int[] numbers, int[] weights) {
		int length = 0;
		for(int i = 0; i < weights.length; i++) {
			length += weights[i];
		}
		array = new int[length];
		
		int flag = 0;
		for(int i = 0; i < weights.length; i++) {
			for(int j = 0; j < weights[i]; j++) {
				array[flag++] = numbers[i];
			}
		}
	}
	
	public int getRandomNumber() {
		int index = rnd.nextInt(array.length);
		return array[index];
	}
	
	
	public static void main(String[] args) {
		RandomElemWithWeight rnd = new RandomElemWithWeight(new int [] {1,2,3}, new int [] {1,4,10});
		for(int i = 0; i < 30; i++) {
			System.out.print(rnd.getRandomNumber() + " ");
		}
	}

}
