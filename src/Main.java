import javax.swing.Timer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Timer timer = new Timer(3500, e -> {
			Venatana frame = new Venatana();
		});
		timer.setRepeats(false);
		timer.start();
	
		
		Splash sp = new Splash();
	}
}

