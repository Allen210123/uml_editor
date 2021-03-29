package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import shape.AssociationLine;
import uml_editor.Panel;

public class GenerlizationMode extends Linemode{
	public GenerlizationMode()
	{
		click_inside = false;
		press_inside = false;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		System.out.println("fial:"+drawx2+"mid"+drawy2);
		System.out.println("xxx: " + click_inside);
		System.out.println("xxx: " + press_inside);
		
		if(click_inside == true && press_inside == true) {
			Panel.getInstance().lines.add(new AssociationLine(drawx1,drawy1,drawx2,drawy2,2,Panel.getInstance().shapes.get(which_shape).getid(),which_port,Panel.getInstance().shapes.get(which_shape2).getid(),which_port2));
			//�_�lx�y��. �_�ly�y��. ���Ix�y��. ���Iy�y��. ����line. �_�l�Ϊ��s��. �q�_�l�Ϊ�����port. ���I�Ϊ��s��. �q���I�Ϊ�����port
		}
		click_inside = false;
		press_inside = false;
		
	}
}