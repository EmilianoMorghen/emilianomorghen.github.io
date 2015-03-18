package com.museo.web;



import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;



import com.museo.util.JsonByteArraySerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public abstract class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static final String JSON_REQUEST_PARAM = "req";
	protected static String callBackJavaScripMethodName = null;
	
	protected static GsonBuilder gsonBuilder = new GsonBuilder();
	
	{
		//gsonBuilder.registerTypeAdapter(Date.class, new JsonDateSerializer(JsonDateSerializer.YYYY_MM_DD_DATE_FORMAT));
		//gsonBuilder.registerTypeAdapter(Date.class, new JsonDateDeserializer(JsonDateDeserializer.YYYY_MM_DD_DATE_FORMAT));
		gsonBuilder.registerTypeAdapter(byte[].class, new JsonByteArraySerializer());
	}
	
	@Resource
    UserTransaction tx;

	private static Charset utf8Charset  = Charset.forName("UTF-8");
	
	public BaseServlet() {
	}
	
	protected static <T> T parseJsonParamOrFailWith500(Gson gson, Class<T> clazz, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String jsonReq = new String(request.getParameter(JSON_REQUEST_PARAM).getBytes(), utf8Charset);
			callBackJavaScripMethodName = request.getParameter("callback");
			System.out.println("***** JSON ***** "+jsonReq);
			return gson.fromJson(jsonReq, clazz);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(500, e.getMessage());
			return null;
		}
	}
	
	protected static void respondWithJsonOrFailWith500(Gson gson, Object res, HttpServletResponse response) throws IOException {
		if (callBackJavaScripMethodName != null) {
			String jsonPoutput = callBackJavaScripMethodName + "("
					+ gson.toJson(res) + ");";
			response.setContentType("text/javascript");
			response.getWriter().println(jsonPoutput);
		}
		else{
			response.setContentType("application/json; charset=UTF-8");
			try {
				gson.toJson(res, response.getWriter());
			} catch (JsonIOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendError(500, e.getMessage());
			}
		}
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: Togliere dopo i test, lato android viene invocato già correttamente
		if (true) {
			doPost(request, response);
			return;
		}
		
		if ("capgemini".equals(request.getHeader("test-machine")))
			doPost(request, response);
		else
			response.sendError(403, "Use POST");
	}

	protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = gsonBuilder.create();
		doPost(gson, request, response);
	}

	protected abstract void doPost(Gson gson, HttpServletRequest request, HttpServletResponse response) throws IOException;
	
}
