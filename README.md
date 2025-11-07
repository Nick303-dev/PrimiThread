
# CorsaCavalli (Programma Multithreading in Java)

Questo progetto simula una corsa tra cavalli utilizzando il multithreading in Java.  
Ogni cavallo è gestito come un thread separato, con velocità diverse.  
Durante la corsa, i progressi vengono mostrati a schermo **e salvati in un file selezionato dall’utente tramite JFileChooser**.

---

##  Descrizione
Il progetto ha lo scopo di:
- l'uso del **multi-threading** in Java
- determinare il **primo** cavallo arrivato
- l’uso di **JFileChooser** per far scegliere all’utente un file su cui salvare i risultati
- la scrittura su file tramite **FileWriter**

---


##  Requisiti per l'Esecuzione
- Java **openJDK 23**
- Un ambiente di sviluppo (ad es. IntelliJ, Eclipse, NetBeans)

---

## Installazione e Avvio

1. Clona o scarica il progetto:
``bash
git clone https://github.com/tuo-username/corsa-cavalli.git
cd corsa-cavalli
``
---

## funzionamento

-   All’avvio si apre una finestra **JFileChooser** → scegli un file **esistente** (es. `output.txt`)
    
-   Inserisci:
    
    -   distanza totale della corsa
        
    -   numero di cavalli (max 5)
        
    -   nome e lentezza di ciascun cavallo
        
-   La corsa parte:
    
    -   i progressi vengono stampati a schermo
        
    -   **ogni passo viene registrato nel file selezionato**
    
``` bash 
  Thread cavallo - Zeus partito!
  
	Zeus ha percorso 0 metri

	Zeus ha percorso 5 metri

	Zeus ha percorso 10 metri

	Zeus è arrivato primo!
```
## licenza

MIT License

---
## credits
**creato da Nicolas Cassetta**
