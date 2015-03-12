package com.museo.data;

public class Item {
	private double id;
	private double cod_beacon;
	private String denominazione;
	private String anno_prod;
	private String descrizione;
	private String url_esterno;
	
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public double getCod_beacon() {
		return cod_beacon;
	}
	public void setCod_beacon(double cod_beacon) {
		this.cod_beacon = cod_beacon;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getAnno_prod() {
		return anno_prod;
	}
	public void setAnno_prod(String anno_prod) {
		this.anno_prod = anno_prod;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getUrl_esterno() {
		return url_esterno;
	}
	public void setUrl_esterno(String url_esterno) {
		this.url_esterno = url_esterno;
	}
	
	
}
