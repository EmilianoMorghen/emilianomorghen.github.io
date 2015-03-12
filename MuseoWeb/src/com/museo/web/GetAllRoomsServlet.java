package com.museo.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.museo.data.out.ResultGetAllRooms;
import com.museo.data.out.ResultGetTag;
import com.museo.db.Facade;

// Questa è la vera e propria servlet che andrò a richiamare direttamente dal browser.

@WebServlet("/GetAllRooms")	// In questa riga specifico come accedere a questa servlet dal browser web
public class GetAllRoomsServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	public GetAllRoomsServlet(){
		super();
	}
	
	@Override
	protected void doPost(Gson gson, javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws IOException {
		Facade facade = new Facade();
		
		ResultGetAllRooms res = facade.getAllRooms();
		respondWithJsonOrFailWith500(gson, res, response);
		
	}
}