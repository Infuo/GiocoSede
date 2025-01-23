# GiocoSede

Il Gioco delle Sedie è un semplice programma Java che simula il gioco musicale.  
Ogni partecipante cerca di sedersi su una delle sedie, ma ce n'è sempre una in meno rispetto ai giocatori. Chi non trova un posto viene eliminato.

## Funzionamento

- L'utente inserisce il numero di partecipanti.
- Il gioco crea il numero di sedie necessario (uno in meno dei partecipanti).
- Ogni partecipante attende un tempo casuale prima di tentare di occupare una sedia.
- Se un partecipante trova un posto libero, lo occupa. Altrimenti, perde.
- I risultati vengono stampati a schermo e salvati in un file `Risultato.txt`.

## Struttura del Progetto

Il progetto è composto dalle seguenti classi:

### Display.java
Si occupa di visualizzare lo stato delle sedie durante il gioco. È un thread separato che monitora il gioco e aggiorna la visualizzazione.

### Partecipante.java
Rappresenta un giocatore del gioco, implementato come thread. Ogni partecipante:
- Attende un tempo casuale prima di cercare una sedia.
- Tenta di occupare una sedia libera.
- Se non trova una sedia disponibile, perde.
- Registra il risultato finale (vittoria o sconfitta).

### Posto.java
Rappresenta una sedia nel gioco. Ogni istanza di `Posto` permette di:
- Controllare se la sedia è libera.
- Occuparla in modo sincronizzato per evitare che due giocatori si siedano contemporaneamente.

### TestGiocoSedie.java
Classe principale che gestisce il gioco. Si occupa di:
- Richiedere all'utente il numero di partecipanti.
- Creare le sedie e i giocatori.
- Avviare i thread per i partecipanti e il display.
- Salvare i risultati in un file `Risultato.txt`.
