package local.johnson.swing;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Basic extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JButton button = new JButton();

	public JButton pButton = new JButton();

	public JTextField input = new JTextField(15);

	public JLabel label = new JLabel("File:");

	public JFileChooser chooser = new JFileChooser();

	public FileNameExtensionFilter filter = new FileNameExtensionFilter("excel files", "csv", "xls", "xlsx");

	public JTextPane msg = new JTextPane();

}
