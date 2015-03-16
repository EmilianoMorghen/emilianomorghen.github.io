//Realizzata da Alessio Scoccia
package com.museo.data;

public class Item {

	private int id;
	private int cod_beacon;
	private String denominazione;
	private int anno_prod;
	private String descrizione;
	private String url_esterno;

	
	public Item(int id, int cod_beacon, String denominazione,
			int anno_prod, String descrizione, String url_esterno) {
		super();
		this.id = id;
		this.cod_beacon = cod_beacon;
		this.denominazione = denominazione;
		this.anno_prod = anno_prod;
		this.descrizione = descrizione;
		this.url_esterno = url_esterno;
	}
	public Item(int id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCod_beacon() {
		return cod_beacon;
	}
	public void setCod_beacon(int cod_beacon) {
		this.cod_beacon = cod_beacon;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public int getAnno_prod() {
		return anno_prod;
	}
	public void setAnno_prod(int anno_prod) {
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
