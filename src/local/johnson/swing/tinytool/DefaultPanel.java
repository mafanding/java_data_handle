/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.johnson.swing.tinytool;

import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author mfdgood
 */
public class DefaultPanel extends JPanel {
	public JTextPane msgPane = null;
    public DefaultPanel() {
    	super();
    	msgPane.setText("wait for develope");
    	this.add(msgPane);
    }
}
