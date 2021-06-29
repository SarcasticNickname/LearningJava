package OOPEmployee;

import java.util.Objects;

public class Manager extends Employee {
	//Добавочное поле для класса-наследника.
	//An additional field for subclass. 
	private double bonus;
	
	//Конструктор с явным обращением к конструктору класса-родителя.
	//Constructor with explicit use of class-parent's contructor.
	public Manager(String name, double salary, int year, int month, int day) {
		super(name,salary,year,month,day);
		bonus = 0;
	}
	
	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(),bonus);
	}
	
	@Override
	public String toString() {
		return super.toString() + "[bonus=" + bonus + "]";
	}
	
}
