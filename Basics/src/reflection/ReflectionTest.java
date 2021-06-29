package reflection;

import java.util.*;

public class ReflectionTest {
	
	public static void main(String[] args) {
		//Полное имя класса Random.
		//Class Random's full name.
		String className = "java.util.Random";
		//
		try {
		Class rndClass = Class.forName(className);
		Random rnd = (Random)rndClass.getConstructor().newInstance();
		System.out.println(rnd.nextInt());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
