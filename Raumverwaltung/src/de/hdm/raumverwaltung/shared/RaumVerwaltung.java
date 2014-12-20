package de.hdm.raumverwaltung.shared;

import java.util.ArrayList;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteRelativePath;

import de.hdm.raumverwaltung.shared.bo.*;
import de.hdm.thies.bankProjekt.shared.bo.Account;


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
	
    public Benutzer getBenutzer ()
    		throws IllegaleArgumentException;  
    
    public void setBenutzer (Benutzer u)
    		throws IllegaleArgumentException; 
    
	public Benutzer bearbeitenBenutzer()
			throws IllegaleArgumentException; 
	
	
	public Benutzer loeschenBenuzter (String vorname, String nachname, String googleID, String email)
			throws IllegaleArgumentException; 
	
	
	
	/** 
	 * Raum verwaltung
	 * @param bezeichnung
	 * @param raumKapazitaet
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public Raum anlegenRaum(String bezeichnung,  int raumKapazitaet)
	throws IllegalArgumentException;
	
	public Raum getRaum ()
			throws IllegaleArgumentException; 
	
	
	public void setRaum (Raum r)
			throws IllegaleArgumentException; 
	
	public Raum bearbeitenRaum (String bezeichung, int raumKapazitaet)
			throws IllegalArgumentException;

	public Raum loeschenRaum (String bezeichung, int raumKapazitaet)
	throws IllegalArgumentException;
	
	public Raum auswaehlenRaum (String bezeichung, int raumKapazitaet)
	throws IllegalArgumentException;
	
	
	/**
	 * 
	 */
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
	
	public Buchung getBuchung ()
			throws IllegaleArgumentException; 
	
	public void setBuchung (Buchung b)
			throws IllegaleArgumentException; 
	
	public Buchung bearbeitenBuchung()
			throws IllegalArgumentException;
	
	public Buchung loeschenBuchung ()
			throws IllegalArgumentException;
	
	
	/** bisher einfache Erstellung von Use Cases und Getter und Setter erzeugen.
	 * Ab hier werden methoden mit den gesamt ausgaben erzeugt (Alle)
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public Vector<Benutzer> getAllBenutzer() throws IllegalArgumentException;
	
	public Vector<Raum> getAllRaeume() throws IllegalArgumentException;
	
	public Vector<Buchung> getAllBuchungen() throws IllegalArgumentException;
	
	public Vector<Einladung> getAllEinladung() throws IllegalArgumentException;
	
	
	
	
	/**Benutzer und die dazu geplante  Ausgaben
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public Vector<Benutzer> findeBenutzerMitName (String vorname, Strin nachname) 
			throws IllegalArgumentException;
	
	public Benutzer findeBenutzerMitId(long id)
			throws IllegalArgumentException;
	
	public Vector<Einladung> getEinladungVonBenutzer (Benutzer user)
			throws IllegalArgumentException;
	
	public Benutzer findeBenutzerMitGoogleID(String googleID)
			throws IllegalArgumentException;
	
	
	/**
	 * Einladungen und die dazu geplante Ausgaben
	 */
	
	public Vector<Einladung> findeEinladungMitBenutzer(Benutzer user)
			throws IllegalArgumentException;
	
	public Vector<Einladung> findeEinladungMitBuchung(Buchung buchung)
		throws IllegalArgumentException;
	

	/**
	 * Raum und die dazi geplante Ausgaben
	*/
	
	public Vector<Raum> findeRaumMitBezeichung(String bezeichnung)
			throws IllegalArgumentException;
	
	public Vector<Raum> findeRaumMitRaumKapazitaet(int raumKapazitaet)
			throws IllegalArgumentException;
	
	public Vector<Raum> findeFreienRaumMitZeitraum(Date anfangsZeit, Date endZeit)
			throws IllegalArgumentException;
	
	public Vector<Raum> findeFreienRaumMitZeitraumUndRaumkapazitaet(Date anfangsZeit, Date endZeit,int raumKapazitaet)
			throws IllegalArgumentException;
	
	/** 
	 * Buchung und die dazu geplnate Ausgaben
	 */
	
	
	public Vector<Buchung> findeBuchungMitErsteller(Benutzer user)
			throws IllegalArgumentException;
	
	public Vector<Buchung> findeBuchungMitTeilnehmer(Benutzer user)
			throws IllegalArgumentException;
	
	public Vector<Buchung> findeBuchungMitBenutzer(Benutzer user)
			throws IllegalArgumentException;
	
	public Vector<Buchung> findeBuchungMitZeitraum(Date anfangsZeit, Date endZeit)
			throws IllegalArgumentException;
	
	
	public Vector<Buchung> findeBuchungMitRaum(Raum raum)
			throws IllegalArgumentException;
	public Vector<Buchung> findeBuchungMitRaumUndZeitraum(Date anfangsZeit, Date endZeit,int raumKapazitaet)
			throws IllegalArgumentException;
	public Vector<Buchung> findeBuchungMitBenutzerUndZeitraum(Date anfangsZeit, Date endZeit, Benutzer user)
			throws IllegalArgumentException;
	
}
	
	
	
	
	
	
	
	
	
	