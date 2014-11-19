package de.hdm.raumverwaltung.shared.bo;

public class Benutzer extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vorname;
	private String nachname;
	private String googleID;
	private String email;
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getGoogleID() {
		return googleID;
	}
	public void setGoogleID(String googleID) {
		this.googleID = googleID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
