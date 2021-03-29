package shape;

import java.awt.Graphics;
import java.awt.Point;

public class Line {
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public int what_kind_of_line;
	public int which_shape1;
	public int which_shape2;
	public int shape1_port;
	public int shape2_port;
	public Line(int a,int b ,int c,int d,int e,int f,int g,int h,int i){
		x1 = a;
		y1 = b;
		x2 = c;
		y2 = d;
		what_kind_of_line = e;
		which_shape1 = f;
		shape1_port = g;
		which_shape2 = h;	
		shape2_port = i;
		
	}
	public void paint(Graphics g) {}
	public int getshape1() {
		return which_shape1;
	}
	public int getshape2() {
		return which_shape2;
	}
}
