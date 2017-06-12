package local.johnson.swing;

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
import local.johnson.swing.tinytool.Default;
import local.johnson.swing.tinytool.Replace;
import local.johnson.swing.tinytool.Unique;

public class TinyTool extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected final String CONF_PREFIX = "conf.d/";

	public JComboBox<?> cPanel;

	public TinyTool() throws FileNotFoundException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		BufferedReader br;
		ArrayList<String> optList = new ArrayList<String>();
		String tName;
		String[] tArray;
		try {
			br = new BufferedReader(
					new FileReader(CONF_PREFIX.concat(this.getClass().getSimpleName()).concat(".conf")));
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
			Class<?> reflectClass = Class.forName("local.johnson.event.TinyTool" + optList.get(0).concat("Event"));
			Constructor c = reflectClass.getConstructor(TinyTool.class);
			cPanel.addActionListener(new TinyToolComboBoxPanelEvent(this));
			this.add(cPanel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadUniquePanel() {
		this.add(new Unique());
	}

	public void loadReplacePanel() {
		this.add(new Replace());
	}

	public void loadDefaultPanel() {
		this.add(new Default());
	}

}
