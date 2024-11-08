public class Factory {
    public Factory() {
        // Création du tampon partagé avec capacité personnalisée
        MessageQueue mailBox = new MessageQueue();

        // Création de plusieurs producteurs et consommateurs
        for (int i = 0; i < 3; i++) { // Trois producteurs
            new Thread(new Producer(mailBox)).start();
        }
        for (int i = 0; i < 3; i++) { // Deux consommateurs
            new Thread(new Consumer(mailBox)).start();
        }
    }

    public static void main(String[] args) {
        new Factory();
    }
}
