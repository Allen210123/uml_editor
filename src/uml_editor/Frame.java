package uml_editor;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

public class Frame {
	private JFrame f;
	private static Panel p;
	private Tool t;
	private Menubar m;

	JMenuItem item1;
	public Frame() {
		f = new JFrame("JFrame 1");
	    f.setBounds(0,0,1000,800);
	    f.setVisible(true); 
	    //�e��
	    p = Panel.getInstance();
	    f.add(p,BorderLayout.CENTER);
	    
	    //�u��C���e��
	    t = new Tool();
	    f.add(t,BorderLayout.WEST);
	    
	    //menubar
	    m = new Menubar();
	    f.add(m,BorderLayout.NORTH);
	    
	}

	public static Panel getPanel() {
		return p;
	}
}
