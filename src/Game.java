
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Game extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	JLabel info;
	final JLabel presentation;
	final JLabel partie;
	final JLabel finalisation;
	final JProgressBar progress1;
	final JProgressBar progress2;
	final JProgressBar progress3;
	final JProgressBar progress4;
	final JButton button;
	final JButton continuer;
	Color cFond = Color.decode("#2980b9");
	Color cProgress = Color.decode("#e67e22");
	Color cButton = Color.decode("#ecf0f1");

	public Game() {

		// Paramètres de la page
		this.setLayout(new GridLayout(10, 1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setBackground(cFond);

		// Texte Info
		this.info = new JLabel(
				"<html><body><span style='font-size: 15;color:#2c3e50'>Pour visionner les photos leak de Lise cliquez sur Go !</span></body></html>");
		this.info.setHorizontalAlignment(JLabel.CENTER);
		this.add(this.info);

		// Texte du haut
		this.presentation = new JLabel();
		this.presentation.setText("");
		this.presentation.setHorizontalAlignment(JLabel.CENTER);
		this.add(this.presentation);

		// Première progress Bar
		this.progress1 = new JProgressBar();
		this.progress1.setVisible(false);
		this.progress1.setForeground(cProgress);
		this.add(progress1);

		// Texte du milieu
		this.partie = new JLabel();
		this.partie.setText("partie 1/5");
		this.partie.setHorizontalAlignment(JLabel.CENTER);
		this.partie.setVisible(false);
		this.add(this.partie);

		// Seconde progress Bar
		this.progress2 = new JProgressBar();
		this.progress2.setVisible(false);
		this.progress2.setForeground(cProgress);
		this.add(progress2);

		// Texte du bas
		this.finalisation = new JLabel();
		this.finalisation.setText("Finalisation du chargement");
		this.finalisation.setHorizontalAlignment(JLabel.CENTER);
		this.finalisation.setVisible(false);

		this.add(this.finalisation);

		// Troisème progress Bar
		this.progress3 = new JProgressBar();
		this.progress3.setVisible(false);
		this.progress3.setForeground(cProgress);
		this.add(progress3);

		// boutton pour continuer
		this.continuer = new JButton("continuer");
		continuer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deroulement2();
			}
		});
		this.continuer.setVisible(false);
		this.add(this.continuer);

		// quatrième progress Bar
		this.progress4 = new JProgressBar();
		this.progress4.setVisible(false);
		this.progress4.setForeground(cProgress);
		this.add(progress4);

		// boutton de lancement
		this.button = new JButton("Go !");
		this.button.setBackground(cButton);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deroulement();
			}
		});
		this.add(button);
	}

	public void deroulement() {

		new Thread(new Runnable() {

			@Override
			public void run() {

				presentation.setText("Attendez quelque temps afin de procéder au chargement");

				progress1.setVisible(true);
				button.setEnabled(false);
				avanceBar(progress1, 300);
				avanceBar(progress1, 100);

				partie.setVisible(true);
				progress2.setVisible(true);
				avanceBar(progress2, 10);
				partie.setText("partie 2/5");
				avanceBar(progress2, 10);
				partie.setText("partie 3/5");
				avanceBar(progress2, 10);
				partie.setText("partie 4/5");
				avanceBar(progress2, 50);
				partie.setText("partie 5/52");
				avanceBar(progress2, 30);
				partie.setText("partie 6/52");
				avanceBar(progress2, 50);
				partie.setText("partie 7/30");
				avanceBar(progress2, 50);
				partie.setText("partie 15/15");
				avanceBar(progress2, 70);

				finalisation.setVisible(true);
				progress3.setVisible(true);
				avanceBar(progress3, 35);

				continuer.setVisible(true);

			}
		}).start();

	}

	public void deroulement2() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				continuer.setEnabled(false);
				progress4.setVisible(true);
				avanceBar2(progress4, 200);
				fin();
			}
		}).start();

	}

	public static void avanceBar(JProgressBar barre, int vitesse) {

		for (int i = 0; i <= 100; i++) {
			final int percent = i;

			try {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						barre.setValue(percent);
					}
				});
				java.lang.Thread.sleep(vitesse);
			} catch (InterruptedException e) {
				;
			}
		}

	}

	public static void avanceBar2(JProgressBar barre, int vitesse) {

		for (int i = 0; i <= 10; i++) {
			final int percent = i;

			try {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						barre.setValue(percent * 10);
					}
				});
				java.lang.Thread.sleep(vitesse);
			} catch (InterruptedException e) {
				;
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void fin(){
		BufferedImage img = null ;
		try {
			img = ImageIO.read(new File("src/ibijau.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		info.setIcon(new ImageIcon(img));
		presentation.setText("Get Birded");
	}
}
