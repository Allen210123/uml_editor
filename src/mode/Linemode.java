package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import uml_editor.Panel;

public class Linemode extends Mode{
	int x,y,graph_x1,graph_y1,graph_x2,graph_y2,height,width;
	Boolean click_inside ,press_inside;
	int drawx1,drawy1,drawx2,drawy2;
	int which_port,which_shape,which_port2,which_shape2;
	
	@Override
	public void mousePressed(MouseEvent e) {
		click_inside = false;
		x = (int) e.getPoint().getX();
		y = (int) e.getPoint().getY();
		
		
		for(int i= 0;i < Panel.getInstance().shapes.size();i++) {
			graph_x1 = Panel.getInstance().shapes.get(i).getX();
			graph_y1 = Panel.getInstance().shapes.get(i).getY();
			width = Panel.getInstance().shapes.get(i).getWidth();
			height = Panel.getInstance().shapes.get(i).getHeight();
			System.out.println("X:"+graph_x1+"Y:"+graph_y1+"W:"+width+"H:"+height);
			if(x > graph_x1 && x < graph_x1+width && y > graph_y1 && y <graph_y1 + height) {
				click_inside = true;
				
				double current = Double.MAX_VALUE;
				for(double cnt = 0;cnt < 4;cnt++) {
					Point coordinate;
					coordinate = Panel.getInstance().shapes.get(i).port_cal(cnt);
					
					System.out.println("mid:"+coordinate.x+"mid"+coordinate.y);
					double distance = Math.sqrt((coordinate.x-x)*(coordinate.x-x)+(coordinate.y-y)*(coordinate.y-y));
					if(distance < current) {
						current = distance;
						drawx1 = coordinate.x;
						drawy1 = coordinate.y;
						which_port = (int)cnt;
					}
				}
				which_shape = i;
				break;
			}

			
		}
		
	}
	public void mouseReleased(MouseEvent e) {
		x = (int) e.getX();
		y = (int) e.getY();
		//System.out.print(x);
		System.out.println("RELEASED");
		for(int i= 0;i < Panel.getInstance().shapes.size();i++) {
			graph_x2 = Panel.getInstance().shapes.get(i).getX();
			graph_y2 = Panel.getInstance().shapes.get(i).getY();
			width = Panel.getInstance().shapes.get(i).getWidth();
			height = Panel.getInstance().shapes.get(i).getHeight();
			System.out.println("X:"+graph_x2+"Y:"+graph_y2+"W:"+width+"H:"+height);
			if(x > graph_x2 && x < graph_x2 + width && y > graph_y2 && y < graph_y2 + height) {
				press_inside = true;
				//drawx2 = graph_x1;
				//drawy2 = graph_y1;
				double current = Double.MAX_VALUE;
				for(double cnt = 0;cnt < 4;cnt++) {
					Point coordinate;
					coordinate = Panel.getInstance().shapes.get(i).port_cal(cnt);
					
					System.out.println("mid:"+coordinate.x+"mid"+coordinate.y);
					double distance = Math.sqrt((coordinate.x-x)*(coordinate.x-x)+(coordinate.y-y)*(coordinate.y-y));
					if(distance < current) {
						current = distance;
						drawx2 = coordinate.x;
						drawy2 = coordinate.y;
						which_port2 = (int)cnt;
					}
				}
				which_shape2 = i;
				break;
			}			
		}
	}
}
