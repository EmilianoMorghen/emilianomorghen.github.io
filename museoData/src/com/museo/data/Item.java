//Realizzata da Alessio Scoccia
package com.museo.data;

public class Item {

	private int id;
	private Integer cod_beacon;
	private String denominazione;
	private String anno_prod;
	private String descrizione;
	private String url_esterno;

	
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
	public Integer getCod_beacon() {
		return cod_beacon;
	}
	public void setCod_beacon(Integer cod_beacon) {
		this.cod_beacon = cod_beacon;
	}
=======
	
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
>>>>>>> 6d5470eb3a29f5c592bdcda212d542480d4aa308
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
