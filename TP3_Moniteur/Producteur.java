public class Producteur implements Runnable {
    private BAL bal;

    public Producteur(BAL bal) {
        this.bal = bal;
    }

    @Override
    public void run() {
        int i = 1;
        try {
            while (i<5) {
                String lettre = "Lettre " + i++;
                bal.deposer(lettre);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
