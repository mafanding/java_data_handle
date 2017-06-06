package local.johnson.swing;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import local.johnson.event.DownloadPictureEvent;

public class DownloadPicturePanel extends BasicPanel {

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
		button.addActionListener(new DownloadPictureEvent(this));
		pButton.setText("process");
		pButton.addActionListener(new DownloadPictureEvent(this));
		this.add(label);
		this.add(input);
		this.add(button);
		this.add(pButton);
		this.setLayout(new FlowLayout());
	}

}
