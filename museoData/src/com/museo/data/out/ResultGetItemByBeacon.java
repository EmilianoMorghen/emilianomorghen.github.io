package com.museo.data.out;

import java.util.List;

import com.museo.data.Item;
import com.museo.data.ResultVO;

public class ResultGetItemByBeacon extends ResultVO{
	private Item item;
	List<Item> lista;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public void setResult(List<Item> lista) {
		this.lista = lista;
		
	}
	
	
}
