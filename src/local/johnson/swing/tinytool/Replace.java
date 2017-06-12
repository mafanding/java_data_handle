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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import local.johnson.event.tinytool.replace.ProcessEvent;

/**
 *
 * @author mfdgood
 */
public class Replace extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextArea sourceText = null;

	public JTextArea destText = null;

	public JTextField search = null;

	public JTextField replace = null;

	public JTextPane directionText = null;

	public JButton processButton = null;

	public Replace() {
		super();
		sourceText = new JTextArea(15, 5);
		destText = new JTextArea(15, 5);
		directionText = new JTextPane();
		processButton = new JButton();
		search = new JTextField(1);
		replace = new JTextField(1);
		processButton.setText("process");
		processButton.addActionListener(new ProcessEvent(this));
		sourceText.setBorder(LineBorder.createBlackLineBorder());
		destText.setBorder(LineBorder.createBlackLineBorder());
		sourceText.setLineWrap(true);
		destText.setLineWrap(true);
		directionText.setText("=>");
		directionText.setEditable(false);
		this.setLayout(new GridLayout(1, 6));
		this.add(sourceText);
		this.add(directionText);
		this.add(search);
		this.add(replace);
		this.add(destText);
		this.add(processButton);
	}
}
