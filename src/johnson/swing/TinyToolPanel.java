package johnson.swing;

import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TinyToolPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TinyToolPanel() throws FileNotFoundException {
		BufferedReader br;
		ArrayList<String> optList = new ArrayList<String>();
		String tName;
		String[] tArray;
		try {
			br = new BufferedReader(new FileReader("conf.d/"+this.getClass().getSimpleName()+".conf"));
			while ((tName = br.readLine()) != null) {
				tArray = tName.split("=");
				if (tArray.length <2) {
					continue;
				}
				if (tArray[0].equals("option")) {
					optList.add(tArray[1]);
				}
			}
			JComboBox cPanel = new JComboBox(optList.toArray());
			this.add(cPanel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
