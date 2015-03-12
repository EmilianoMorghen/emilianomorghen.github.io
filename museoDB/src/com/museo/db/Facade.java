package com.museo.db;

import com.museo.db.Service;
import com.museo.data.in.InputBeaconId;
import com.museo.data.out.ResultGetItemByBeacon;
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
	
}
