package lambda;

import java.util.function.IntConsumer;

public class ProcessingLambdaExpr {
	
	/**
	 * Метод использует встроенный интерфейс как ссылку на метод, чтобы выполнить метод n раз.
	 * Method uses inbuilt interface as a method reference to run a method n times.
	 * @param n целое число раз. Integer number of times.
	 * @param action метод, который требуется выполнить. Method to execute n times.
	 */
	static void repeat(int n, Runnable action) {
		for(int i = 0; i < n; i++) action.run();
	}
	
	/**
	 * Метод использует встроенный функциональный интерфейс как ссылку на метод.
	 * Method uses inbuilt interface as a method reference.
	 * @param n times the method is executed. 
	 * @param action The method.
	 */
	static void repeat2(int n, IntConsumer action) {
		for(int i = 0; i < n; i++) action.accept(i);
	}

	public static void main(String[] args) {
		repeat(10, () -> System.out.println("Java - это круто. Java is cool."));
		repeat2(10, (int i) -> System.out.printf("Java - это круто %d раз. Java is cool %d time \n",i,i));
	}

}
