package lambda;

import java.awt.event.ActionEvent;
import java.time.Instant;
import javax.swing.Timer;

public class MethodRef {
	static class Greeter{
		void greet(ActionEvent event) {
			System.out.println("Hello, the time is: " + 
								Instant.ofEpochMilli(event.getWhen()));
		}
	}
	
	static class RepeatedGreeter extends Greeter{
		void greet(ActionEvent event) {
			var timer = new Timer(1000, super::greet);
			timer.start();
		}
	}
	

	public static void main(String[] args) {
		var greeter = new RepeatedGreeter();
		greeter.greet(new ActionEvent(new MethodRef(),0,"Event's happened"));
	}

}
