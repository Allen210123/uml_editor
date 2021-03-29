package mode;

import java.util.ArrayList;
import java.util.List;
import mode.Mode;
import shape.Component;
import uml_editor.Panel;
import shape.Shape;

public class Group extends Mode{
	List<Shape> list;
	List<Integer> temp;
	public Group()
	{
		list = new ArrayList<>();
		temp = new ArrayList<>();
		for(int i = 0;i < Panel.getInstance().shapes_with_com.size();i++) {
			//System.out.println(i+"   "+Panel.shapes_with_com.get(i).whether_select);
			if(Panel.getInstance().shapes_with_com.get(i).getwhether_select() == true) {			
				list.add(Panel.getInstance().shapes_with_com.get(i));
				temp.add(i);
			}
		}
		for(int x = temp.size()-1;x >= 0;x--) {
			int a = temp.get(x);
			Panel.getInstance().shapes_with_com.remove(a);
		}
		Panel.getInstance().shapes_with_com.add(new Component(list));
		
		System.out.println("/////"+Panel.getInstance().shapes_with_com.size());
	}
	
}
