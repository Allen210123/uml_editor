package mode;

import java.awt.event.MouseEvent;

import shape.ClassShape;
import uml_editor.Panel;
import shape.Shape;

public class ClassMode extends Mode{
	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println(e.getPoint());
		Panel canvasPanel = (Panel) e.getSource();
		Shape x = new ClassShape(Panel.getInstance().shapes.size(),e.getPoint());
		Panel.getInstance().shapes.add(x);
		Panel.getInstance().shapes_with_com.add(x);
		//System.out.println(e.getSource());
		//System.out.println(e.getPoint());
		//System.out.println("123");
	}
	
}
