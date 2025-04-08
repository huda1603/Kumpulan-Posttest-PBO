package com.AhmadNurHudaPOSTTEST3.app;

public class Pengguna {
	private String username;
	private String password;
	private String tipe;
	
	public Pengguna(String username, String password, String tipe) {
	    this.username = username;
	    this.password = password;
	    this.tipe = tipe;
	}
	
	public String getUsername() {
	    return username;
	}
	public String getPassword() {
	    return password;
	}
	public String getTipe() {
	    return tipe;
	}
}