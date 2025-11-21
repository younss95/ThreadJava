import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;




/*

public class BAL {
    private String lettre;

    public synchronized void deposer(String l) throws InterruptedException {
        while (lettre != null) {
            wait();
        }
        lettre = l;
        System.out.println("Producteur a déposé: " + l);
        notifyAll();
    }

    public synchronized String retirer() throws InterruptedException {
        while (lettre == null) {
            wait();
        }
        String temp = lettre;
        lettre = null;
        System.out.println("Consommateur a retiré: " + temp);
        notifyAll();
        return temp;
    }
}



 */




// EXEMPLE AVEC UNE BLOCKING QUEUE

public class BAL {
    private BlockingQueue<String> queue;

    public BAL(int capacite) {
        // Initialisation de la queue avec une capacité définie
        this.queue = new ArrayBlockingQueue<>(capacite);
    }

    public boolean deposer(String l) throws InterruptedException {
        // Essaie d'ajouter l'élément à la queue, sans bloquer
        boolean success = queue.offer(l);  // Renvoie true si la lettre est ajoutée
        if (success) {
            System.out.println("Producteur a déposé: " + l);
        } else {
            System.out.println("La queue est pleine, le dépôt a échoué");
        }
        return success;
    }

    public String retirer() throws InterruptedException {
        // Tente de retirer un élément de la queue sans bloquer
        String temp = queue.poll();  // Renvoie null si la queue est vide
        if (temp != null) {
            System.out.println("Consommateur a retiré: " + temp);
        } else {
            System.out.println("La queue est vide, rien à retirer");
        }
        return temp;
    }
}
