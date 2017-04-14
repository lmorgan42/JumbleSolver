import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class SpcBtn extends CircleBtn{
	@Override
	protected void setIco(){
		if(circle){
			try {
				this.setIcon(new ImageIcon(Resizer.getScaledImage(ImageIO.read(CircleBtn.class.getResourceAsStream("/res/space.png")), 20, 20)));
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
}
