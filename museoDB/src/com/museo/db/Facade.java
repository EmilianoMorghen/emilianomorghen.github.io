package com.museo.db;

import com.museo.data.in.InputBeaconId;
import com.museo.data.out.ResultGetItemByBeacon;

public class Facade {
	
	public ResultGetItemByBeacon getItemByBeacon(InputBeaconId input){
		Service s = new Service();
		return s.getItemByBeacon(input);
	}
	
}
