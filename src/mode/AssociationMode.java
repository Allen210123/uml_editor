package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import shape.AssociationLine;
import uml_editor.Panel;

public class AssociationMode extends Linemode{
	
	
	public AssociationMode()
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
			Panel.getInstance().lines.add(new AssociationLine(drawx1,drawy1,drawx2,drawy2,1,Panel.getInstance().shapes.get(which_shape).getid(),which_port,Panel.getInstance().shapes.get(which_shape2).getid(),which_port2));
			//起始x座標. 起始y座標. 終點x座標. 終點y座標. 哪種line. 起始形狀編號. 從起始形狀哪個port. 終點形狀編號. 從終點形狀哪個port
		}
		click_inside = false;
		press_inside = false;
		
	}
}
