import java.util.Date;
class Producer implements Runnable {
    private MessageQueue mbox;
    public Producer(MessageQueue mbox) {
        this.mbox = mbox;
    }
    public void run() {
        Date message;
        while (true) {
            SleepUtilities.nap();
            message = new Date();
            System.out.println("Producer produit " + message);
// Produit un élément et l'ajoute dans la file
            mbox.send(message);
        }
    }
}