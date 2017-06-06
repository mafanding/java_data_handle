package local.johnson.swing;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;

public class DataMergePanel extends BasicPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataMergePanel() {
		initializeElements();
	}

	public DataMergePanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public DataMergePanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public DataMergePanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	protected void initializeElements()
	{
		button.setText("choose");
		button.addActionListener(this);
		pButton.setText("process");
		pButton.addActionListener(this);
		this.add(label);
		this.add(input);
		this.add(button);
		this.add(pButton);
		this.setLayout(new FlowLayout());
	}
	
	protected void initializedFileChooser()
	{
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    chooser.setFileFilter(filter);
	    chooser.setDialogTitle("select file or diretory");
	    int returnVal = chooser.showOpenDialog(chooser);
	    if (returnVal == JFileChooser.OPEN_DIALOG) {
	    	input.setText(chooser.getSelectedFile().getName());
	    }
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("choose")) {
			initializedFileChooser();
		} else if (arg0.getActionCommand().equals("process")) {
			//TODO
			System.out.println("I catch it");
		}
	}

}
