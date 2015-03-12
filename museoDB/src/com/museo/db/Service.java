package com.museo.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.museo.data.Item;
import com.museo.data.StatusCodes;
import com.museo.data.in.InputBeaconId;
import com.museo.data.out.ResultGetItemByBeacon;

public class Service {

	private final String SELECT_ROOM_BY_BEACON = "SELECT ID, denominazione, descrizione, cod_beacon FROM Oggetto WHERE cod_beacon = ?";
	private final String SELECT_ALL_ROOMS = "SELECT codice, nome, descrizione, idbeacon, piano FROM room";
	private final String SELECT_ITEMS_BY_ROOM = "SELECT codice, nome, descrizione, codiceRoom, idBeacon FROM item WHERE codiceRoom = ?";
	private final String SELECT_ITEM_BY_BEACON = "SELECT * FROM oggetti";
	
	public ResultGetItemByBeacon getItemByBeacon(InputBeaconId input){
		ResultGetItemByBeacon res = new ResultGetItemByBeacon();
		
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(SELECT_ITEM_BY_BEACON);
			//preparedStatement.setString(1, input.getIdBeacon());
			rs = preparedStatement.executeQuery();
			
			Item item = null;
			
			if (rs.next()) {
				double ID = rs.getDouble("ID");
				double cod_beacon = rs.getDouble("cod_beacon");
				String denominazione = rs.getString("Denominazione");
				String anno_prod = rs.getString("Anno_produzione");
				String descrizione = rs.getString("Descrizione");
			
				res.setItem(item);
			}
			
			res.setStatusCode(StatusCodes.OK);
			
		} catch (Exception e) {
			res.setStatusCode(StatusCodes.GENERIC_ERROR);
		}finally {
 
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
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