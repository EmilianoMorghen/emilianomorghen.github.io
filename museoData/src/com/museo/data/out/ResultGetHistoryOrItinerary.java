//Realizzato da Berbeglia Marco & Caua Alex & Midolo Kevin
package com.museo.data.out;

import com.museo.data.HistoryOrItinerary;
import com.museo.data.ResultVO;

public class ResultGetHistoryOrItinerary extends ResultVO{
	
	private HistoryOrItinerary lista;

	public HistoryOrItinerary getLista() {
		return lista;
	}

	public void setLista(HistoryOrItinerary lista) {
		this.lista = lista;
	}

	
}
