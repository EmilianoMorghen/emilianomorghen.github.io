package com.museo.db;

import com.museo.data.in.InputBeaconId;
import com.museo.data.out.ResultGetAllRooms;
import com.museo.data.out.ResultGetTag;
import com.museo.data.out.ResultTestBeacon;

public class Facade {
	
	public ResultTestBeacon getItemByBeacon(InputBeaconId input){
		Service s = new Service();
		return s.getItemByBeacon(input);
	}
	
	// Realizzato da Kevin Midolo
	public ResultGetTag getAllTags(){
		Service s = new Service();
		return s.getAllTags();
	}
	//created da Berbeglia Marco
	public ResultGetAllRooms getAllRooms(){
		Service s = new Service();
		return s.getAllRooms();
	}
	
}
