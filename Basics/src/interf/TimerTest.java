package interf;

import java.awt.event.*;
import java.time.*;
import javax.swing.*;

/**
 * Learning interfaces and events.
 * @author SarcasticNickname
 */
public class TimerTest {
	public static void main(String [] args) {
		//Объект по типу EventHandler-а.
		//Object similar to EventHandler in c#.
		var listener = new TimePrinter();
		//Таймер.
		var timer = new Timer(1000,listener);
		
		timer.start();
		
		//Диалоговое окно по умолчанию. Программа не перестанет выполняться, пока
		//в диалоговом окне что-то не нажать.
		//Defalut dialog window. The program won't terminate unless we press the button in the
		//Dialog window.
		JOptionPane.showMessageDialog(null, "Exit program?");
		//Завершение программы.
		System.exit(0);
	}
}


/**
 * Class Similar to EventHandler in c#.
 * @author SarcasticNickname.
 */
class TimePrinter implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		System.out.println("The time is: " + Instant.ofEpochMilli(event.getWhen()));
	}
}
