//Copyright Alexandru Caua 2015

package com.museo.data.out;

import com.museo.data.Room;
import com.museo.data.ResultVO;

public class ResultGetRoomByBeacon extends ResultVO {

	private Room room;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
}
