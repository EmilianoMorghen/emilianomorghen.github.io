package com.museo.data.out;

import java.util.List;

import com.museo.data.Tag;
import com.museo.data.ResultVO;

public class ResultGetTag extends ResultVO{

	List<Tag> result;

	public List<Tag> getResult() {
		return result;
	}

	public void setResult(List<Tag> result) {
		this.result = result;
	}
}
