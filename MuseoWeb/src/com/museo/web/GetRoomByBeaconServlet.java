//Copyright Alexandru Caua 2015

package com.museo.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.museo.data.in.InputBeaconId;
import com.museo.data.out.ResultGetRoomByBeacon;
import com.museo.db.Facade;

/**
 * Servlet implementation class GetRoomByBeaconServlet
 */
@WebServlet("/GetRoomByBeacon")
public class GetRoomByBeaconServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(Gson gson, HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		InputBeaconId input = parseJsonParamOrFailWith500(gson, InputBeaconId.class, request, response);
		if (input == null)
			return;
		
		Facade facade = new Facade();
		ResultGetRoomByBeacon res = facade.getRoomByBeacon(input);
		
		respondWithJsonOrFailWith500(gson, res, response);
		
		
	}
       
    
}
