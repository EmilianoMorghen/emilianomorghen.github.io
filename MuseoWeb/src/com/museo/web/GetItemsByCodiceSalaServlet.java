package com.museo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.museo.data.in.InputRoomId;
import com.museo.data.out.ResultGetItemsByCodiceSala;
import com.museo.db.Facade;



	/**
	 * Servlet implementation class GetItemByBeaconServlet
	 */
	@WebServlet("/GetItemsByCodiceSala")
	public class GetItemsByCodiceSalaServlet extends BaseServlet {
		private static final long serialVersionUID = 1L;

		public GetItemsByCodiceSalaServlet(){
			super();
		}
		@Override
		protected void doPost(Gson gson, HttpServletRequest request, HttpServletResponse response) throws IOException {
			//Invia al parser l'input
			InputRoomId input = parseJsonParamOrFailWith500(gson, InputRoomId.class, request, response);
			if (input == null)
				return;
			
			Facade facade = new Facade();
			
			
			//Memorizza dentro res l'output
			ResultGetItemsByCodiceSala res = facade.getItemsByCodiceSala(input);
			
			
			//Risponde con un Json inviando res
			respondWithJsonOrFailWith500(gson, res, response);
		}
	       
	    

	}

