//Realizzato da D'Orazio Antonio e Scoccia Alessio
package com.museo.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.museo.data.in.InputNewUser;
import com.museo.data.out.ResultCreateNewUser;
import com.museo.db.Facade;

@WebServlet("/CreateNewUser")
public class CreateNewUserServlet extends BaseServlet{

	@Override
	protected void doPost(Gson gson, HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputNewUser input = parseJsonParamOrFailWith500(gson, InputNewUser.class, request, response);
		if (input == null)
			return;
		
		Facade facade = new Facade();
		ResultCreateNewUser res = facade.createNewUser(input);
		
		respondWithJsonOrFailWith500(gson, res, response);
		
	}
}
       
    


