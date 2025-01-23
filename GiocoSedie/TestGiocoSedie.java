import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author Eboigbe David
 */
public class TestGiocoSedie {
    // Logger per registrare informazioni sul gioco
    private static final Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Richiesta del numero di partecipanti
        System.out.print("Inserire il numero di partecipanti: ");
        int numPartecipanti = scanner.nextInt();

        // Verifica che il numero di partecipanti sia valido
        if (numPartecipanti <= 1) {
            System.out.println("Il numero di partecipanti deve essere maggiore di 1.");
            scanner.close();
            return;
        }

        // Il numero di sedie è sempre uno in meno del numero di partecipanti
        int numSedie = numPartecipanti - 1;
        Posto[] sedie = new Posto[numSedie];

        // Creazione degli oggetti Posto (sedie)
        for (int k = 0; k < sedie.length; k++) {
            sedie[k] = new Posto();
        }

        // Creazione e avvio del thread Display per mostrare lo stato del gioco
        Display display = new Display(sedie);
        logger.info("Avvio del display per mostrare lo stato delle sedie.");
        display.start();

        // Creazione e avvio dei partecipanti
        Partecipante[] partecipanti = new Partecipante[numPartecipanti];
        for (int i = 0; i < numPartecipanti; i++) {
            partecipanti[i] = new Partecipante(sedie, i + 1);
            logger.info("Avvio del partecipante Nome: " + partecipanti[i].getName());
            partecipanti[i].start();
        }

        // Attesa della terminazione di tutti i partecipanti
        for (Partecipante p : partecipanti) {
            try {
                p.join(); // Aspetta la fine del thread partecipante
            } catch (InterruptedException e) {
                logger.severe("Errore nel join dei thread: " + e.getMessage());
                Thread.currentThread().interrupt(); // Mantiene lo stato di interruzione
            }
        }

        // Salvataggio dei risultati in un file
        try (FileWriter writer = new FileWriter("Risultato.txt")) {
            for (Partecipante p : partecipanti) {
                writer.write(p.getRisultato() + "\n");
            }
            System.out.println("Risultati salvati in 'Risultato.txt'.");
        } catch (IOException e) {
            logger.severe("Errore nella scrittura del file: " + e.getMessage());
        }

        scanner.close();
    }
}
