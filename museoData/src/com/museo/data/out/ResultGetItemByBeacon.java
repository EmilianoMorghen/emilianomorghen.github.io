package com.museo.data.out;

import com.museo.data.Item;
import com.museo.data.ResultVO;

public class ResultGetItemByBeacon extends ResultVO{
	private Item item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
