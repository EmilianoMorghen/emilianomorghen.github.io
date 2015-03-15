package com.museo.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.museo.data.HistoryOrItinerary;
import com.museo.data.Item;
import com.museo.data.Room;
import com.museo.data.StatusCodes;
import com.museo.data.Tag;
import com.museo.data.in.InputBeaconId;
import com.museo.data.in.InputNewUser;
import com.museo.data.in.InputRoomId;
import com.museo.data.in.InputUserId;
import com.museo.data.out.ResultCreateNewUser;
import com.museo.data.out.ResultGetAllRooms;
import com.museo.data.out.ResultGetHistoryOrItinerary;
import com.museo.data.out.ResultGetItemByBeacon;
import com.museo.data.out.ResultGetItemsByCodiceSala;
import com.museo.data.out.ResultGetRoomByBeacon;
import com.museo.data.out.ResultGetTag;

public class Service {

	//Restituisce tutti i dati della sala a cui appartiene il beacon
	private final String SELECT_ROOM_BY_BEACON = "SELECT sale.* FROM sale, beacon WHERE beacon.id = ? AND beacon.cod_sala = sale.id";
	
	//Restituisce tutti i dati di tutte le sale
	private final String SELECT_ALL_ROOMS = "SELECT * FROM sale";
	
	//Restituisce tutti i dati degli oggetti appartenenti ad un determinato beacon
	private final String SELECT_ITEMS_BY_BEACON = "SELECT * FROM oggetti WHERE cod_beacon = ?";
	
	//Restituisce tutti i dati di tutti i tag
	private final String SELECT_ALL_TAGS = "SELECT * FROM tag";
	
	//Restituisce tutti i dati degli oggetti appartenenti ad una determinata stanza
	private final String SELECT_ITEMS_BY_ROOM = "SELECT O.* FROM oggetti O, beacon B, sale S WHERE O.cod_beacon = B.ID AND B.cod_sala = S.ID AND S.ID = ?";
	
	//Restituisce la cronologia degli oggetti visualizzati da un determinato utente
	private final String SELECT_HISTORY_BY_ID_USER = "SELECT oggetti.* FROM oggetti,utente_oggetto WHERE cronologia = 1 AND oggetti.id = utente_oggetto.cod_oggetto AND utente_oggetto.cod_utente = ?";
	
	//Restituisce l'itinerario degli oggetti di un determinato utente
	private final String SELECT_ITINERARY_BY_ID_USER = "SELECT oggetti.* FROM oggetti,utente_oggetto WHERE itinerario = 1 AND oggetti.id = utente_oggetto.cod_oggetto AND utente_oggetto.cod_utente = ?";
	
