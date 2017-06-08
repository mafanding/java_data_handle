package local.johnson.swing;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import local.johnson.event.datamerge.ChooseEvent;
import local.johnson.event.datamerge.ProcessEvent;

public class DataMergePanel extends BasicPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected final String CONF_PREFIX = "conf.d/";

    public JComboBox cPanel;

    public DataMergePanel() throws ClassNotFoundException, NoSuchMethodException {
        BufferedReader br;
        ArrayList<String> optList = new ArrayList<String>();
        String tName;
        String[] tArray;
        try {
            br = new BufferedReader(new FileReader(CONF_PREFIX.concat(this.getClass().getSimpleName()).concat(".conf")));
            while ((tName = br.readLine()) != null) {
                tArray = tName.split("=");
                if (tArray.length < 2) {
                    continue;
                }
                if (tArray[0].equals("option")) {
                    optList.add(tArray[1]);
                }
            }
            cPanel = new JComboBox(optList.toArray());
            button.setText("choose");
            button.addActionListener(new ChooseEvent(this));
            pButton.setText("process");
            pButton.addActionListener(new ProcessEvent(this));
            this.add(cPanel);
            this.add(label);
            this.add(input);
            this.add(button);
            this.add(pButton);
            this.setLayout(new GridLayout(2, 5));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataMergePanel(LayoutManager layout) {
        super(layout);
        // TODO Auto-generated constructor stub
    }

    public DataMergePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        // TODO Auto-generated constructor stub
    }

    public DataMergePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        // TODO Auto-generated constructor stub
    }

}
