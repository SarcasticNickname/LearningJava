package lambda;

import javax.swing.Timer;
import javax.swing.*;
import java.util.*;

public class LambdaTime {

	public static void main(String[] args) {
		// timer = new Timer(1000, System.out::println);
		var timer = new Timer(1000, event -> 
			System.out.println("The time is: " + new Date()));
		timer.start();
		//keeps the program running until user selects OK.
		JOptionPane.showMessageDialog(null,"Quit program?");
		System.exit(0);
	}
}
