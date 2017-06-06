package local.johnson.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import local.johnson.handle.DownloadPictureHandle;
import local.johnson.swing.DownloadPicturePanel;

public class DownloadPictureEvent implements ActionListener {
	
	protected DownloadPicturePanel downloadPicturePanel;

	public DownloadPictureEvent(DownloadPicturePanel downloadPicturePanel) {
		this.downloadPicturePanel = downloadPicturePanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("choose")) {
			initializedFileChooser();
		} else if (arg0.getActionCommand().equals("process")) {
			String response = DownloadPictureHandle.handle(this.downloadPicturePanel.chooser.getSelectedFile());
			this.downloadPicturePanel.msg.setText(response);
			this.downloadPicturePanel.add(this.downloadPicturePanel.msg);
			this.downloadPicturePanel.validate();
		}

	}
	
	protected void initializedFileChooser()
	{
		this.downloadPicturePanel.chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		this.downloadPicturePanel.chooser.setFileFilter(this.downloadPicturePanel.filter);
		this.downloadPicturePanel.chooser.setDialogTitle("select a excel file");
	    int returnVal = this.downloadPicturePanel.chooser.showOpenDialog(this.downloadPicturePanel.chooser);
	    if (returnVal == JFileChooser.OPEN_DIALOG) {
	    	this.downloadPicturePanel.input.setText(this.downloadPicturePanel.chooser.getSelectedFile().getName());
	    }
	}

}
