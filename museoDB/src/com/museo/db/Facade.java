package com.museo.db;

import com.museo.data.in.InputBeaconId;
import com.museo.data.out.ResultGetItemByBeacon;

public class Facade {
	
	//Realizzata da Alessio Scoccia
	public ResultGetItemByBeacon getItemByBeacon(InputBeaconId input){
		Service s = new Service();
		return s.getItemByBeacon(input);
	}
	
}
