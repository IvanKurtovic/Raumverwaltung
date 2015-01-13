package de.hdm.raumverwaltung.server.db;

import java.util.Vector;

import de.hdm.raumverwaltung.shared.bo.Benutzer;
import de.hdm.raumverwaltung.shared.bo.Einladung;

public class BenutzerMapper {
	
	public Benutzer findeBenutzermitID (long id) {
		return null;
	}
	
	public Vector<Benutzer> findeBenutzermitName (String vorname, String nachname) {
		return null;
		
	}
	
	public Vector<Benutzer> findeAlle() {
	
	}
	
	public Benutzer insert (Benutzer u){
		return null;
		
	}
	
	public Benutzer update (Benutzer u){
		return null;
		
	}
	
	public void delete (Benutzer u){
		
	}
	
	public Vector<Einladung> getEinladungenvonBenutzer (Benutzer u){
		return null;
		
	}
	
	public Benutzer findeBenutzermitGoogleID (String googleID) {
		return null;
		
	}
}
