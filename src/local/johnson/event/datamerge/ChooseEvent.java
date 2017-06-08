/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.johnson.event.datamerge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import local.johnson.swing.DataMergePanel;

/**
 *
 * @author mfdgood
 */
public class ChooseEvent implements ActionListener {
    
    public DataMergePanel dataMergePanel;
    
    public ChooseEvent(DataMergePanel dataMergePanel) {
        this.dataMergePanel = dataMergePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dataMergePanel.chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        this.dataMergePanel.chooser.setFileFilter(this.dataMergePanel.filter);
        this.dataMergePanel.chooser.setDialogTitle("select file or diretory");
        int returnVal = this.dataMergePanel.chooser.showOpenDialog(this.dataMergePanel.chooser);
        if (returnVal == JFileChooser.OPEN_DIALOG) {
            this.dataMergePanel.input.setText(this.dataMergePanel.chooser.getSelectedFile().getName());
        }
    }
    
}
