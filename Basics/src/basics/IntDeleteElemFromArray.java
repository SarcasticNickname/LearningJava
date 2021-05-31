package basics;

import java.util.Arrays;

public class IntDeleteElemFromArray {
	
	static int [] deleteElemFromIntArray(int[] array, int number) {
		int length = array.length;
		for(int i = 0; i < array.length; i++) {
			if(Integer.compare(array[i], number) == 0) length--;
		}
		
		int flag = 0;
		int [] numbers = new int[length];
		for(int i = 0; i < array.length; i++) {
			if(Integer.compare(array[i], number) != 0)
				numbers[flag++] = array[i];
		}
		return numbers;
	}
	
	public static void main(String[] args) {
		int [] numbers = new int [100];
		for(int i = 0; i < 100; i++) {
			numbers[i] = i;
		}
		
		numbers = deleteElemFromIntArray(numbers,99);
		System.out.println(Arrays.toString(numbers));
 
	}

}
