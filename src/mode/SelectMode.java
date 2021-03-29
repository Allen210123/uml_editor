package mode;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import uml_editor.Panel;

public class SelectMode extends Mode{
	int x,y;
	int x0,y0,width,height;
	Boolean inside_shape = false;
	int which_shape = 0;
	int start_x,start_y;
	List<Integer> temp;
	public void mousePressed(MouseEvent e) {
		x = (int) e.getPoint().getX();
		y = (int) e.getPoint().getY();
		temp = new ArrayList<Integer>();
		for(int i = 0;i < Panel.getInstance().shapes_with_com.size();i++) {
			Panel.getInstance().shapes_with_com.get(i).press_in_or_out(x,y);
			if(Panel.getInstance().shapes_with_com.get(i).getwhether_inside() == true) {
				inside_shape = true;
				temp.add(i);
			}
		}
		while(temp.size()>1) {
			int x1 = temp.get(0);
			int x2 = temp.get(1);
			
			if(Panel.getInstance().shapes_with_com.get(x1).getdepth() > Panel.getInstance().shapes_with_com.get(x2).getdepth()) {
				Panel.getInstance().shapes_with_com.get(x1).set_press_false();
				System.out.println("bBBBB: " + x1 + ": " + Panel.getInstance().shapes_with_com.get(x1).getwhether_inside());
				temp.remove(0);
			}
			else {
				Panel.getInstance().shapes_with_com.get(x2).set_press_false();
				temp.remove(1);
			}
		}
		start_x = x;
		start_y = y;
		
	}
	public void mouseReleased(MouseEvent e) {
		x = (int) e.getPoint().getX();
		y = (int) e.getPoint().getY();
		int end_x = x,end_y = y;
		
		if(inside_shape == true) {
			x = x - start_x;
			y = y - start_y;	
			for(int cnt = 0;cnt < Panel.getInstance().shapes_with_com.size();cnt++) {
				if(Panel.getInstance().shapes_with_com.get(cnt).getwhether_inside() == true) {
					Panel.getInstance().shapes_with_com.get(cnt).move(x,y);
					int depth = Panel.getInstance().shapes_with_com.get(cnt).overlap();
					Panel.getInstance().shapes_with_com.get(cnt).setnewdepth(depth);
				}
			}
			
			inside_shape = false;
		}
	
		else{
			for(int cnt = 0;cnt < Panel.getInstance().shapes_with_com.size(); cnt++) {
				Panel.getInstance().shapes_with_com.get(cnt).inrange(start_x,start_y,end_x,end_y);
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		x = (int) e.getPoint().getX();
		y = (int) e.getPoint().getY();
		temp = new ArrayList<>();
		for(int i = Panel.getInstance().shapes_with_com.size()-1;i >= 0 ;i--) {
			Panel.getInstance().shapes_with_com.get(i).inside_or_not(x,y);
			if(Panel.getInstance().shapes_with_com.get(i).getwhether_select() == true) {
				temp.add(i);
			}
		}
		while(temp.size()>1) {
			int x1 = temp.get(0);
			int x2 = temp.get(1);
			if(Panel.getInstance().shapes_with_com.get(x1).getdepth() > Panel.getInstance().shapes_with_com.get(x2).getdepth()) {
				Panel.getInstance().shapes_with_com.get(x1).set_click_false();
				temp.remove(0);
			}
			else {
				Panel.getInstance().shapes_with_com.get(x2).set_click_false();
				temp.remove(1);
			}
		}
		if(temp.size() == 1) {
			
			int x = temp.get(0);
			int depth = Panel.getInstance().shapes_with_com.get(x).overlap();
			Panel.getInstance().shapes_with_com.get(x).setnewdepth(depth);
		}
		
		
	}
	
}
