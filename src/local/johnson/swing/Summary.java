package local.johnson.swing;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Summary extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected final String CONF_PREFIX = "conf.d/";

	public Summary() {
		JTabbedPane jTabbedpane = new JTabbedPane();
		List<String> tabList;
		Configurations configs = new Configurations();
		try {
			XMLConfiguration config = configs.xml("datahandle.xml");
			tabList = config.getList(String.class, "tabs.tab");
			for (int i = 0; i < tabList.size(); i++) {
				Class<?> reflectClass = Class.forName(this.getClass().getPackage().getName() + "." + tabList.get(i));
				JPanel panelInstance = (JPanel) reflectClass.newInstance();
				jTabbedpane.addTab(tabList.get(i), panelInstance);
			}
			this.setLayout(new GridLayout(1, 1));
			this.add(jTabbedpane);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	public Summary(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Summary(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Summary(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
