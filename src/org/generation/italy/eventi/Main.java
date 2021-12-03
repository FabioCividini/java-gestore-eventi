package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		//titolo dell'evento
		
		System.out.print("Inserisci l'evento: ");
		String titolo = scanner.nextLine();
		
		
		//posti totali
		
		System.out.print("Inserire i posti totali dell'evento: ");
		int postiTotali = scanner.nextInt();
		
		
		//data dell'evento
		
		System.out.print("Inserisci il giorno dell'evento: ");
        int giorno = scanner.nextInt();
  
        System.out.print("Inserisci il mese: ");
        int mese = scanner.nextInt();
        
        System.out.print("Inserisci l'anno: ");
        int anno = scanner.nextInt();
        
        LocalDate data = LocalDate.of(anno, mese, giorno);
        System.out.println("La data dell'evento è: " + data.toString());
        
        
		
		try {
			
			Eventi evento = new Eventi(titolo, data, postiTotali);
			
			String sceltaUtente;
			boolean esci = false;

			System.out.println("Vuoi partecipare all'evento? (s/n) ");
			scanner.nextLine();
			
			do {
				
				
				//l'utente sceglie se partecipare
				
				sceltaUtente = scanner.nextLine();
				if(sceltaUtente.equals("s")) {
					esci = true;
				}else if (sceltaUtente.equals("n")){
					System.out.println("Programma finito.");
				}else {
					System.out.println("Inserire s/n");
				}
				

			} while (esci == false);
			
			
			//posti da prenotare
			
			System.out.println("Quanti posti vuoi prenotare? ");
	        int numPrenotazioni = scanner.nextInt(); 
	        
	        for(int i = 0; i < numPrenotazioni; i++) {
	        	evento.prenota();
	        }
	        
	        System.out.println("Prenotazioni: " + numPrenotazioni + " posti - " + " Posti disponibili: " + (postiTotali - numPrenotazioni) + " posti");
	        
	        
	        //disdette
	        
	        boolean stop = false;
	        
	        System.out.println("Vuoi disdire dei posti? (s/n) ");
			scanner.nextLine();
			
			do {
				
				//l'utente sceglie se disdire dei posti
				
				sceltaUtente = scanner.nextLine();
				if(sceltaUtente.equals("s")) {
					stop = true;
					
					//posti da disdire
					
					System.out.println("Quanti posti vuoi disdire? ");
			        int numDisdette = scanner.nextInt(); 
			        
			        for(int i = 0; i < numDisdette; i++) {
			        	evento.disdici();
			        }
					
			        int postiPrenotati = numPrenotazioni - numDisdette;
			        int postiDisponibili = postiTotali - postiPrenotati;
			        System.out.println("Prenotazioni: " + postiPrenotati + " posti - " + " Posti disponibili: " + postiDisponibili + " posti");
			        
			        
				}else if (sceltaUtente.equals("n")){
					System.out.println("Prenotazioni senza disdette");
					stop = true;
					System.out.println("Prenotazioni: " + numPrenotazioni + " posti - " + " Posti disponibili: " + (postiTotali - numPrenotazioni) + " posti");
				}else {
					System.out.println("Inserire s/n");
				}
				
				
			} while (stop == false);

			
		} catch (Exception e){
			System.out.println("Errore: " + e.getMessage());
		}
        
        
        
        scanner.close();
	}

}
