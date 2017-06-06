package local.johnson.swing;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class SummaryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final String confPrefix = "conf.d/";

	public SummaryPanel() {
		BufferedReader br;
		JTabbedPane jTabbedpane = new JTabbedPane();
		ArrayList<String> tabList = new ArrayList<String>();
		String tName;
		String[] tArray;
		try {
			br = new BufferedReader(new FileReader(confPrefix.concat("layout.conf")));
			while ((tName = br.readLine()) != null) {
				tArray = tName.split("=");
				if (tArray.length <2) {
					continue;
				}
				if (tArray[0].equals("tabName")) {
					tabList.add(tArray[1]);
				}
			}
			for (int i = 0 ; i < tabList.size(); i++) {
				Class<?> reflectClass = Class.forName(this.getClass().getPackage().getName()+"."+tabList.get(i)+"Panel");
				JPanel panelInstance = (JPanel) reflectClass.newInstance();
				jTabbedpane.addTab(tabList.get(i), panelInstance);
			}
			this.setLayout(new GridLayout(1, 1)); 
			this.add(jTabbedpane);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SummaryPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SummaryPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SummaryPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
