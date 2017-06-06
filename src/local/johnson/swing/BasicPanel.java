package local.johnson.swing;

import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BasicPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton button = new JButton();
	
	public JButton pButton = new JButton();
	
	public JTextField input = new JTextField(15);
	
	public JLabel label = new JLabel("File:");
	
	public JFileChooser chooser = new JFileChooser();
	
	public FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "excel files", "csv", "xls", "xlsx");
	
	public JTextPane msg = new JTextPane();

	public BasicPanel() {
		// TODO Auto-generated constructor stub
	}

	public BasicPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public BasicPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public BasicPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
