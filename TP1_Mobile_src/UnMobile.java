import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable {
	int saLargeur, saHauteur, sonDebDessin;
	final int sonPas = 10, sonTemps = 50, sonCote = 40;
	boolean enMarche = true; // <-- pour contrôler le mouvement

	UnMobile(int telleLargeur, int telleHauteur) {
		super();
		saLargeur = telleLargeur;
		saHauteur = telleHauteur;
		setSize(telleLargeur, telleHauteur);
	}

	public void run() {
		while (true) {
			if (enMarche) { // seulement si actif
				// Aller de gauche à droite
				for (sonDebDessin = 0; sonDebDessin < saLargeur - sonPas; sonDebDessin += sonPas) {
					if (!enMarche) break;
					repaint();
					try { Thread.sleep(sonTemps); }
					catch (InterruptedException e) { e.printStackTrace(); }
				}

				// Retour
				for (sonDebDessin = saLargeur - sonCote; sonDebDessin >= 0; sonDebDessin -= sonPas) {
					if (!enMarche) break;
					repaint();
					try { Thread.sleep(sonTemps); }
					catch (InterruptedException e) { e.printStackTrace(); }
				}
			} else {
				try { Thread.sleep(sonTemps); }
				catch (InterruptedException e) { e.printStackTrace(); }
			}
		}
	}

	public void paintComponent(Graphics telCG) {
		super.paintComponent(telCG);
		telCG.fillRect(sonDebDessin, saHauteur / 2, sonCote, sonCote);
	}

	public void toggle() { // permet d’arrêter / relancer
		enMarche = !enMarche;
	}
}
