package com.museo.data;

public class Beacon {
	private int id;
	private float pos_x;
	private float pos_y;
	private int cod_sala;
	private String mac_address;
	
	public Beacon(int id, float pos_x, float pos_y, int cod_sala,
			String mac_address) {
		super();
		this.id = id;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.cod_sala = cod_sala;
		this.mac_address = mac_address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPos_x() {
		return pos_x;
	}
	public void setPos_x(float pos_x) {
		this.pos_x = pos_x;
	}
	public float getPos_y() {
		return pos_y;
	}
	public void setPos_y(float pos_y) {
		this.pos_y = pos_y;
	}
	public int getCod_sala() {
		return cod_sala;
	}
	public void setCod_sala(int cod_sala) {
		this.cod_sala = cod_sala;
	}
	public String getMac_address() {
		return mac_address;
	}
	public void setMac_address(String mac_address) {
		this.mac_address = mac_address;
	}
	
}
