/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.johnson.swing.tinytool;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import local.johnson.event.tinytool.unique.ProcessEvent;

/**
 *
 * @author mfdgood
 */
public class Unique extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextArea sourceText = null;

	public JTextArea destText = null;

	public JTextPane directionText = null;

	public JButton processButton = null;

	public Unique() {
		super();
		sourceText = new JTextArea(15, 5);
		destText = new JTextArea(15, 5);
		directionText = new JTextPane();
		processButton = new JButton();
		processButton.setText("process");
		processButton.addActionListener(new ProcessEvent(this));
		sourceText.setBorder(LineBorder.createBlackLineBorder());
		destText.setBorder(LineBorder.createBlackLineBorder());
		sourceText.setLineWrap(true);
		destText.setLineWrap(true);
		directionText.setText("=>");
		directionText.setEditable(false);
		this.setLayout(new GridLayout(1, 4));
		this.add(sourceText);
		this.add(directionText);
		this.add(destText);
		this.add(processButton);
	}
}
