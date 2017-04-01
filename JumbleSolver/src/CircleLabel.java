import javax.swing.JButton;
import javax.swing.JLabel;

public class CircleLabel extends JButton{
	boolean circle; 
	
	public CircleLabel(){
		super();
		circle = false;
	}
	
	public boolean getCircle(){
		return circle;
	}
	
	public void setCircle(boolean toSet){
		circle = toSet;
	}
	
}
