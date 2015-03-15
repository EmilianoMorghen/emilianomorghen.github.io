//Realizzato da D'Orazio Antonio e Scoccia Alessio
package com.museo.data.out;

import com.museo.data.ResultVO;
import com.museo.data.User;

public class ResultCreateNewUser extends ResultVO {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} 
	
	
}
