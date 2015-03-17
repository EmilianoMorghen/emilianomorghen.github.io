package com.museo.data;

public class Room {

	private int id;
	private String denominazione;
	private String descrizione;
	private float lunghezza;
	private float altezza;
	
	

	public Room(int id, String denominazione, String descrizione, float lunghezza, float altezza) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.lunghezza = lunghezza;
		this.altezza = altezza;
	}
	public float getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(float lunghezza) {
		this.lunghezza = lunghezza;
	}

	public float getAltezza() {
		return altezza;
	}

	public void setAltezza(float altezza) {
		this.altezza = altezza;
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
