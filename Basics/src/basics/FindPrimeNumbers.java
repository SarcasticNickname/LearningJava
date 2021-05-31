package basics;
import java.util.*;

public class FindPrimeNumbers {
	
	static Integer[] findPrimeNumbers( Integer right) {
		boolean [] isPrime = new boolean [right];
		Arrays.fill(isPrime,true);
		
		for(int i = 2; i*i < right; i++) {
			if(isPrime[i] == true) {
				for(int j = i*i; j < right; j += i) {
					isPrime[j] = false;
				}
			}
		}
	
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for(int i = 2; i < right; i++) {
			if(isPrime[i] == true) primes.add(i);
		}
		
		return primes.toArray(new Integer[primes.size()]);
	}
	

	public static void main(String[] args) {
		Integer [] primes = findPrimeNumbers(200);
		System.out.println(Arrays.toString(primes));
	}

}
