package shape;

import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import uml_editor.Panel;

public class Shape {
	public List<Port> ports = new ArrayList<>();
	public void paint(Graphics g) {}
	Point port_cal;
	int id;
	int depth;
	Boolean whether_select;/*有沒有被click*/
	Boolean whether_inside;
	Boolean isgroup;
	String input;
	Boolean text_or_not;
	public Shape() {
		port_cal = new Point();
		whether_select = false;
		isgroup = false;
		depth = 99;
		text_or_not = false;
	}
	public int x,y;
	int width,height;
	public int setdepth(int x0,int depth) {
		for(int i = 0;i <Panel.getInstance().shapes.size();i++) {
			
			int x = Panel.getInstance().shapes.get(i).x;
			int width = Panel.getInstance().shapes.get(i).width;
			System.out.println(x+" "+width);
			if(Math.abs(x0-x) < width && depth >=Panel.getInstance().shapes.get(i).depth) {
				depth = Panel.getInstance().shapes.get(i).depth -1;
			}	
		}
		return depth;
	}
	public void setName(String input) {
		this.input = input;
	}
	public int getid() {
		return id;
	}
	public boolean getwhether_select() {
		return whether_select;
	}
	public boolean getwhether_inside() {
		return whether_inside;
	}
	public boolean getisgroup() {
		return isgroup;
	}
	
	public int overlap() {
		int dep = this.depth;
		int id = this.id;
		int x0 = this.x;
		int y0 = this.y;
		for(int i = 0;i <Panel.getInstance().shapes.size();i++) {
			
			if(Panel.getInstance().shapes.get(i).id != id) {
				System.out.println(Panel.getInstance().shapes.get(i).id);
				int x = Panel.getInstance().shapes.get(i).x;
				int y = Panel.getInstance().shapes.get(i).y;
				int width = Panel.getInstance().shapes.get(i).width;
				int height = Panel.getInstance().shapes.get(i).height;
				//System.out.println(x+" "+width);
				if(Math.abs(x0-x) < width && Math.abs(y0-y) < height && dep >= Panel.getInstance().shapes.get(i).depth ) {
					
					dep = Panel.getInstance().shapes.get(i).depth -1;
				}	
			}
		}
		return dep;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
		
	}
	public Point port_cal(double n) {
		Point port_n = new Point();
		double x0 = x;
		double y0 = y;
		n = n * 0.5f * Math.PI;
		x0 = x + (0.5f * width);
		y0 = y + (0.5f * height);
		port_n.x = (int) (x0 + Math.cos(n) * 0.5f * width);
		port_n.y = (int) (y0 + Math.sin(n) * 0.5f * height);
		return port_n;
	}
	public void inside_or_not(int sel_x,int sel_y) {//click的時候判斷有沒有在圖形內
		//System.out.println("478");
		if(sel_x > x && sel_x < x + width && sel_y > y && sel_y <y + height)
			whether_select = true;
		else
			whether_select = false;
	}
	public void press_in_or_out(int sel_x,int sel_y) {//拖曳的時候判斷是脫shape或框住
		if(sel_x > x && sel_x < x + width && sel_y > y && sel_y <y + height)
			whether_inside = true;
		else
			whether_inside = false;
	}
	public void move(int movX,int movY) {
		x = x + movX;
		y = y + movY;
	}
	public void set_click_true() {
		whether_select = true;
	}
	public void set_click_false() {
		whether_select = false;
	}
	public void set_press_true() {
		whether_inside = true;
	}
	public void set_press_false() {
		whether_inside = false;
	}
	public void inrange(int start_x,int start_y,int end_x,int end_y) {
		
	}
	public int getlistsize() {
		return 0;
	}
	public Shape getlistcontent(int i){
		return null;
	}
	public int getdepth() {  
        return depth;  
    }  
	public void setdepth(int depth) {
		this.depth = depth;
	}
	public static void sort(List<Shape> list) {
		for(int i=0;i<list.size();i++){
		       for(int j=0;j<list.size()-i-1;j++ ) {
		    	   if(list.get(j).depth <list.get(j+1).depth) {
		    		   Collections.swap(list, j, j+1);
		    	   }
		      }
		 }
	}
	public void setnewdepth(int newdep) {
		depth = newdep;
	}
	
	
	
}
