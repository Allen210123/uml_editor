package uml_editor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import mode.*;

public class Tool extends JPanel{
	private Button selectbtn;
	private Button classbtn;
	private Button usecasebtn;
	private Button associationbtn;
	private Button generlizationbtn;
	private Button compositionbtn;
	public ArrayList<Button> buttonlist = new ArrayList<Button>();
	public Tool(){
		
		this.setLayout(new BoxLayout( this,BoxLayout.Y_AXIS));
		this.setBackground(Color.gray);
		
		selectbtn = new Button("selectbtn", new SelectMode(),buttonlist);
		add(selectbtn);
		
		associationbtn = new Button("associationbtn",new AssociationMode(),buttonlist);
		add(associationbtn);
		
		generlizationbtn = new Button("generlizationbtn",new GenerlizationMode(),buttonlist);
		add(generlizationbtn);
		
		compositionbtn = new Button("compositionbtn",new CompositionMode(),buttonlist);
		add(compositionbtn);
		
		classbtn = new Button("classbtn",new ClassMode(),buttonlist);
		add(classbtn);
		
		usecasebtn = new Button("usecasebtn",new UsecaseMode(),buttonlist);
		add(usecasebtn);	
		
		buttonlist.add(selectbtn);
		buttonlist.add(associationbtn);
		buttonlist.add(generlizationbtn);
		buttonlist.add(compositionbtn);
		buttonlist.add(classbtn);
		buttonlist.add(usecasebtn);
		
	}
	
		
	
}
