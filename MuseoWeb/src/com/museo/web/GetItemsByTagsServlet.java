//Realizzato da Emiliano Morghen
package com.museo.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.museo.data.in.InputTagsId;
import com.museo.data.out.ResultGetItemsByTags;
import com.museo.db.Facade;

@WebServlet("/GetItemByTags")
public class GetItemsByTagsServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(Gson gson, HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputTagsId input = parseJsonParamOrFailWith500(gson, InputTagsId.class, request, response);
		if (input == null)
			return;
		
		Facade facade = new Facade();
		
		ResultGetItemsByTags res = facade.getItemsByTags(input);
		
		respondWithJsonOrFailWith500(gson, res, response);
	}
}
