package reflection;
import java.lang.reflect.Field;
import oopEmployee.Employee;

@SuppressWarnings("rawtypes")
public class AnalyseField {

	public static void main(String[] args) {
		try {
			//Analyzed object.
			Employee empl = new Employee("Harry Hacker", 100000, 2021,7,1);
			//Object's class.
			Class cls = empl.getClass();
			//Getting field.
			Field f = cls.getDeclaredField("name");
			//Making the private!!! field accessible from another class.
			f.setAccessible(true);
			//Copying the field.
			Object v = f.get(empl);
			//Successfully got access to private field!!!!!!!
			System.out.println(v);
			//Trying out general toString Method.
			ObjectAnalyzer al = new ObjectAnalyzer();
			System.out.println(al.toString(empl));
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
