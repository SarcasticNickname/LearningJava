package basics;

public class StringFormat {

	public static void main(String[] args) {
		System.out.printf("Hello, %s , I am %s, my age is %.1f \n","Mark","Timy",15.0);
		
		String dblNumFormat = String.format("1.123 + 2.234 = %.3f" , 1.123 + 2.234);
		System.out.println(dblNumFormat);
		
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
	}

}
