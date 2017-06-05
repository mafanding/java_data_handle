package johnson.swing;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import johnson.handle.DownloadPicture;

public class DownloadPicturePanel extends BasicPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DownloadPicturePanel() {
		initializeElements();
	}

	public DownloadPicturePanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DownloadPicturePanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DownloadPicturePanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
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
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    chooser.setFileFilter(filter);
	    chooser.setDialogTitle("select a excel file");
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
			String response = DownloadPicture.handle(chooser.getSelectedFile());
			msg.setText(response);
			this.add(msg);
			this.validate();
		}
	}

}
