package com.museo.data;

// Questa classe rispecchia la tabella tag presente nel database. I valori nei campi della tabella saranno assegnati ai rispettivi attributi in una istanza di questa classe.
public class Tag {
	//Attributi
	private int id;
	private String denominazione;
	
	//Costruttore
	public Tag(int id, String denominazione) {
		super();
		this.id = id;
		this.denominazione = denominazione;
	}
	
	//Get e set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
}
