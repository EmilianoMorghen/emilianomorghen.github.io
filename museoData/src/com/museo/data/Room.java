package com.museo.data;

public class Room {

	private int id;
	private String denominazione;
	private String descrizione;
	
	public Room(int id, String denominazione, String descrizione) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.descrizione = descrizione;
	}
	
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
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
