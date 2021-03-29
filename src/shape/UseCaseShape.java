package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class UseCaseShape extends Shape{
	
	
	public UseCaseShape(int size,Point position) {
		id = size;
		x = (int) position.getX();
		y = (int) position.getY(); 
		width = 100;
		height = 60;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillOval(x, y, this.width, this.height);
		g.setColor(Color.WHITE);
		g.drawOval(x, y, this.width, this.height);
		if (input != null)
			g.drawString(input, x+20,y+20);
	
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
	public void inside_or_not(int sel_x,int sel_y) {
		//System.out.println("478");
		if(sel_x > x && sel_x < x + width && sel_y > y && sel_y <y + height)
			whether_select = true;
		else
			whether_select = false;
	}
	public void press_in_or_out(int sel_x,int sel_y) {
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
	public void set_press_true() {
		whether_inside = true;
	}
	public void inrange(int start_x,int start_y,int end_x,int end_y) {
		int x0 = x+width;
		int y0 = y+height;
		System.out.println(start_x+" "+start_y+" "+end_x+" "+end_y+" "+x +" "+y+" "+width+" "+height);
		if(Math.abs(end_x-start_x) == Math.abs(x-start_x) + Math.abs(end_x-x) 
		&& Math.abs(end_x-start_x) == Math.abs(x0-start_x) + Math.abs(end_x-x0) 
		&& Math.abs(end_y-start_y) == Math.abs(y-start_y) + Math.abs(end_y-y)
		&& Math.abs(end_y-start_y) == Math.abs(y0-start_y) + Math.abs(end_y-y0)) {
			whether_select = true;
			System.out.println("123");
		}
		else {
			whether_select = false;
		}
		System.out.println(whether_select);
	}
	
}
