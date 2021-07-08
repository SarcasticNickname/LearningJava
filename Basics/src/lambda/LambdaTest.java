package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaTest {

	public static void main(String[] args) {
		
		var names = new String [] {"a","aaa","aa","aaaa"};
		Comparator<String> byLength = (String first, String second) -> Integer.compare(first.length(), second.length());
		Arrays.sort(names , byLength);
		System.out.println(Arrays.toString(names));
		
		var numbers = new Double [] {1.1,10.0,100.0,209.0,105.0,3005.0};
		Comparator<Double> byTenMod = (Double first, Double second) -> Double.compare(first % 10, second %10); 
		Arrays.sort(numbers, byTenMod);
		System.out.println(Arrays.toString(numbers));
		
	}

}
