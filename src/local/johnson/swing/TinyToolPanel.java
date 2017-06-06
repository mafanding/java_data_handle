package local.johnson.swing;

import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import local.johnson.event.TinyToolComboBoxPanelEvent;

public class TinyToolPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        
        protected final String CONF_PREFIX = "conf.d/";
        
        public JComboBox cPanel;

	public TinyToolPanel() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		BufferedReader br;
		ArrayList<String> optList = new ArrayList<String>();
		String tName;
		String[] tArray;
		try {
			br = new BufferedReader(new FileReader(CONF_PREFIX.concat(this.getClass().getSimpleName()).concat(".conf")));
			while ((tName = br.readLine()) != null) {
				tArray = tName.split("=");
				if (tArray.length <2) {
					continue;
				}
				if (tArray[0].equals("option")) {
					optList.add(tArray[1]);
				}
			}
			cPanel = new JComboBox(optList.toArray());
                        Class<?> reflectClass = Class.forName("local.johnson.event.TinyTool"+optList.get(0).concat("Event"));
                        Constructor c = reflectClass.getConstructor(TinyToolPanel.class);
                        cPanel.addActionListener(new TinyToolComboBoxPanelEvent(this));
			this.add(cPanel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TinyToolPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public TinyToolPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public TinyToolPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
