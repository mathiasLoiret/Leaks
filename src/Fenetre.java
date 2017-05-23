
import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	public Photo pho;
	public Game gam;
	public boolean test = false;

	private static final long serialVersionUID = 8164118974463460991L;
	
	public Fenetre() {
		this.setSize(500, 500);
		this.setResizable(false);
		this.setTitle("Endless Quest");
		pho = new Photo();
		gam = new Game();
		this.add(gam);
	}

}
