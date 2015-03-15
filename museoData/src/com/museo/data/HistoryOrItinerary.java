//Realizzato da Berbeglia Marco & Caua Alex & Midolo Kevin
package com.museo.data;

import java.util.ArrayList;
import java.util.List;

public class HistoryOrItinerary {
	private List<Item> oggetti= new ArrayList();
	
	public HistoryOrItinerary(List<Item> oggetti) {
		super();
		this.oggetti = oggetti;
	}


	public List<Item> getOggetti() {
		return oggetti;
	}

	public void setOggetti(List<Item> oggetti) {
		this.oggetti = oggetti;
	}	
	
}
