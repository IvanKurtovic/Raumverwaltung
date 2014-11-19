package de.hdm.raumverwaltung.server.db;

import java.util.Vector;

import de.hdm.raumverwaltung.shared.bo.Benutzer;
import de.hdm.raumverwaltung.shared.bo.Einladung;

public class BenutzerMapper {
	
	public Benutzer findBenutzerByID (long id) {
		return null;
	}
	
	public Vector<Benutzer> findBenutzerByName (String vorname, String nachname) {
		return null;
		
	}
	
	public Benutzer insert (Benutzer user){
		return null;
		
	}
	
	public Benutzer update (Benutzer user){
		return null;
		
	}
	
	public void delete (Benutzer user){
		
	}
	
	public Vector<Einladung> getEinladungenOfBenutzer (Benutzer user){
		return null;
		
	}
	
	public Benutzer findBenutzerByGoogleID (String googleID) {
		return null;
		
	}
}
