package com.museo.db;

import com.museo.data.in.InputBeaconId;
import com.museo.data.in.InputNewUser;
import com.museo.data.in.InputRoomId;
import com.museo.data.in.InputUserId;
import com.museo.data.out.ResultCreateNewUser;
import com.museo.data.out.ResultGetAllRooms;
import com.museo.data.out.ResultGetHistoryOrItinerary;
import com.museo.data.out.ResultGetItemByBeacon;
import com.museo.data.out.ResultGetItemsByCodiceSala;
import com.museo.data.out.ResultGetRoomByBeacon;
import com.museo.data.out.ResultGetTag;

public class Facade {
	
	//Realizzata da Scoccia Alessio
	public ResultGetItemByBeacon getItemByBeacon(InputBeaconId input){
		Service s = new Service();
		return s.getItemByBeacon(input);
	}
	//Realizzata da Midolo Kevin
	public ResultGetTag getAllTags(){
		Service s = new Service();
		return s.getAllTags();
	}
	//Realizzata da Berbeglia Marco
	public ResultGetAllRooms getAllRooms(){
		Service s = new Service();
		return s.getAllRooms();
	}
	//Realizzata da Caua Alexandru
	public ResultGetRoomByBeacon getRoomByBeacon(InputBeaconId input){
		Service s = new Service();
		return s.getRoomByBeacon(input);
	}
	//Realizzata da D'Orazio Antonio
	public ResultGetItemsByCodiceSala getItemsByCodiceSala(InputRoomId input){
		Service s = new Service();
		return s.getItemsByCodiceSala(input);
	}
	//Realizzata da Berbeglia Marco, Caua Alexandru, Midolo Kevin
	public ResultGetHistoryOrItinerary getHistory(InputUserId input){
		Service s = new Service();
		return s.getHistory(input);
	}
	//Realizzata da Berbeglia Marco, Caua Alexandru, Midolo Kevin
	public ResultGetHistoryOrItinerary getItinerary(InputUserId input){
		Service s = new Service();
		return s.getItinerary(input);
	}
	//Realizzata da D'Orazio Antonio, Scoccia Alessio
	public ResultCreateNewUser createNewUser(InputNewUser input){
		Service s = new Service();
		return s.createNewUser(input);
	}
}
