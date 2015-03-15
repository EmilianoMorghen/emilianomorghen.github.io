//Realizzato da D'Orazio Antonio, Scoccia Alessio e Berbeglia Marco
package com.museo.data.in;

import java.io.Serializable;

public class InputNewUser implements Serializable{
	
	private String username;
	private int cod_profilo;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCod_profilo() {
		return cod_profilo;
	}
	public void setCod_profilo(int cod_profilo) {
		this.cod_profilo = cod_profilo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
