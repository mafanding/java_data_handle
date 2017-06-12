package local.johnson.swing;

import java.awt.FlowLayout;
import local.johnson.event.DownloadPictureChooseEvent;
import local.johnson.event.DownloadPictureProcessEvent;

public class DownloadPicture extends Basic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DownloadPicture() {
		initializeElements();
	}

	protected void initializeElements() {
		button.setText("choose");
		button.addActionListener(new DownloadPictureChooseEvent(this));
		pButton.setText("process");
		pButton.addActionListener(new DownloadPictureProcessEvent(this));
		this.add(label);
		this.add(input);
		this.add(button);
		this.add(pButton);
		this.setLayout(new FlowLayout());
	}

}
