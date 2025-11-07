import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String primo="";
    public static void main(String[] args) {
        String[] nome_cavalli = new String[5];
        int[] lentezza = new int[5];
        try (Scanner tastiera = new Scanner(System.in)) {
            System.out.println("quanta distanza dovranno percorrere i cavalli");
            int len= tastiera.nextInt(); //.nextLine() per leggere la riga
            tastiera.nextLine();
            System.out.println("inserisci quantità cavalli");
            int quantità= tastiera.nextInt();
            tastiera.nextLine();

            for (int i = 0; i < 5 ; i++) {
                System.out.println("inserisci nome cavallo "+ i);

                nome_cavalli[i]=tastiera.nextLine();
                System.out.println("inserisci lentezza cavallo "+ i);
                lentezza[i] = tastiera.nextInt();
                tastiera.nextLine();
            }
            ArrayList<CorsaCavalli> corsaCavalli;
            corsaCavalli = new ArrayList<CorsaCavalli>();
            //singolo thread
            for (int i = 0; i < quantità; i++) {
               corsaCavalli.add(new CorsaCavalli(len, nome_cavalli[i], lentezza[i]));
               corsaCavalli.get(i).start();
            }




            //thread padre è sveglio
            for (int i = 0; i < 100; i++) {
                System.out.println((i + 1) + " sono sveglio ");
            }
        }
    }

    public static String getPrimo() {
        return primo;
    }

    public static void setPrimo(String cavallo) {
        primo = cavallo;
    }
}
class CorsaCavalli extends Thread {
    //variabile privata
    private final int metri;
    private final String nomeCavallo;
    private final int lentezza;
    //costruttore
    public CorsaCavalli(int len, String nome, int lentezza){
        super();
        this.metri=len;
        this.nomeCavallo=nome;
        this.lentezza=lentezza;
    }
    @Override
    public void run() {
        public void azzoppaCavallo(){
            int a= (int)(Math.random()*5);
            try{

            }
            catch (Exception){

            }
        }
        setName("thread corsa cavalli");
        System.out.println(Thread.currentThread().getName());
        for (int i = metri; i >= 0; i-=lentezza) {
            System.out.println(nomeCavallo + " ha percorso " + (metri - i) + " metri");


    }
        if (Main.getPrimo().isEmpty() && currentThread().isAlive()){
            Main.setPrimo(this.nomeCavallo);
            System.out.println(nomeCavallo + " è arrivato primo");
        }

    }
}