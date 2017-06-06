package local.johnson.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import local.johnson.swing.DownloadPicturePanel;

public class DownloadPictureChooseEvent implements ActionListener {
	
	protected DownloadPicturePanel downloadPicturePanel;

	public DownloadPictureChooseEvent(DownloadPicturePanel downloadPicturePanel) {
		this.downloadPicturePanel = downloadPicturePanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.downloadPicturePanel.chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		this.downloadPicturePanel.chooser.setFileFilter(this.downloadPicturePanel.filter);
		this.downloadPicturePanel.chooser.setDialogTitle("select a excel file");
	    int returnVal = this.downloadPicturePanel.chooser.showOpenDialog(this.downloadPicturePanel.chooser);
	    if (returnVal == JFileChooser.OPEN_DIALOG) {
	    	this.downloadPicturePanel.input.setText(this.downloadPicturePanel.chooser.getSelectedFile().getName());
	    }
	}
	
}
