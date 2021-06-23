package basics;

class A{
	private Integer name;
	
	public void setName(Integer name){
		this.name = name;
	}
	
	public Integer getName() {
		return this.name;
	}
}

public class Test {
	public static void main(String [] args) {
	A a = new A();
	a.setName(5);
	Integer name = a.getName();
	name = 10;
	
	System.out.println(a.getName());
	}
}
