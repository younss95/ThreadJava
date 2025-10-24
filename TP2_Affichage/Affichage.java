
import java.lang.String;


/*

class Exclusion{};
public class Affichage extends Thread{
    String texte;

    static Exclusion exclusionMutuelle = new Exclusion();

    public Affichage (String txt){texte=txt;}

    public void run(){

        synchronized (exclusionMutuelle) { //section critique
            for (int i=0; i<texte.length(); i++){
                System.out.print(texte.charAt(i));
                try {sleep(100);} catch(InterruptedException e){};
            }
        }
    }
}

*/

class Affichage extends Thread {
    private String texte;
    private SemaphoreBinaire sem;

    public Affichage(String txt, SemaphoreBinaire s) {
        texte = txt;
        sem = s;
    }

    public void run() {
        sem.syncWait(); // entrée section critique
        System.out.println("j'entre en section critique");
        for (int i = 0; i < texte.length(); i++) {
            System.out.print(texte.charAt(i));
            try { sleep(100); } catch (InterruptedException e) {}
        }
        System.out.println("\nje sors de section critique");
        sem.syncSignal(); // sortie section critique
    }
}
