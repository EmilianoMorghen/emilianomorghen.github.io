//Class created by Berbeglia Marco
package com.museo.data.out;

import java.util.List;

import com.museo.data.ResultVO;
import com.museo.data.Room;

public class ResultGetAllRooms extends ResultVO{

	public List<Room> rooms;

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	


	
}
