import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String nome_cavalli[] = new String[5];

        try (Scanner tastiera = new Scanner(System.in)) {
            System.out.println("quanta distanza dovranno percorrere i cavalli");
            int len= tastiera.nextInt(); //.nextLine() per leggere la riga
            tastiera.nextLine();
            for (int i = 0; i < 5 ; i++) {
                System.out.println("inserisci nome cavallo"+ i);

                nome_cavalli[i]=tastiera.nextLine();
            }
            //singolo thread
            CorsaCavalli thr1 = new CorsaCavalli(len, nome_cavalli[0]);
            CorsaCavalli thr2= new CorsaCavalli(len, nome_cavalli[1]);
            CorsaCavalli thr3 = new CorsaCavalli(len, nome_cavalli[2]);
            CorsaCavalli thr4 = new CorsaCavalli(len, nome_cavalli[3]);
            CorsaCavalli thr5 = new CorsaCavalli(len, nome_cavalli[4]);
            thr1.start();
            thr2.start();
            thr3.start();
            thr4.start();
            thr5.start();
            
            //thread padre è sveglio
            for (int i = 0; i < 100; i++) {
                System.out.println((i + 1) + " sono sveglio ");
            }
        }
    }
}

class CorsaCavalli extends Thread {
    //variabile privata
    private final int metri;
    private final String nomeCavallo;
    //costruttore
    public CorsaCavalli(int len, String nome){
        super();
        this.metri=len;
        this.nomeCavallo=nome;

    }
    @Override
    public void run() {
        setName("thread corsa cavalli");
        System.out.println(Thread.currentThread().getName());
        for (int i = metri; i >= 0; i-=5) {
            System.out.println(nomeCavallo + " ha percorso " + (metri - i) + " metri");

    }
    }
}