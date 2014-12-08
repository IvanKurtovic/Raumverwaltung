package de.hdm.raumverwaltung.shared;

import java.util.ArrayList;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteRelativePath;
import de.hdm.raumverwaltung.shared.bo.*;


@RemoteServiceRelativePath ("raumverwaltung")
public interface Raumverwaltung extends RemoteService {

	public void init () throws IllegalArgumentException;

/**
 * Benuzter VErwaltung 
 * @param vorname
 * @param nachname
 * @param googleID
 * @param email
 * @return
 * @throws IllegaleArgumentException
 */

	public Benutzer registrierenBenutzer(String vorname, String nachname, String googleID, String email)
		throws IllegaleArgumentException; 
	
	public Benutzer bearbeitenBenutzer()
			throws IllegaleArgumentException; 
	
	
	public Benutzer loeschenBenuzter (String vorname, String nachname, String googleID, String email)
			throws IllegaleArgumentException; 
	
	
	/** 
	 * Raum verwaltunf
	 * @param bezeichnung
	 * @param raumKapazitaet
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public Raum anlegenRaum(String bezeichnung,  int raumKapazitaet)
	throws IllegalArgumentException;
	
	public Raum bearbeitenRaum (String bezeichung, int raumKapazitaet)
			throws IllegalArgumentException;

	public Raum loeschenRaum (String bezeichung, int raumKapazitaet)
	throws IllegalArgumentException;
	
	public Raum auswaehlenRaum (String bezeichung, int raumKapazitaet)
	throws IllegalArgumentException;
	
	/**
	 * Buchung Verwaltung
	 * @param veranstaltung
	 * @param teilnehmer
	 * @param status
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public Buchung anlegenBuchung ()
			throws IllegalArgumentException;
	
	public Buchung bearbeitenBuchung()
			throws IllegalArgumentException;
	
	public Buchung loeschenBuchung ()
			throws IllegalArgumentException;
	
	
	
	
	public Benutzer einladenBenutzer()
			throws IllegalArgumentException;
	
	
	public Einladung bestaetigenEinladung ()
			throws IllegalArgumentException;
	
	public Einladung ablehnenEinladung()
			throws IllegalArgumentException;
	
	
	/** 
	 * bisher sind nur reine Use Cases aus den Meilenstein 2
	 * @param veranstaltung
	 * @param teilnehmer
	 * @param status
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Einladung erstelleEinladung(Buchung veranstaltung , Benutzer teilnehmer, Enumeration status )
	throws IllegalArgumentException;
	/**
	 * Für Benutzer
	 * @param vorname
	 * @param nachname
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public Einladung erstelleEinladungFuer(String vorname, String nachname)
	throws IllegalArgumentException;
	/**
	 * 
	 * Für Buchung
	 * @param thema
	 * @param anfangsZeit
	 * @param endZeit
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public Einladung anlegenEinladungFuer(String thema, Date anfangsZeit, Date endZeit )
	throws IllegalArgumentException;
	
	public ArrayList<Buchung> gebeBuchungVon (Raum r)
			throws IllegalArgumentException;

			/**
			 * auslesen sämtlicher Buchungen die in Verbindung mit Raum stehen
			 * @throws IllegalArgumentException
			 */
			
	
	public Buchung anlegenBuchungFuer(Raum r) 
	throws IllegalArgumentException;
	/**
	 * erstelle Buchung für einen Raum
	 * @param vorname
	 * @param nachname
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public Buchung anlegenBuchungFuer(String vorname, String nachname)
	throws IllegalArgumentException;
	
	
	public ArrayList <Buchung>gebeBuchungVon (Raum r)
	throws IllegalArgumentException;

	/**
	 * auslesen sämtlicher Buchungen die in Verbindung mit Raum stehen
	 * @throws IllegalArgumentException
	 */
	
	
	public getRaum ()throws IllegalArgumentException;
	
	public setRaum (Raum r) throws IllegalArgumentException;
	
	

	
}
