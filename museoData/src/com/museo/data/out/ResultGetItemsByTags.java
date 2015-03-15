package com.museo.data.out;

import java.util.List;

import com.museo.data.Item;
import com.museo.data.ResultVO;

public class ResultGetItemsByTags extends ResultVO{
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
