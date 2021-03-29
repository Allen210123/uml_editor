package shape;

import java.awt.Color;
import java.awt.Graphics;

public class CompositionLine extends Line{

	public CompositionLine(int a,int b ,int c,int d,int e,int f,int g,int h,int i){
		super(a, b, c, d,e,f,g,h,i);
		
	}
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawLine(x1, y1, x2, y2);
	}
}
