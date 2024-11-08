import java.util.Date;
class Consumer implements Runnable {
    private MessageQueue mbox;
    public Consumer(MessageQueue mbox) {
        this.mbox = mbox;
    }
    public void run() {

        Date message;
        while (true) {
            SleepUtilities.nap();
            System.out.println("Consumer veut consommer.");
// Consomme un élément de la file
            message = mbox.receive();
            if (message != null)
                System.out.println("Consumer a consommé " + message);
        }
    }
}