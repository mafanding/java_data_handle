/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.johnson.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import local.johnson.swing.TinyToolPanel;

/**
 *
 * @author mfdgood
 */
public class TinyToolComboBoxPanelEvent implements ActionListener {
    
    protected final String ITEM_UNIQUE = "Unique";
    
    protected final String ITEM_REPLACE = "Replace";
    
    protected final String ITEM_DEFAULT = "Default";
    
    protected TinyToolPanel tinyToolPanel;
    
    public TinyToolComboBoxPanelEvent(TinyToolPanel tinyToolPanel) {
        this.tinyToolPanel = tinyToolPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tinyToolPanel.removeAll();
        this.tinyToolPanel.add(this.tinyToolPanel.cPanel);
        if (this.tinyToolPanel.cPanel.getItemAt(this.tinyToolPanel.cPanel.getSelectedIndex()).toString().equals(ITEM_UNIQUE)) {
            this.tinyToolPanel.loadUniquePanel();
        } else if (this.tinyToolPanel.cPanel.getItemAt(this.tinyToolPanel.cPanel.getSelectedIndex()).toString().equals(ITEM_REPLACE)) {
            this.tinyToolPanel.loadReplacePanel();
        } else {
            this.tinyToolPanel.loadUniquePanel();
        }
    }
}
