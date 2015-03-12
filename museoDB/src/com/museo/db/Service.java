package com.museo.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.museo.data.Tag;
import com.museo.db.ConnectionManager;
import com.museo.data.Beacon;
import com.museo.data.Item;
import com.museo.data.StatusCodes;
import com.museo.data.in.InputBeaconId;
import com.museo.data.out.ResultGetItemByBeacon;
import com.museo.data.out.ResultGetTag;
import com.museo.data.out.ResultTestBeacon;

public class Service {

	private final String SELECT_ROOM_BY_BEACON = "SELECT ID, denominazione, descrizione, cod_beacon FROM Oggetto WHERE cod_beacon = ?";
	private final String SELECT_ALL_ROOMS = "SELECT codice, nome, descrizione, idbeacon, piano FROM room";
	private final String SELECT_ITEMS_BY_ROOM = "SELECT codice, nome, descrizione, codiceRoom, idBeacon FROM item WHERE codiceRoom = ?";
	private final String SELECT_ITEM_BY_BEACON = "SELECT * FROM beacon WHERE ID = ?";
	private final String SELECT_ALL_TAGS = "SELECT ID, Denominazione FROM tag";
	
	public ResultTestBeacon getItemByBeacon(InputBeaconId input){
		ResultTestBeacon res = new ResultTestBeacon();
		
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(SELECT_ITEM_BY_BEACON);
			preparedStatement.setString(1, input.getIdBeacon());
			rs = preparedStatement.executeQuery();
			
			Beacon item = null;
			
			if (rs.next()) {
				int  ID = rs.getInt("ID");
				float posX = rs.getFloat("pos_x");
				float posY = rs.getFloat("pos_y");
				int codSala = rs.getInt("cod_sala");
				String macAddress = rs.getString("MAC_address");

				item = new Beacon(ID, posX, posY, codSala, macAddress);
				res.setBeacon(item);
			}
			
			res.setStatusCode(StatusCodes.OK);
			
		} catch (Exception e) {
			res.setStatusCode(StatusCodes.GENERIC_ERROR);
			e.printStackTrace();
		}finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					res.setStatusCode(StatusCodes.GENERIC_ERROR);
					e.printStackTrace();
				}
			}
 
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					res.setStatusCode(StatusCodes.GENERIC_ERROR);
					e.printStackTrace();
				}
			}

		}
		
		return res;
	}
	
	// Realizzato da Kevin Midolo
	public ResultGetTag getAllTags(){
		ResultGetTag res = new ResultGetTag();
		
		Statement statement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();					// Provo a connettermi al database
			statement = conn.createStatement();
			rs = statement.executeQuery(SELECT_ALL_TAGS);				// Eseguo questa query: "SELECT ID, Denominazione FROM tag";
			
			Tag tag = null;
			
			List<Tag> lista = new ArrayList<Tag>();						// Creo una lista di Tag che conterrà tutti i tag trovati nel database
			
			while (rs.next()) { 										// Finché vengono trovati record nella tabella tag del database
				int id = rs.getInt("ID");								// assegno a delle variabili temporanee i valori dei rispettivi campi nella tabella
				String denominazione = rs.getString("Denominazione");
				
				tag = new Tag(id, denominazione);						// Utilizzo il costruttore della classe Tag e inserisco i dati ottenuti dal database
			
				lista.add(tag);											// Aggiungo alla lista l'oggetto tag a cui abbiamo appena inserito i valori
			}

			res.setResult(lista);										// Restituisco la lista con tutti i tag
			res.setStatusCode(StatusCodes.OK);
			
		// Gestione delle eccezioni
		} catch (Exception e) {
			res.setStatusCode(StatusCodes.GENERIC_ERROR);
		}finally {
 
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					res.setStatusCode(StatusCodes.GENERIC_ERROR);
				}
			}
 
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					res.setStatusCode(StatusCodes.GENERIC_ERROR);
				}
			}

		}
		
		return res;
	}
	
}