package uml_editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import uml_editor.Button.ModeChange;
import mode.Group;
import mode.Mode;
import mode.SelectMode;
import mode.UnGroup;
import mode.Change_Name;
public class Menubar extends JMenuBar  {
	Mode mode;
	public Menubar(){
		JMenu menu1,menu2;
		JMenuItem group;
		JMenuItem ungroup;
		JMenuItem change;
		menu1 = new JMenu("File");
		add(menu1);
		menu2 = new JMenu("Edit");
		add(menu2);
		group = new JMenuItem("group");
		group.addActionListener(new ModeChange());
		group.setActionCommand("group");
		ungroup = new JMenuItem("ungroup");
		ungroup.addActionListener(new ModeChange());
		ungroup.setActionCommand("ungroup");
		change = new JMenuItem("Change Object Name");
		change.setActionCommand("change");
		change.addActionListener(new ModeChange());
		menu2.add(group);
		menu2.add(ungroup);
		menu2.add(change);
		
	}
	class ModeChange implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
	        if (cmd == "group") {
	        	Panel.getInstance().currentmode = new Group();
	        	System.out.println(Panel.getInstance().currentmode);
	        	Panel.getInstance().currentmode = new SelectMode();
	        }
	        if (cmd == "ungroup") {
	        	Panel.getInstance().currentmode = new UnGroup();
	        	System.out.println(Panel.getInstance().currentmode);
	        	Panel.getInstance().currentmode = new SelectMode();
	        }
	        if (cmd == "change") {
	        	System.out.println("Gabe");
	        	Panel.getInstance().currentmode = new Change_Name();
	        	System.out.println(Panel.getInstance().currentmode);
	        }
		}
		
	}
	/*public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd == "group") {
        	Panel.currentmode = new Group();
        	System.out.println(Panel.currentmode);
        }
        if (cmd == "ungroup") {
        	Panel.currentmode = new UnGroup();
        	System.out.println(Panel.currentmode);
        }
        
    }*/


}
