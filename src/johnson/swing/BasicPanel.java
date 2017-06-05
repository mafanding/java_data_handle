package johnson.swing;

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
	
	protected JButton button = new JButton();
	
	protected JButton pButton = new JButton();
	
	protected JTextField input = new JTextField(15);
	
	protected JLabel label = new JLabel("File:");
	
	protected JFileChooser chooser = new JFileChooser();
	
	protected FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "excel files", "csv", "xls", "xlsx");
	
	protected JTextPane msg = new JTextPane();

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
