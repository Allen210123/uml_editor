package mode;

import java.awt.event.MouseEvent;

import uml_editor.Panel;
import shape.Shape;
import shape.UseCaseShape;

public class UsecaseMode extends Mode{
	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.print(e.getPoint());
		Panel canvasPanel = (Panel) e.getSource();
		Shape x = new UseCaseShape(Panel.getInstance().shapes.size(),e.getPoint());
		Panel.getInstance().shapes.add(x);
		Panel.getInstance().shapes_with_com.add(x);
	}
}
