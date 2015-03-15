package com.museo.data.in;

import java.util.ArrayList;
import java.util.List;

import com.museo.data.Tag;

public class InputTagsId {
	private List<Tag> listTags = new ArrayList<Tag>();

	public List<Tag> getListTags() {
		return listTags;
	}

	public void setListTags(List<Tag> listTags) {
		this.listTags = listTags;
	}
	
	public int getTagId(int index){
		return listTags.get(index).getId();
	}
}
