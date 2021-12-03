package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Eventi {
	
	
	
	//attributi
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	
	
	
	//costruttore
	public Eventi(String titolo, LocalDate data, int postiTotali) throws Exception{
		
		if(data.isAfter(LocalDate.now())) {
			this.data = data;
		} else {
			throw new Exception("Data dell'evento già passata");
		}
		
		if(postiTotali > 0) {
			this.postiTotali = postiTotali;
		} else {
			throw new Exception("Numero posti totali deve essere positivo");
		}
		
		this.titolo = titolo;
		this.postiPrenotati = 0;
	}

	
	
	//getter and setter
	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public int getPostiPrenotati() {
		return postiPrenotati;
	}


	public void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}


	public String getTitolo() {
		return titolo;
	}


	public int getPostiTotali() {
		return postiTotali;
	}
	
	
	
	//metodi
	
	
	
	//metodo di prenotazione
	public void prenota() throws Exception{
	
		if(data.isBefore(LocalDate.now())) {
			throw new Exception("Data dell'evento già passata");
		} else if (postiPrenotati == postiTotali) {
			throw new Exception("Non ci sono posti prenotabili");
		} else {
			postiPrenotati++;
		}
	}
	
	
	
	//metodi disidici
	public void disdici() throws Exception{
		
		if(data.isBefore(LocalDate.now())) {
			throw new Exception("Data dell'evento già passata");
		} else if (postiPrenotati == 0) {
			throw new Exception("Non ci sono prenotazioni");
		} else {
			postiPrenotati--;
		}
	}



	@Override
	//metodo che restituisce una stringa
	public String toString() {
		
		String dataFormattata;
		DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataFormattata = this.data.format(dataFormat);
		return dataFormattata + " - " + this.titolo;
	}
	
	
	
	
	
	
	
}
