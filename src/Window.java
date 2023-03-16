
import javax.swing.JFrame;

public class Window{

	public Window(String title, int width, int height, Game game) {
		JFrame frame = new JFrame(title);
		frame.setSize(width, height);
		frame.add(game);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
