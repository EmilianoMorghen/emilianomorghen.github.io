package com.museo.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.museo.data.Item;
import com.museo.data.StatusCodes;
import com.museo.data.in.InputBeaconId;
import com.museo.data.out.ResultGetItemByBeacon;

public class Service {

	private final String SELECT_ITEM_BY_BEACON = "SELECT ID, Descrizione FROM oggetti WHERE cod_beacon=?"; // Query per prendere id oggetto che corrispondono al beacon
	
	// Realizzata da Alessio Scoccia
	public ResultGetItemByBeacon getItemByBeacon(InputBeaconId input){
		ResultGetItemByBeacon res = new ResultGetItemByBeacon();
		
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();								//Connessione al db
			preparedStatement = conn.prepareStatement(SELECT_ITEM_BY_BEACON);		//Preparo la query
			preparedStatement.setString(1,input.getIdBeacon());						//Passo parametri alla funzione 
			rs = preparedStatement.executeQuery();									//Eseguo la query
			
			Item item = null;														
			
			List<Item> lista = new ArrayList<Item>();								//Creo una lista di oggetti 
			
			while (rs.next()) {														//Ciclo tutti gli oggetti che trova 
				item = new Item(rs.getInt("ID"), rs.getString("Descrizione"));		//Prende paramentri e assegna a oggetto item
				lista.add(item);													//Riempie la lista di oggetti
			}
			res.setResult(lista);													//Manda il risultato la lista 
			res.setStatusCode(StatusCodes.OK);
			
		} catch (Exception e) {														//Gestisce errori
			res.setStatusCode(StatusCodes.GENERIC_ERROR);							//
			e.getStackTrace();														//
		}finally {																	//
			
			if (preparedStatement != null) {										//
				try {
					preparedStatement.close();										//
				} catch (SQLException e) {											//
					res.setStatusCode(StatusCodes.GENERIC_ERROR);					//
					e.getStackTrace();												//
				}
			}
 
			if (conn != null) {														//
				try {
					conn.close();													//Chiude connessione al db
				} catch (SQLException e) {											//
					res.setStatusCode(StatusCodes.GENERIC_ERROR);					//
					e.getStackTrace();												//
				}
			}

		}
		
		return res;
	}


}