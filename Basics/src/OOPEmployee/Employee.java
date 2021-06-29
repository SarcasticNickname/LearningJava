package OOPEmployee;

import java.time.*;
import java.util.Objects;

public class Employee {
	//Поля
	//Fields
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	//Конструктов
	//Constructor
	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		hireDay = LocalDate.of(year, month, day);
	}
	
	//Геттеры
	//Accessors
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public LocalDate getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent/100;
		salary += raise;
	}
	
	/**
	 * Правильно реализованный метод equals.
	 * Proper equals method.
	 */
	@Override
	public boolean equals(Object otherObj) {
		//Если ссылки указывают на один и тот же объект - то объекты равны.
		//If the references point to the same object in the heep - the objects are equal.
		if(this == otherObj) return true;
		//Если ссылка на другой объект null - то возвращаем false.
		//If the other objects reference is null then the objects cannot be equal.
		if(otherObj == null) return false;
		//Если не совпадают классы объектов, то и равенства быть не может.
		//If the classes don't match, they can't be equal.
		if(getClass() != otherObj.getClass()) return false;
		//Дальше будем проверять на равенство полей.
		//Next step is to check the field equality.
		var other = (Employee)otherObj;
		return Objects.equals(this.name, other.name) && this.salary == other.salary &&
				Objects.equals(this.hireDay, other.hireDay);
	}
	
	/**
	 * Нормальный метод хэшкод.
	 * A normal hashCode method.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name,salary,hireDay);
	}
	
	/**
	 * Метод toString в стандартном формате.
	 * toString method, classic format.
	 */
	@Override
	public String toString() {
		return getClass().getName() + 
				"[name=" + name + ",salary=" + salary + ",hireDay="+ hireDay + "]";
	}
}
