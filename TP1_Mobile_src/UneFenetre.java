import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UneFenetre extends JFrame implements ActionListener {
    UnMobile[] lesMobiles;
    JButton[] lesBoutons;
    Thread[] lesThreads;

    int nbMobiles = 2; // 🔁 Change ce nombre : 2, 3, 4, etc.
    final int LARGE_MOBILE = 300, HAUT_MOBILE = 150;

    public UneFenetre() {
        super("Mobiles multiples");

        Container cont = getContentPane();
        cont.setLayout(new GridLayout(nbMobiles, 2)); // une ligne par mobile

        // Création des tableaux
        lesMobiles = new UnMobile[nbMobiles];
        lesBoutons = new JButton[nbMobiles];
        lesThreads = new Thread[nbMobiles];

        // Boucle qui crée chaque mobile et son bouton
        for (int i = 0; i < nbMobiles; i++) {
            lesMobiles[i] = new UnMobile(LARGE_MOBILE, HAUT_MOBILE);
            lesBoutons[i] = new JButton("Start/Stop " + (i + 1));

            lesBoutons[i].addActionListener(this);

            cont.add(lesBoutons[i]);
            cont.add(lesMobiles[i]);

            lesThreads[i] = new Thread(lesMobiles[i]);
            lesThreads[i].start();
        }

        setSize(600, nbMobiles * 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < nbMobiles; i++) {
            if (e.getSource() == lesBoutons[i]) {
                lesMobiles[i].toggle();
            }
        }
    }
}
