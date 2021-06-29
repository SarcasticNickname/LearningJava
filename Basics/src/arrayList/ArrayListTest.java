package arrayList;

import oopEmployee.Employee;
import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		//ArrayList<Employee> staff2 = new ArrayList();
		//Same as above.
		var staff = new ArrayList<Employee>();
		
		//Добавление элемента.
		//Adding an element.
		staff.add(new Employee("Ikotika",100000,2021,6,29));
		
		//Убедимся в месте для 5 элементов.
		//Ensuring capacity of 5 elements for array list's internal array.
		staff.ensureCapacity(5);
		
		//May as well do this.
		//ArrayList<Employee> staff2 = new ArrayList(5);
		
		
		//Доступ к элементу array list-а.
		//Accessing an element of array list.
		Employee hary = new Employee("Harry Hacker", 90000, 2021,06,29);
		Employee empl2 = staff.get(0);
		staff.set(0, hary);
		staff.add(empl2);
		
		//Добавляем элемент в середину array list-а.
		//Adding an element in the middle of array list.
		int half = staff.size() / 2;
		var empl3 = new Employee("Jeff Bezoss", 10, 2010,06,29);
		staff.add(half, empl3);
		
		//Можно также и удалить из середины.
		//We may as well remove the middle element of array list.
		//staff.remove(half);
		
		
		//Actual length of array list(number of elements.)
		int length = staff.size();
		System.out.println("Array list's actual size: " + length);
		
		//Выводим все элементы в консоль.
		//Printing all the elements.
		System.out.println("Array list's elements:");
		for(Employee empl : staff) {
			System.out.println(empl);
		}
	}
}
