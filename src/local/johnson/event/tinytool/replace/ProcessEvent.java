/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.johnson.event.tinytool.replace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import local.johnson.swing.tinytool.ReplacePanel;

/**
 *
 * @author mfdgood
 */
public class ProcessEvent implements ActionListener {
    
    public ReplacePanel replacePanel;
    
    public ProcessEvent(ReplacePanel replacePanel) {
        this.replacePanel = replacePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = this.replacePanel.sourceText.getText();
        String search = this.replacePanel.search.getText();
        String replace = this.replacePanel.replace.getText();
        this.replacePanel.destText.setText(input.replaceAll(search, replace));
    }
    
}
