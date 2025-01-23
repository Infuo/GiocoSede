// Classe Posto: rappresenta una sedia nel gioco.
class Posto {
    // Indica se il posto è occupato o meno.
    private boolean occupato = false;

    // Metodo per verificare se il posto è libero.
    public synchronized boolean libero() {
        return !occupato;
    }

    // Metodo per occupare un posto se è libero.
    public synchronized boolean occupa(Partecipante p) {
        if (!occupato) {
            occupato = true;
            return true;
        }
        return false;
    }

    // Metodo per liberare un posto.
    public synchronized void libera() {
        occupato = false;
    }
}
