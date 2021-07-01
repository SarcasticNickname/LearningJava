package reflection;

import java.lang.reflect.Method;

public class MethodTableTest {
	
	public static double square(double x) {
		return x*x;
	}

	public static void main(String[] args) throws ReflectiveOperationException {
		Method square = MethodTableTest.class.getMethod("square", double.class);
		Method sqrt = Math.class.getMethod("sqrt", double.class);
		
		printTable(0, 100, 26, square);
		printTable(0, 100, 26, sqrt);
	}
	
	public static void printTable(double from, double to, int n, Method mtd) throws ReflectiveOperationException {
		//Printing out the method's name.
		System.out.println(mtd);
		//Calculating the step.
		double dx = (to - from)/(n-1);
		
		for(double x = from; x < to; x += dx) {
			double y = (Double) mtd.invoke(null, x);
			System.out.printf("%10.4f | %10.4f%n", x, y);
		}
	}
}
