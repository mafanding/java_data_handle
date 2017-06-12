/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.johnson.event.datamerge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import local.johnson.swing.DataMerge;

/**
 *
 * @author mfdgood
 */
public class ProcessEvent implements ActionListener {

	public DataMerge dataMergePanel;

	public ProcessEvent(DataMerge dataMergePanel) {
		this.dataMergePanel = dataMergePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO
	}

}
