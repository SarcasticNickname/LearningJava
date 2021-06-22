package basics;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class ShowCalendarForCurrMonth {
	
	public static void showCalendar() {
		
		LocalDate localDate = LocalDate.now();
		int month  = localDate.getMonthValue();
		int today = localDate.getDayOfMonth();
		//set to start of month
		localDate = localDate.minusDays(today - 1);
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		// 1 = Monday, ..., 7 = Sunday
		int value = dayOfWeek.getValue();
		
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		for (int i = 1; i < value; i++) {
			System.out.print("    ");
		}
		
		while(localDate.getMonthValue() == month) {
			System.out.printf("%3d", localDate.getDayOfMonth());
			if(localDate.getDayOfMonth() == today) 
				System.out.print("*");
			else
				System.out.print(" ");
			localDate = localDate.plusDays(1);
			if(localDate.getDayOfWeek().getValue() == 1)
				System.out.println();
			
		}
		
	}

	public static void main(String[] args) {
		showCalendar();
	}

}
