package johnson;

import java.awt.Toolkit;

import javax.swing.JFrame;

import johnson.swing.SummaryPanel;

public class dataHandle {	
	public static void main(String[] args)
	{
		startUp();
	}

	protected static void startUp()
	{
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Data Handle Tool");
        // Setting the width and height of frame
        frame.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/4, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/4);
        frame.setLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SummaryPanel sPanel = new SummaryPanel();    
        // 添加面板
        frame.add(sPanel);
        
        // 设置界面可见
        frame.setVisible(true);
	}
}
