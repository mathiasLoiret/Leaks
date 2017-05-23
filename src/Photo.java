import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Photo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Image img;
	
	public Photo(){
		BufferedImage img = null ;
		try {
			img = ImageIO.read(new File("src/ibijau.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lab = new JLabel(new ImageIcon(img));
		this.add(lab);
	}
	
	
}
