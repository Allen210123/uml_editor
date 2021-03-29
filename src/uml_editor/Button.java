package uml_editor;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import mode.Mode;

public class Button extends JButton{
	Mode mode;
	public ArrayList<Button> list;
	public Button(String pic,Mode mode,ArrayList<Button> list) {
		this.list = list;
		this.mode = mode;
		this.setIcon(new ImageIcon(getClass().getResource(pic+".jpg")));
		this.setPreferredSize(new Dimension(80,80));	 
		addActionListener(new ModeChange());
	}
	class ModeChange implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Panel.getInstance().currentmode = mode;
			System.out.println(mode);
			gabe();
		}
	}
	
	public void gabe()
	{
		for(int i = 0;i < list.size();i++) {
			if(list.get(i) != this) {
				list.get(i).setBackground(Color.WHITE);
			}
			else {
				list.get(i).setBackground(Color.BLACK);
			}
		}
	}
}
