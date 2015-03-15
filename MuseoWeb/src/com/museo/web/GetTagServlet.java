package com.museo.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import com.museo.data.out.ResultGetTag;
import com.museo.db.Facade;
import com.google.gson.Gson;

// Questa è la vera e propria servlet che andrò a richiamare direttamente dal browser.

@WebServlet("/GetTags")	// In questa riga specifico come accedere a questa servlet dal browser web
public class GetTagServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	public GetTagServlet(){
		super();
	}
	
	@Override
	protected void doPost(Gson gson, javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws IOException {
	// Tutto quello che succede è che, una volta richiamata, la servlet crea un oggetto che accederà a un'altra classe e questa prenderà i dati direttamente dal database.
	// Dopo aver fatto tutti questi giri, i dati ottenuti vengono restituiti in formato JSON.
		Facade facade = new Facade();
		
		ResultGetTag res = facade.getAllTags();
		respondWithJsonOrFailWith500(gson, res, response);
		
	}
}
