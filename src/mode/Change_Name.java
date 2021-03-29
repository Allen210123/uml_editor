package mode;
import mode.Mode;
import uml_editor.Frame;
import uml_editor.Panel;

import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class Change_Name extends Mode{
	public Change_Name() {
		
		String input = "";
		input = JOptionPane.showInputDialog("sth u wanna say");
		System.out.println(input+ "???");
		for(int i = 0; i <Panel.getInstance().shapes_with_com.size();i++) {
			if(Panel.getInstance().shapes_with_com.get(i).getwhether_select() == true && !input.equals("")) {
				Panel.getInstance().shapes_with_com.get(i).setName(input);
			}
		}
		Frame.getPanel().repaint();
	}
}
