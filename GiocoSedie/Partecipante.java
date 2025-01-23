
class Partecipante extends Thread {
    private Posto[] sedie; // Array di sedie disponibili
    private int id; // Identificativo del partecipante
    private String risultato; // Risultato finale del partecipante

    public Partecipante(Posto[] sedie, int id) {
        this.sedie = sedie;
        this.id = id;
    }

   
    public String getRisultato() {
        return risultato;
    }

   
    @Override
    public void run() {
        try {
            // Simula un'attesa casuale prima di cercare una sedia
            sleep((int) (Math.random() * 1000));

            // Cerca una sedia libera
            for (int i = 0; i < sedie.length; i++) {
                if (sedie[i].occupa(this)) { // Se la sedia è disponibile, la occupa
                    risultato = "Partecipante " + id + " si è seduto sul posto " + i;
                    System.out.println(risultato);
                    return; // Il thread termina dopo aver occupato una sedia
                }
            }

            // Se nessuna sedia è disponibile, il partecipante perde
            risultato = "Partecipante " + id + " ha perso.";
            System.out.println(risultato);
        } catch (InterruptedException e) {
            // Gestione dell'interruzione del thread
            System.out.println("Partecipante " + id + " è stato interrotto.");
            Thread.currentThread().interrupt(); // Mantiene lo stato di interruzione
        }
    }
}
