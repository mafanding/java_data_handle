package local.johnson;

import java.awt.Toolkit;
import javax.swing.JFrame;
import local.johnson.swing.Summary;

public class dataHandle {

	protected static JFrame frame;

	public static void main(String[] args) {
		startUp();
	}

	protected static void startUp() {
		frame = new JFrame("Data Handle Tool");
		frame.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 4,
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 4);
		frame.setLocation((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2,
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Summary());
		frame.setVisible(true);
	}
}
