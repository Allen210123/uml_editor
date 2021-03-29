package uml_editor;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import uml_editor.Panel;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import mode.*;
import shape.*;
import shape.Shape;

public class Panel extends JPanel{
	public  Mode currentmode;
	private static Panel instance = null;
	public  List<Shape> shapes = new ArrayList<>();
	public  List<Shape> shapes_with_com = new ArrayList<>();
	public  List<Line> lines = new ArrayList<>();
	public  static Panel getInstance() {
		if (instance == null) {
			instance = new Panel();
		}
		return instance;
	}
	private Panel() {
		
		this.setBackground(Color.black);
		
		addMouseListener(new MouseAdapter() {
	        @Override
	        public void mousePressed(MouseEvent e) {
	        	currentmode.mousePressed(e);
	        	repaint();
	        	
	        }
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	currentmode.mouseClicked(e);
	        	repaint();
	        }
	        @Override
	        public void mouseReleased(MouseEvent e) {
	        	currentmode.mouseReleased(e);
	        	repaint();
	        }
	    });
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Shape.sort(shapes);
		for(int i= 0;i<shapes.size();i++) {
			//System.out.println("id:" + shapes.get(i).id+" "+shapes.get(i).depth);
		}
		
		for(int i= 0;i<shapes.size();i++) {
			shapes.get(i).paint(g);
			//System.out.println("X: "+shapes.get(i).x +"Y: "+ shapes.get(i).y+"...");
			if(Panel.getInstance().shapes.get(i).getwhether_select() == true) {
				//System.out.println(i);
				for(int cnt = 0;cnt < 4;cnt++) {
					Point coordinate;
					coordinate = Panel.getInstance().shapes.get(i).port_cal(cnt);
					g.fillRect(coordinate.x-2, coordinate.y-2, 5, 5);
					//System.out.println("cnt: "+coordinate);
				}
				
			}
			
				
		}
		for(int i= 0;i<lines.size();i++) {
			Point cor1 = new Point();
			Point cor2 = new Point();
			for(int count = 0;count <shapes.size();count++) {
				if(lines.get(i).which_shape1 == shapes.get(count).getid()) {
					cor1 = shapes.get(count).port_cal(lines.get(i).shape1_port);
				}
			}
			for(int count = 0;count <shapes.size();count++) {
				if(lines.get(i).which_shape2 == shapes.get(count).getid()) {
					cor2 = shapes.get(count).port_cal(lines.get(i).shape2_port);
				}
			}
			//cor1 = shapes.get((lines.get(i).which_shape1)).port_cal(lines.get(i).shape1_port);
			//cor2 = shapes.get((lines.get(i).which_shape2)).port_cal(lines.get(i).shape2_port);
			lines.get(i).x1 = cor1.x ;
			lines.get(i).y1 = cor1.y;
			lines.get(i).x2 = cor2.x;
			lines.get(i).y2 = cor2.y;
			lines.get(i).paint(g);
			if(lines.get(i).what_kind_of_line == 2) {
				g.drawPolygon(new int[] {lines.get(i).x2-12, lines.get(i).x2, lines.get(i).x2-12}, new int[] {lines.get(i).y2-8, lines.get(i).y2, lines.get(i).y2+8}, 3);
			}
			else if(lines.get(i).what_kind_of_line == 3) {
				g.drawPolygon(new int[] {lines.get(i).x2-8, lines.get(i).x2, lines.get(i).x2-8,lines.get(i).x2-16}, 
								new int[] {lines.get(i).y2-8, lines.get(i).y2, lines.get(i).y2+8,lines.get(i).y2}, 4);
			}
			g.fillRect(lines.get(i).x1, lines.get(i).y1, 5, 5);
			g.fillRect(lines.get(i).x2, lines.get(i).y2-2, 5, 5);
		}
	}
	
	
}
