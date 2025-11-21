public class Consommateur implements Runnable {
    private BAL bal;

    public Consommateur(BAL bal) {
        this.bal = bal;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String lettre = bal.retirer();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
