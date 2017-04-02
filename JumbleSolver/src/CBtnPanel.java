import java.util.ArrayList;

import javax.swing.JPanel;

public class CBtnPanel extends JPanel{
	private static final long serialVersionUID = -7736846899916117269L;
	ArrayList<CircleBtn> cBtns = new ArrayList<CircleBtn>();
	
	public CBtnPanel(){
		super();
	}
	public CircleBtn getCBtn(int index){
		return cBtns.get(index);
	}
	public void addBtn(CircleBtn cb){
		cBtns.add(cb);
	}
	public void clrBtns(){
		cBtns.clear();
	}
}
