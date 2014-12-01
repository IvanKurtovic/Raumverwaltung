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
	
	public Benutzer insert (Benutzer user){
		return null;
		
	}
	
	public Benutzer update (Benutzer user){
		return null;
		
	}
	
	public void loesche (Benutzer user){
		
	}
	
	public Vector<Einladung> getEinladungenvonBenutzer (Benutzer user){
		return null;
		
	}
	
	public Benutzer findeBenutzermitGoogleID (String googleID) {
		return null;
		
	}
}
