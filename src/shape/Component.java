package shape;

import java.util.ArrayList;
import java.util.List;

public class Component extends Shape{
	public List<Shape> list;
	
	public Component(List<Shape> list ) {	
		this.list = list;
		isgroup = true;
		depth = getdepth();
		setdepth(depth);
		whether_select = true;
	}
	public int getlistsize() {
		return list.size();
	
	}
	public void setdepth(int depth) {
		this.depth = depth;
		for(int i = 0; i <list.size();i++) {
			list.get(i).setdepth(depth);
		}
	}
	public int getdepth() {
		int origin = 99;
		int temp;
		for(int i = 0; i <list.size();i++){
			temp = list.get(i).getdepth();
			if(temp < origin)
				origin = temp;
		}
		return origin;
	}
	public Shape getlistcontent(int i){
		return list.get(i);
	}	
	public void inside_or_not(int sel_x,int sel_y) {
		Boolean sel = false;
		for(int i = 0; i <list.size();i++) {
			//System.out.println("99"+i);
			list.get(i).inside_or_not(sel_x, sel_y);
			if(list.get(i).whether_select == true) {
				//System.out.println("77"+i);
				sel = true;
				whether_select = true;
			}
			if(sel == true) {
				for(int j = 0; j <list.size();j++) {
					//System.out.println("66"+j);
					list.get(j).set_click_true();
					//System.out.println(list.get(j).whether_select);
				}
			}
				
			/*for(int j = 0; j <Panel.shapes.size();j++) {
				System.out.println("Pa"+Panel.shapes.get(j).whether_select);
			}*/
			if(sel == false) {
				whether_select = false;
			}
		}
	}
	public void press_in_or_out(int sel_x,int sel_y) {
		Boolean sel = false;
		for(int i = 0; i <list.size();i++) {
			//System.out.println(list.get(i).getWidth());
			list.get(i).press_in_or_out(sel_x, sel_y);
			if(list.get(i).whether_inside == true) {
				sel = true;
				whether_inside = true;
				for(int j = 0; j <list.size();j++) {
					list.get(j).set_press_true();
				}
			}
			if(sel == false) {
				whether_inside = false;
			}
		}
	}
	public void set_click_true() {
		this.whether_select = true;
		for(int i = 0; i <list.size();i++) {
			list.get(i).set_click_true();		
		}
	}
	public void set_click_false() {
		this.whether_select = false;
		for(int i = 0; i <list.size();i++) {
			list.get(i).set_click_false();		
		}
	}
	
	public void set_press_true() {
		this.whether_inside = true;
		for(int i = 0; i <list.size();i++) {
			list.get(i).set_press_true();		
		}
	}
	public void set_press_false() {
		this.whether_inside = false;
		for(int i = 0; i <list.size();i++) {
			list.get(i).set_press_false();		
		}
	}
	public void move(int movX,int movY) {
		for(int i = 0; i <list.size();i++) {
			list.get(i).move(movX,movY);		
		}
	}
	public void inrange(int start_x,int start_y,int end_x,int end_y) {
		Boolean sel = true;
		for(int i = 0; i <list.size();i++) {
			list.get(i).inrange(start_x,start_y,end_x,end_y);	
			
			if(list.get(i).whether_select == false) {
				sel = false;
				whether_select = false;
				
			}
			if(sel == true) {
				whether_select = true;
			}
		}
	}
	
	@Override
	public int overlap() {
		
		int temp;
		for(int i = 0; i <list.size();i++) {
			 temp = list.get(i).overlap();
			 if(temp < depth)
				 depth = temp;
			 System.out.println("+++"+depth);
		}
		return depth;
	}
	public void setnewdepth(int newdep){
		depth = newdep;
		for(int i = 0; i <list.size();i++) {
			list.get(i).setnewdepth(newdep);
		}
	}
}
