package de.hdm.raumverwaltung.server;


import java.util.ArrayList;
import java.util.Vector;

import src.de.hdm.raumverwaltung.shared.Benutzer;
import src.de.hdm.raumverwaltung.shared.IllegalArgumentException;
import src.de.hdm.raumverwaltung.shared.IllegaleArgumentException;
import src.de.hdm.raumverwaltung.shared.String;

import de.hdm.raumverwaltung.server.db;
import de.hdm.raumverwaltung.server.db.BenutzerMapper;
import de.hdm.raumverwaltung.server.db.BuchungMapper;
import de.hdm.raumverwaltung.server.db.EinladungMapper;
import de.hdm.raumverwaltung.server.db.RaumMapper;

import de.hdm.raumverwaltung.shared.Raumverwaltung;
import de.hdm.raumverwaltung.shared.bo;
import de.google.gwt.user.server.rpc.RemoteServiceServlet;




public class RaumverwaltungImpl extends RemoteServiceServlet 

implements Raumverwaltung {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Referenz aus zugehörige Benutzer Objekt
	 */
	private Benutzer benutzer=null;


	
	/**Referenzen auf die DB Mapper, die Benutzer Objekte mit der 
	 * Datenbank abgleicht 
	 */
	
	private BenutzerMapper uMapper=null;
	
	/**Referenzen auf die DB Mapper, die Buchuungs Objekte mit der 
	 * Datenbank abgleicht 
	 */
	
	private BuchungMapper bMapper=null;
	
	/**Referenzen auf die DB Mapper, die Einladungs- Objekte mit der 
	 * Datenbank abgleicht 
	 */
	
	private EinladungMapper eMapper=null;
	
	/**Referenzen auf die DB Mapper, die Raum- Objekte mit der 
	 * Datenbank abgleicht 
	 */
	
	
	private RaumMapper rMapper=null;

	
	
	/**
	 * 
	 * ********************************************************************
	 * INITIALISIERUNG BEGINN
	 * ********************************************************************
	 * 
	 * 
	 */
	
	
	public RaumverwaltungImpl () throws IllegalArgumentException{
		/**
		 * No Argument Konstruktor, er vorhanden sein muss.
		 */
	}
	public void init() throws IllegalArgumentException{
	
	/**
	 * In der Raumverwaltung soll es  ein vollständiger Satz von Mappern geben
	 * mit deren Hilfe die Raumverwaltung dann mit Datenbank kommunizieren kann.
	 */
		this uMapper= BenutzerMapper.benutzerMapper();
		this b.Mapper= BuchungMapper.buchungMapper();
		this e.Mapper= EinladungMapper.einladungMapper();
		this r.Mapper= RaumMapper.raumMapper();
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * Beginn :  Methoden für Benutzer Obejkte
	 * ********************************************************************
	 * 
	 * 
	 */

	public Benutzer registrierenBenutzer
	(String vorname, String nachname, String googleID, String email)
		throws IllegaleArgumentException {
	
	Benutzer u= new Benutzer();
		u.setVorname(vorname);
		u.setNachname(nachname);
		u.setGoogleID(googleID);
		u.setEmail(email);
 
	}
 
    
	public Benutzer bearbeitenBenutzer(Benutzer u)
			throws IllegaleArgumentException; 
	
	/**
	 * 
	 */
	public void Benutzer loeschenBenutzer (Benutzer u)
			throws IllegaleArgumentException; 
	
	public Vector<Benutzer> gebeAlleBenutzer() throws IllegalArgumentException;	
	/**
	 * 
	 * ********************************************************************
	 * INITIALISIERUNG
	 * ********************************************************************
	 * 
	 * 
	 */
}