	//Inserisce un nuovo utente
	private final String INSERT_NEW_USER = "INSERT INTO utenti VALUES (null,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
	
	
	//SELECT_ITEMS_BY_BEACON - Davide
	public ResultGetItemByBeacon getItemByBeacon(InputBeaconId input){
		ResultGetItemByBeacon res = new ResultGetItemByBeacon();
		
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();								//Connessione al db
			preparedStatement = conn.prepareStatement(SELECT_ITEMS_BY_BEACON);		//Preparo la query
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
					e.getStackTrace();
				}
			}
		}
		return res;
	}

	//SELECT_ALL_ROOMS - Berbeglia Marco
	public ResultGetAllRooms getAllRooms(){
		
		ResultGetAllRooms res = new ResultGetAllRooms();
		
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(SELECT_ALL_ROOMS);
			rs = preparedStatement.executeQuery();
			
			Room room = null;
			List<Room> lista = new ArrayList<Room>();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String denominazione = rs.getString("Denominazione");
				String descrizione = rs.getString("Descrizione");
				
				room = new Room(id,denominazione,descrizione);
				lista.add(room);		
			}
			res.setRooms(lista);;
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
	
	//SELECT_ROOM_BY_BEACON - Caua Alexandru
	public ResultGetRoomByBeacon getRoomByBeacon(InputBeaconId input){
		ResultGetRoomByBeacon res = new ResultGetRoomByBeacon();
		
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(SELECT_ROOM_BY_BEACON);
			preparedStatement.setString(1, input.getIdBeacon());
			rs = preparedStatement.executeQuery();
			
			Room room = null;
			
			if (rs.next()) {
				int id = rs.getInt("id");
				String denominazione = rs.getString("denominazione");		
				String descrizione = rs.getString("descrizione");
				room = new Room(id, denominazione, descrizione);
				res.setRoom(room);
			}
			
			res.setStatusCode(StatusCodes.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
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
	
	//SELECT_ITEMS_BY_ROOM - D'Orazio Antonio
	public ResultGetItemsByCodiceSala getItemsByCodiceSala(InputRoomId input){
		ResultGetItemsByCodiceSala res = new ResultGetItemsByCodiceSala();
		
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();
			// Prepara la query
			preparedStatement = conn.prepareStatement(SELECT_ITEMS_BY_ROOM);
			
			// Imposta l'input per prendere l'ID della sala
			preparedStatement.setInt(1, input.getCodiceRoom());
			
			// Esegue la query
			rs = preparedStatement.executeQuery();	
			
			Item item = null;
			List<Item> lista = new ArrayList<Item>();

			
			while (rs.next()) {

				// Salva una tupla presa dal database in variabili 
				int id = rs.getInt("ID");
				int codBeacon = rs.getInt("cod_beacon");
				String denominazione = rs.getString("Denominazione");
				int annoProd = rs.getInt("Anno_produzione");
				String descrizione = rs.getString("Descrizione");
				String urlEst = rs.getString("Url_esterno");
				
				// Crea un nuovo oggetto Item con la tupla presa
				item = new Item(id,codBeacon,denominazione,annoProd,descrizione,urlEst);
				
				// Aggiunge l'oggetto alla lista
				lista.add(item);
			}
			
			// Memorizza tutta la lista nella classe risultato
			res.setItems(lista);
			
			// Restituisce codice stato
			res.setStatusCode(StatusCodes.OK);

			
		// Gestisce le eccezioni
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
	//SELECT_ALL_TAGS - Midolo Kevin
	public ResultGetTag getAllTags(){
		ResultGetTag res = new ResultGetTag();
		
		Statement statement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();				
			statement = conn.createStatement();
			rs = statement.executeQuery(SELECT_ALL_TAGS);			
			
			Tag tag = null;
			
			List<Tag> lista = new ArrayList<Tag>();						
			
			while (rs.next()) { 										
				int id = rs.getInt("ID");								
				String denominazione = rs.getString("Denominazione");
				
				tag = new Tag(id, denominazione);						
				
				lista.add(tag);											
			}

			res.setResult(lista);										
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
	
	//SELECT_HISTORY_BY_ID_USER - Berbeglia Marco, Midolo Kevin, Caua Alexandru
	public ResultGetHistoryOrItinerary getHistory(InputUserId input){
		
		ResultGetHistoryOrItinerary res = new ResultGetHistoryOrItinerary();
		
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(SELECT_HISTORY_BY_ID_USER);
			//Preparo la query
			preparedStatement.setInt(1,input.getIdUser());
			rs = preparedStatement.executeQuery();
			
			HistoryOrItinerary history= null;
			Item item = null;
			List<Item> list = new ArrayList<Item>();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				int cod_beacon = rs.getInt("cod_beacon");
				String denominazione = rs.getString("Denominazione");
				int anno_prod = rs.getInt("Anno_produzione");
				String descrizione = rs.getString("Descrizione");
				String url_esterno = rs.getString("url_esterno");
				
				item = new Item(id, cod_beacon, denominazione, anno_prod, descrizione, url_esterno);
				list.add(item);
					
			}
			history = new HistoryOrItinerary(list);
			res.setLista(history);
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
	//SELECT_ITINERARY_BY_ID_USER - Midolo Kevin, Caua Alexandru, Berbeglia Marco
	public ResultGetHistoryOrItinerary getItinerary(InputUserId input){
		
		ResultGetHistoryOrItinerary res = new ResultGetHistoryOrItinerary();
		
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();
			preparedStatement = conn.prepareStatement(SELECT_ITINERARY_BY_ID_USER);
			//Preparo la query
			preparedStatement.setInt(1,input.getIdUser());
			rs = preparedStatement.executeQuery();
			
			HistoryOrItinerary itinerary= null;
			Item item = null;
			List<Item> list = new ArrayList<Item>();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				int cod_beacon = rs.getInt("cod_beacon");
				String denominazione = rs.getString("Denominazione");
				int anno_prod = rs.getInt("Anno_produzione");
				String descrizione = rs.getString("Descrizione");
				String url_esterno = rs.getString("url_esterno");
				
				item = new Item(id, cod_beacon, denominazione, anno_prod, descrizione, url_esterno);
				list.add(item);
					
			}
			itinerary = new HistoryOrItinerary(list);
			res.setLista(itinerary);
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
	//INSERT_NEW_USER - Scoccia Alessio, D'Orazio Antonio, Berbeglia Marco
	public ResultCreateNewUser createNewUser(InputNewUser input){
		ResultCreateNewUser res = new ResultCreateNewUser();
		
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionManager.getConnection();
			// Prepara la query
			preparedStatement = conn.prepareStatement(INSERT_NEW_USER);
			
			// Imposta l'input
			preparedStatement.setString(1, input.getUsername());
			preparedStatement.setInt(2, input.getCod_profilo());
			preparedStatement.setString(3, input.getNome());
			preparedStatement.setString(4, input.getCognome());
			preparedStatement.setString(5, input.getEmail());
			preparedStatement.setString(6, input.getPassword());
			
			// Esegue la query
		    preparedStatement.executeUpdate();	
			res.setStatusCode(StatusCodes.OK);
		
		// Gestisce le eccezioni
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

}