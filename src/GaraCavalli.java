import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;

/**
 * Classe principale del programma di corsa cavalli
 */
public class GaraCavalli {
    /**
     * File dove salvare i risultati
     */
    public static File fileOutput;
    /**
     * Nome del cavallo arrivato primo
     */
    public static String primo = "";

    /**
     * Avvio del programma
     */
    public static void main(String[] arg) {
        Scanner tastiera = new Scanner(System.in);
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileOutput = chooser.getSelectedFile();
            System.out.println("Hai scelto: " + fileOutput.getAbsolutePath());
        } else {
            System.out.println("Nessun file selezionato. Esco.");
            return;
        }
        System.out.println("Quanta distanza dovranno percorrere i cavalli?");
        int len = tastiera.nextInt();
        tastiera.nextLine();
        System.out.println("Inserisci quantità cavalli (max 5)");
        int quantita = tastiera.nextInt();
        tastiera.nextLine();
        String[] nome_cavalli = new String[quantita];
        int[] lentezza = new int[quantita];
        for (int i = 0; i < quantita; i++) {
            System.out.println("Inserisci nome cavallo " + (i + 1) + ":");
            nome_cavalli[i] = tastiera.nextLine();
            System.out.println("Inserisci lentezza cavallo " + (i + 1) + ":");
            lentezza[i] = tastiera.nextInt();
            tastiera.nextLine();
        }
        ArrayList<CorsaCavalli> corsaCavalli = new ArrayList<>();
        for (int i = 0; i < quantita; i++) {
            CorsaCavalli c = new CorsaCavalli(len, nome_cavalli[i], lentezza[i]);
            corsaCavalli.add(c);
            c.start();
        }

        // Azzoppa un cavallo casuale
        azzoppaCavallo(corsaCavalli);

        for (int i = 0; i < 100; i++) {
            System.out.println((i + 1) + " - Sono sveglio");
        }
        tastiera.close();
    }

    /**
     * Azzoppa un cavallo casuale terminando il suo thread
     */
    public static void azzoppaCavallo(ArrayList<CorsaCavalli> corsaCavalli) {
        int indice = (int) (Math.random() * corsaCavalli.size());
        CorsaCavalli cavalloAzzoppato = corsaCavalli.get(indice);
        cavalloAzzoppato.interrupt();
        System.out.println(cavalloAzzoppato.getNomeCavallo() + " è stato azzoppato");
        try (FileWriter fw = new FileWriter(fileOutput, true)) {
            fw.write(cavalloAzzoppato.getNomeCavallo() + " è stato azzoppato\n");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura nel file.");
        }

    }

    /**
     * Restituisce il nome del cavallo arrivato primo
     */
    public static String getPrimo() {
        return primo;
    }

    /**
     * Imposta il nome del cavallo arrivato primo
     */
    public static void setPrimo(String cavallo) {
        primo = cavallo;
    }
}

/**
 * Thread che rappresenta un cavallo in corsa
 */
class CorsaCavalli extends Thread {
    private final int metri;
    private final String nomeCavallo;
    private final int lentezza;

    /**
     * Costruttore cavallo
     */
    public CorsaCavalli(int len, String nome, int lentezza) {
        this.metri = len;
        this.nomeCavallo = nome;
        this.lentezza = lentezza;
    }

    /**
     * Restituisce il nome del cavallo
     */
    public String getNomeCavallo() {
        return nomeCavallo;
    }

    /**
     * Esecuzione della corsa del cavallo
     */
    @Override
    public void run() {
        setName("Thread cavallo - " + nomeCavallo);
        System.out.println(getName() + " partito!");
        try (FileWriter fw = new FileWriter(GaraCavalli.fileOutput, true)) {
            fw.write(getName() + " partito\n");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura nel file.");
        }
        for (int i = 0; i <= metri; i += lentezza) {
            if (Thread.interrupted()) {
                return;
            }
            System.out.println(nomeCavallo + " ha percorso " + i + " metri");
            try (FileWriter fw = new FileWriter(GaraCavalli.fileOutput, true)) {
                fw.write(nomeCavallo + " ha percorso " + i + " metri\n");
            } catch (IOException e) {
                System.out.println("Errore durante la scrittura nel file.");
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(nomeCavallo + " si è fermato a " + i + " metri");
                try (FileWriter fw = new FileWriter(GaraCavalli.fileOutput, true)) {
                    fw.write(nomeCavallo + " si è fermato a " + i + " metri\n");
                } catch (IOException ex) {
                    System.out.println("Errore durante la scrittura nel file.");
                }
                return;
            }
        }
        if (GaraCavalli.getPrimo().isEmpty()) {
            GaraCavalli.setPrimo(nomeCavallo);
            System.out.println(nomeCavallo + " è arrivato primo!");
            try (FileWriter fw = new FileWriter(GaraCavalli.fileOutput, true)) {
                fw.write(nomeCavallo + " è arrivato primo!\n");
            } catch (IOException e) {
                System.out.println("Errore durante la scrittura nel file.");
            }
        } else {
            System.out.println(nomeCavallo + " è arrivato dopo \n");
            try (FileWriter fw = new FileWriter(GaraCavalli.fileOutput, true)) {
                fw.write(nomeCavallo + " è arrivato dopo " + "\n");
            } catch (IOException e) {
                System.out.println("Errore durante la scrittura nel file.");
            }
        }
    }
}