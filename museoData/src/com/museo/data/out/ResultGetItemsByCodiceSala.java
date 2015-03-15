package com.museo.data.out;

import java.util.List;

import com.museo.data.Item;
import com.museo.data.ResultVO;

//Realizzato da Antonio D'Orazio

public class ResultGetItemsByCodiceSala extends ResultVO{

	//Crea lista per gli oggetti1
	List<Item> items;
	

	//Restituisce la lista
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}


}
