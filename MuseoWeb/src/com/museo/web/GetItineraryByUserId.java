package com.museo.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.museo.data.in.InputUserId;
import com.museo.data.out.ResultGetHistoryOrItinerary;
import com.museo.db.Facade;

@WebServlet("/GetItinerary")
public class GetItineraryByUserId extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(Gson gson, HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputUserId input = parseJsonParamOrFailWith500(gson, InputUserId.class, request, response);
		if (input == null)
			return;
		
		Facade facade = new Facade();
		
		ResultGetHistoryOrItinerary res = facade.getItinerary(input);
		
		respondWithJsonOrFailWith500(gson, res, response);
	}
       
    

}
