package reflection;

import java.util.*;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author SarcasticNickname
 * Class for class analysis
 */
@SuppressWarnings("rawtypes")
public class AnalyseClass {
	public static void analyze(String className) throws ReflectiveOperationException {
		var in = new Scanner(System.in);
		Class cls;
		
		//Read class name from user input
		while(true) {
			try {
				cls = Class.forName(className);
				break;
			}
			catch(Exception ex) {
				System.out.println("Enter a class name(e.g. java.util.Random)");
				className = in.next();
				continue;
			}
		}
		//Get the superclass
		Class supercl = cls.getSuperclass();
		
		//Get the modifier
		String modifiers = Modifier.toString(cls.getModifiers());
		if(modifiers.length() > 0) System.out.print(modifiers + " ");
		
		System.out.print("class " + className);
		
		if(supercl != null && supercl != Object.class)
			System.out.print(" extends " + supercl.getName());
		
		System.out.print("\n{\n");
		printConstructors(cls);
		System.out.println();
		printMethods(cls);
		System.out.println();
		printFields(cls);
		System.out.println("}");
		
		
	}
	
	/**
	 * Prints all constructors of the class
	 * @param cl class
	 */
	public static void printConstructors(Class cl) {

		
		Constructor [] constructors = cl.getDeclaredConstructors();
		
		for(Constructor cnstr: constructors) {
			String name = cnstr.getName();
			System.out.print("    ");
			
			String modifiers = Modifier.toString(cnstr.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			
			System.out.print(name + "(");
			
			//Print parameter types.
			Class [] paramTypes = cnstr.getParameterTypes();
			for(int i = 0; i < paramTypes.length; i++) {
				if(i > 0) System.out.print(", ");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * Prints all methods of the class
	 * @param cl class
	 */
	public static void printMethods(Class cl) {
		Method [] methods = cl.getDeclaredMethods();
		
		for(Method mtd : methods) {
			Class retType = mtd.getReturnType();
			String name = mtd.getName();
			
			System.out.print("    ");
			
			//print modifier, return type and method name.
			String modifiers = Modifier.toString(mtd.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print(retType.getName() + " " + name + "(");
			
			//print parameter types
			Class[] parameters = mtd.getParameterTypes();
			for(int i = 0, len = parameters.length; i < len; i++) {
				if(i > 0 && i < len - 1) System.out.print(", ");
				System.out.print(parameters[i].getName());
			}
			System.out.println(");");
		}
	}

	/**
	 * Prints all fields of the class
	 * @param cl class
	 */
	public static void printFields(Class cl) {
		Field [] fields = cl.getDeclaredFields();
		
		for(Field field : fields) {
			Class type = field.getType();
			String name = field.getName();
			System.out.print("    ");
			String modifiers = Modifier.toString(field.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}
}

