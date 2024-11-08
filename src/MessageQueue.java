import java.util.LinkedList;
import java.util.Queue;
import java.util.Date;
class MessageQueue {
    private Queue<Date> queue = new LinkedList<>();
    private final int capacity = 10; // capacité maximale de la file
    // Envoie un message dans la file (utilisé par le producteur)
    public synchronized void send(Date message) {
        while (queue.size() == capacity) {
            try {
                System.out.println("File pleine. Le producteur attend.");
                wait(); // Attente si la file est pleine
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        queue.add(message);
        System.out.println("Message envoyé : " + message);
        System.out.println("Capacité actuelle de la file : " + queue.size() + "/" + capacity);
        notifyAll(); // Notifie les threads en attente
    }

    // Reçoit un message de la file (utilisé par le consommateur)
    public synchronized Date receive() {
        while (queue.isEmpty()) {
            try {
                System.out.println("File vide. Le consommateur attend.");
                wait(); // Attente si la file est vide
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Date message = queue.poll();
        System.out.println("Capacité actuelle de la file : " + queue.size() + "/" + capacity);
        notifyAll(); // Notifie les threads en attente
        return message;
    }
}