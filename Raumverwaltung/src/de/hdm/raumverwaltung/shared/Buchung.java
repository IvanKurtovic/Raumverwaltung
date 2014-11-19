package de.hdm.raumverwaltung.shared;

import java.util.Date;

public class Buchung extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String thema;
	private Date anfangsZeit;
	private Date endZeit;
	private Raum raum;
	private Benutzer ersteller;
	
	public String getThema() {
		return thema;
	}
	public void setThema(String thema) {
		this.thema = thema;
	}
	public Date getAnfangsZeit() {
		return anfangsZeit;
	}
	public void setAnfangsZeit(Date anfangsZeit) {
		this.anfangsZeit = anfangsZeit;
	}
	public Date getEndZeit() {
		return endZeit;
	}
	public void setEndZeit(Date endZeit) {
		this.endZeit = endZeit;
	}
	public Raum getRaum() {
		return raum;
	}
	public void setRaum(Raum raum) {
		this.raum = raum;
	}
	public Benutzer getErsteller() {
		return ersteller;
	}
	public void setErsteller(Benutzer ersteller) {
		this.ersteller = ersteller;
	}
	

}
