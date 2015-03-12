package com.museo.data;

public class Item {
	private double ID;
	private double cod_sala;
	private double ID_beacon;
	private char denominazione;
	private int anno_produzione;
	private char descrizione;
	
	public double getID() {
		return ID;
	}
	public void setID(double iD) {
		ID = iD;
	}
	public double getCod_sala() {
		return cod_sala;
	}
	public void setCod_sala(double cod_sala) {
		this.cod_sala = cod_sala;
	}
	public double getID_beacon() {
		return ID_beacon;
	}
	public void setID_beacon(double iD_beacon) {
		ID_beacon = iD_beacon;
	}
	public char getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(char denominazione) {
		this.denominazione = denominazione;
	}
	public int getAnno_produzione() {
		return anno_produzione;
	}
	public void setAnno_produzione(int anno_produzione) {
		this.anno_produzione = anno_produzione;
	}
	public char getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(char descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
