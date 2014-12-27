package de.hdm.raumverwaltung.shared;

import java.util.ArrayList;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteRelativePath;

import de.hdm.raumverwaltung.shared.bo.*;
import de.hdm.thies.bankProjekt.shared.bo.Account;
import de.hdm.thies.bankProjekt.shared.bo.Bank;
import de.hdm.thies.bankProjekt.shared.bo.Customer;
import de.hdm.thies.bankProjekt.shared.bo.Transaction;

/**
 * <p>
 * Das ist die Synchrone Schnittstelle für eine RPC-fähige Klasse
 *  zur Verwaltung von Räumen.
 * </p>
 *
 * <p>
 * <code>@RemoteServiceRelativePath("Raumverwaltung")</code> ist bei der
 * Adressierung des aus der zugehörigen Impl-Klasse entstehenden
 * Servlet-Kompilats behilflich. 
 * Es gibt im Wesentlichen einen Teil der URL des Servlets an.
 * </p>
 * @author Galina Schmidt 
 */
@RemoteServiceRelativePath ("raumverwaltung")


public interface Raumverwaltung extends RemoteService {
	public void init () throws IllegalArgumentException;


     
  /**
   * ALLE BENUTZER USE CASES
   * 
   * ein Benutzer meldet sich zum ersten mal an.
   * In diese Methode  müssen Daten wie Name, Vorname, 
   * das in Google Account erstellte ID und deren mail angelegt werden
   * 
   */
	
	public Benutzer registrierenBenutzer
	(String vorname, String nachname, String googleID, String email)
		throws IllegaleArgumentException; 
	
  /** 
   * Der Datensatz des Benutzers soll geändert werden
   * da er bereits bekannt ist wird in dieser Methode ein vorhandener 
   * Benutzer-Objekt verwendet
   * @return
   * @throws IllegaleArgumentException
   */
    
	public Benutzer bearbeitenBenutzer(Benutzer u)
			throws IllegaleArgumentException; 
	
	/**
	 * 
	 */
	public void Benutzer loeschenBenutzer (Benutzer u)
			throws IllegaleArgumentException; 
	
		    
		    
	/** 
	 * ALLE RAUM USE CASES
	 * Ein neuer Raum soll angelegt werden
	 * zurückgegeben wird ein fertiger Raum-Objekt
	 */
	
	public Raum anlegenRaum(String bezeichnung,  int raumKapazitaet)
	throws IllegalArgumentException;
	

	public Raum bearbeitenRaum (Raum r)
			throws IllegalArgumentException;

	public void Raum loeschenRaum (Raum r)
	throws IllegalArgumentException;
	
	public Vector <Raum> auswaehlenRaum (String bezeichung, int raumKapazitaet)
	throws IllegalArgumentException;
	

	
	/**
	 * ALLE BUCHUNG USE CASES
	 * Eine Buchung wir dvon Benutzer erzeugt.
	 * Zurückgegeben wird ein fertige Buchung mit Informationen über den Zeitraum,
	 * Raum und den Ersteller
	 * 
	 */
	public Buchung anlegenBuchung 
	(String thema, Date anfangsZeit, Date endZeit, Raum raum, Benutzer ersteller )
			throws IllegalArgumentException;
	

	public Buchung bearbeitenBuchung(Buchung b)
			throws IllegalArgumentException;
	
	public void Buchung loeschenBuchung(Buchun b)
			throws IllegalArgumentException;
	
	
	
	/**
	 * EINLADUNGEN USE CASES
	 * Ein Benutzer-Objekt, der durch Vornamen und Nachname bekannst ist,
	 * wird eingeladen um in der Veranstaltung teilzunehmen
	 * 
	 */

	public Benutzer einladenBenutzer (String vorname, String nachname)
		    throws IllegaleArgumentException;
	
	/**
	 * Methoden um Einladung zu bestätigt oder abgelehnt 
	 * @return
	 * @throws IllegaleArgumentException
	 */
	public Einladung bestaetigenEinladung()
			throws IllegaleArgumentException;
	
	public Einladung ablehnenEinladung()
			throws IllegaleArgumentException;
	
	
	
	/** 
	 * ALLE AUSGABEN EINFACHE
	 * Ab hier werden methoden  erzeugt die Alle vorhandene Listen ausgeben 
	 * mit der dynamische Liste -Vector
	 * 
	 */
	
	public Vector<Benutzer> gebeAlleBenutzer() throws IllegalArgumentException;
	
	public Vector<Raum> gebeAlleRaeume() throws IllegalArgumentException;
	
	public Vector<Buchung> gebeAlleBuchungen() throws IllegalArgumentException;
	
	public Vector<Einladung> gebeAlleEinladung() throws IllegalArgumentException;
	
	
	/**
	 * ALLE BUCHUNGEN NACH KATEGORIEN
	 * Ein Buchung soll mit Teilnehmern(t) ausgegegben werden und mit Zeitraum 
	 * wann die Veranstalung ansteht(Anfang a, Ende e)
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public Vector<Buchung> gebeBuchungMitTeilnehmer(Benutzer t)
			throws IllegalArgumentException;
	
	
	public Vector<Buchung> gebeBuchungMitZeitraum(Date a, Date e)
			throws IllegalArgumentException;
	
	
	
	
	public Vector<Benutzer> sucheBenutzerNachName (String vorname, String nachname) 
			throws IllegalArgumentException;
	
	public Benutzer sucheBenutzerNachId(long id)
			throws IllegalArgumentException;
	
	
	
	/**
	 * Es sollen Räume angezeigt werden nach Kapazität um sich Infos 
	 * darüber zu holen wieviel Teilnehmer in einen Raum passen ()
	 * Kapazität-Objekt ist bekannt (k)
	*/

	public Vector<Raum> sucheRaumNachKapazitaet(int k)
			throws IllegalArgumentException;

	

	
}
	
	
	
	
	
	
	
	
	
	