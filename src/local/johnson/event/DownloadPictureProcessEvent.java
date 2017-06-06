package local.johnson.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import local.johnson.handle.DownloadPictureHandle;
import local.johnson.swing.DownloadPicturePanel;

public class DownloadPictureProcessEvent implements ActionListener {
	
	protected DownloadPicturePanel downloadPicturePanel;

	public DownloadPictureProcessEvent(DownloadPicturePanel downloadPicturePanel) {
		this.downloadPicturePanel = downloadPicturePanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String response = DownloadPictureHandle.handle(this.downloadPicturePanel.chooser.getSelectedFile());
		this.downloadPicturePanel.msg.setText(response);
		this.downloadPicturePanel.add(this.downloadPicturePanel.msg);
		this.downloadPicturePanel.validate();
	}

}
