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
public class TinyToolUniqueEvent implements ActionListener {
    
    protected TinyToolPanel tinyToolPanel;
    
    public TinyToolUniqueEvent(TinyToolPanel tinyToolPanel) {
        this.tinyToolPanel = tinyToolPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("run in unique event");
    }
    
}
