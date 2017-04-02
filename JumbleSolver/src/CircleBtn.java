import java.awt.Dimension;
import java.awt.Insets;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CircleBtn extends JButton{
	private static final long serialVersionUID = -3498444475365603218L;
	private boolean circle; 
	
	public CircleBtn(){
		super();
		circle = false;
		this.setPreferredSize(new Dimension(20,20));
		setIco();
		setBorderPainted(false);
		setBorder(null);
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		
	}
	
	public boolean getCircle(){
		return circle;
	}
	
	private void setIco(){
		if(circle){
			try {
				this.setIcon(new ImageIcon(Resizer.getScaledImage(ImageIO.read(CircleBtn.class.getResourceAsStream("/res/circle.png")), 20, 20)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				this.setIcon(new ImageIcon(Resizer.getScaledImage(ImageIO.read(CircleBtn.class.getResourceAsStream("/res/empty.png")), 20, 20)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setCircle(boolean toSet){
		circle = toSet;
		setIco();
	}
	
}
