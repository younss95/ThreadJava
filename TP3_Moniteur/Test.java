public class Test {
    public static void main(String[] args) {
        BAL bal = new BAL(1);
        Thread prod = new Thread(new Producteur(bal));
        Thread cons = new Thread(new Consommateur(bal));

        prod.start();
        cons.start();
    }
}
