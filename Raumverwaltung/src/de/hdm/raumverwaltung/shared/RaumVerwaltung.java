package de.hdm.raumverwaltung.shared;

import java.util.ArrayList;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteRelativePath;
import de.hdm.raumverwaltung.shared.bo.*;


@RemoteServiceRelativePath ("raumverwaltung")
public interface Raumverwaltung extends RemoteService {

	public void init () throws IllegalArgumentException;



	public Benutzer erstelleBenutzer(String vorname, String nachname)
		throws IllegaleArgumentException; 
	
	public Raum erstelleRaum(String bezeichnung,  int raumKapazitaet)
	throws IllegalArgumentException;
	
	
	
	/**
	 * Buchung für Benutzer
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
