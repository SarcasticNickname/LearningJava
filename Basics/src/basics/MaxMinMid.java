package basics;
import java.util.Random;

public class MaxMinMid {
	static final Random RND = new Random();
	
	static int [] createRandomArray(int length) {
		int [] array = new int[length];
		
		for(int i = 0; i < length;i++) {
			array[i] = RND.nextInt();
		}
		return array;
	}
	
	static void findExtremums(int [] array) {
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int length = array.length;
		double average = 0;
		
		for(int num : array) {
			if(num < min) min = num;
			if(num > max) max = num;
			average += (double)(num/length);
		}
		
		System.out.println("Array's minimal element: " + min + "\n" +
				"Array's maximal element: " + max + "\n" + 
				"Average: " + average);
	}
	
	public static void main(String[] args) {
		
		// intArray.length
		final int N = 20;
		
		int [] array = createRandomArray(N);
		
		findExtremums(array);
	}

}
