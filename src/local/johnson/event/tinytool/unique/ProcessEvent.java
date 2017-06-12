/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.johnson.event.tinytool.unique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import local.johnson.swing.tinytool.Unique;

/**
 *
 * @author mfdgood
 */
public class ProcessEvent implements ActionListener {

	public Unique uniquePanel;

	public ProcessEvent(Unique uniquePanel) {
		this.uniquePanel = uniquePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = this.uniquePanel.sourceText.getText();
		String inputs[] = input.split(System.getProperty("line.separator"));
		StringBuilder outputBuffer = new StringBuilder();
		ArrayList<String> arrayList = new ArrayList<String>();
		for (String i : inputs) {
			if (!arrayList.contains(i)) {
				arrayList.add(i);
				outputBuffer.append(i).append(System.getProperty("line.separator"));
			}
		}
		this.uniquePanel.destText.setText(outputBuffer.toString());
	}

}
