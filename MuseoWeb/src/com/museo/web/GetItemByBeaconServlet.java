package com.museo.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.museo.data.in.InputBeaconId;
import com.museo.data.out.ResultGetItemByBeacon;
import com.museo.data.out.ResultTestBeacon;
import com.museo.db.Facade;

/**
 * Servlet implementation class GetItemByBeaconServlet
 */
@WebServlet("/GetItemByBeacon")
public class GetItemByBeaconServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(Gson gson, HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputBeaconId input = parseJsonParamOrFailWith500(gson, InputBeaconId.class, request, response);
		if (input == null)
			return;
		
		Facade facade = new Facade();
		
		ResultTestBeacon res = facade.getItemByBeacon(input);
		
		respondWithJsonOrFailWith500(gson, res, response);
	}
       
    

}
