/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.johnson.swing.tinytool;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author mfdgood
 */
public class ReplacePanel extends JPanel {
    public JTextArea sourceText = null;
    
    public JTextArea destText = null;
    
    public JTextPane directionText = null;
    
    public ReplacePanel() {
        super();
        sourceText = new JTextArea(15,5);
        destText = new JTextArea(15,5);
        directionText = new JTextPane();
        sourceText.setBorder(LineBorder.createBlackLineBorder());
        destText.setBorder(LineBorder.createBlackLineBorder());
        sourceText.setLineWrap(true);
        destText.setLineWrap(true);
        directionText.setText("=>");
        this.setLayout(new GridLayout(1, 4));
        this.add(sourceText);
        this.add(directionText);
        this.add(destText);
    }
}
