/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.johnson.swing.tinytool;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author mfdgood
 */
public class ReplacePanel extends JPanel {
    public JTextArea sourceText = null;
    
    public JTextArea destText = null;
    
    public ReplacePanel() {
        super();
        sourceText = new JTextArea(5,5);
        destText = new JTextArea(5,5);
        this.setLayout(new GridLayout(1, 3));
        this.add(sourceText);
        this.add(destText);
    }
}
