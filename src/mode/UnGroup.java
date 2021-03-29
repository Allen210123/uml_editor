package mode;
import mode.Mode;
import uml_editor.Panel;

public class UnGroup extends Mode{
	public UnGroup() {
		for(int i = 0;i < Panel.getInstance().shapes_with_com.size();i++) {
			if(Panel.getInstance().shapes_with_com.get(i).getwhether_select() == true 
					&& Panel.getInstance().shapes_with_com.get(i).getisgroup() == true) {
				int size = Panel.getInstance().shapes_with_com.get(i).getlistsize();
				System.out.print("+++"+size);
				for(int j = 0;j < size;j++) {
					Panel.getInstance().shapes_with_com.add(Panel.getInstance().shapes_with_com.get(i).getlistcontent(j));		
				}
				Panel.getInstance().shapes_with_com.remove(Panel.getInstance().shapes_with_com.get(i));
			}
			break;
		}
	}
}
