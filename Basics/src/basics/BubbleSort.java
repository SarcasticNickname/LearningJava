package basics;
import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
	private static final Random RND = new Random();
	
	
	static int [] bubbleSort(int [] array) {
		int swapCount = 0;
		
		for(int i = array.length - 1; i > 0; i--) {
			swapCount = 0;
			
			for(int j = 0; j < i; j++) {
				if(array[j] > array[j+1]) {
					int param = array[j+1];
					array[j+1] = array[j];
					array[j] = param;
					swapCount++;		
				}
			}
			if(swapCount == 0) break;
		}
		return array;
	}
	
	static int [] createRandomArray(int length) {
		int [] array = new int[length];
		
		for(int i = 0; i < length;i++) {
			array[i] = RND.nextInt();
		}
		return array;
	}
	

	public static void main(String[] args) {
		
		for(int i = 0; i < 1; i++) {
			int [] array = createRandomArray(20);
			int [] paramArray = Arrays.copyOf(array, array.length);
			Arrays.sort(paramArray);
			array = bubbleSort(array);
			
			System.out.println(Arrays.equals(array,paramArray));
			System.out.println(Arrays.toString(array));
			System.out.println(Arrays.toString(paramArray));
			/*
			for(int num : array) {
				System.out.print(num + " ");
			}
			*/
		}

	}

}
