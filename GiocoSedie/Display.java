class Display extends Thread {
    // Array di oggetti Posto che rappresentano le sedie del gioco.
    private Posto[] sedie;
    
    // Flag per indicare la fine del gioco.
    private boolean endgame;

    // Costruttore: riceve un array di sedie e ne crea una copia locale.
    public Display(Posto[] sedie) {
        this.sedie = sedie.clone();
    }

   
    @Override
    public void run() {
        try {
            while (!endgame) {
                sleep((int) (Math.random() * 250));

                for (int i = 0; i < sedie.length; i++) {
                    // Se la sedia è libera, stampiamo '0', altrimenti stampiamo 'X'.
                    if (sedie[i].libero()) {
                        System.out.print("0");
                    } else {
                        System.out.print("X");
                    }
                }
                System.out.println();
            }
        } catch (InterruptedException e) {
            System.out.println("Display interrotto.");
        }
    }

    // Metodo per terminare il thread.
    public void endgame() {
        this.endgame = true;
    }
}
