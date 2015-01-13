package de.hdm.raumverwaltung.server;



import java.util.Vector;






import src.de.hdm.raumverwaltung.server.db.BenutzerMapper;
import src.de.hdm.raumverwaltung.server.db.BuchungsMapper;
import src.de.hdm.raumverwaltung.server.db.EinladungsMapper;
import src.de.hdm.raumverwaltung.server.db.RaumMapper;

import src.de.hdm.raumverwaltung.shared.RaumVerwaltung;
import src.de.hdm.raumverwaltung.shared.bo.*;
import src.de.google.gwt.user.server.rpc.RemoteServiceServlet;




public class RaumverwaltungImpl extends RemoteServiceServlet 

implements Raumverwaltung {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Referenz aus zugehörige Business- Objekt
	 */
	private Benutzer benutzer=null;
	private Raum raum= null;
	private Buchung buchung= null;
	private Einladung einladung= null;
	

	
	/**Referenzen auf die DB Mapper, die Benutzer Objekte mit der 
	 * Datenbank abgleicht 
	 */
	
	private BenutzerMapper uMapper=null;
	
	/**Referenzen auf die DB Mapper, die Buchuungs Objekte mit der 
	 * Datenbank abgleicht 
	 */
	
	private BuchungsMapper bMapper=null;
	
	/**Referenzen auf die DB Mapper, die Einladungs- Objekte mit der 
	 * Datenbank abgleicht 
	 */
	
	private EinladungsMapper eMapper=null;
	
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
	
	
	public RaumverwaltungImpl() throws IllegalArgumentException{
		/**
		 * No Argument Konstruktor, er vorhanden sein muss.
		 */
	}
	public void init() throws IllegalArgumentException{
	
	/**
	 * In der Raumverwaltung soll es  ein vollständiger Satz von Mappern geben
	 * mit deren Hilfe die Raumverwaltung dann mit Datenbank kommunizieren kann.
	 */
		this.uMapper= BenutzerMapper.benutzerMapper();
		this.bMapper= BuchungsMapper.buchungMapper();
		this.eMapper= EinladungsMapper.einladungMapper();
		this.rMapper= RaumMapper.raumMapper();
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * Beginn :  Benutzer
	 * ein Benutzer wird registriert und als rückgabe wert gibt es der jeweilige 
	 * Benutzer-Objekt
	 * 
	 * 
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
 
		u.setId(1);
		return this.uMapper.insert(u);
		
	}
 
    
	public Benutzer bearbeitenBenutzer(Benutzer u)
			throws IllegaleArgumentException; 
	
	/**
	 * 
	 */
	public void Benutzer loeschenBenutzer (Benutzer u)
			throws IllegaleArgumentException{
		
		this.uMapper.delete(u);
	}
	
	
	
	public Vector<Benutzer> gebeAlleBenutzer() throws IllegalArgumentException{
		return this.uMapper.findeAlle();
		
	}	
	
	/**
	 * 
	 * ********************************************************************
	 *Ende BENUTZER
	 * ********************************************************************
	 * 
	 * 
	 */
	
	/**
	 * Beginn Raum
	 *  
	 */
	public Raum anlegenRaum(String bezeichnung,  int raumKapazitaet)
	throws IllegalArgumentException{
		
		Raum r = new Raum();
		r.setBezeichnung(bezeichnung);
		r.setKapazitaet(raumKapazitaet);
		r.setId(1);
		
		return this.rMapper.insert(r);
	}

	
/**
 * Löschen der übergebenen . Beachten Sie bitte auch die Anmerkungen zu
   * {@link #delete(Customer)} und {@link #delete(Account)}.
   *  
 * @param r
 * @return
 * @throws IllegalArgumentException
 */
	public Raum bearbeitenRaum(Raum r) throws IllegalArgumentException;

	
	public void Raum loeschenRaum(Raum r) throws IllegalArgumentException{
		
		this.rMapper.delete(r);
		
	}
	
	/**
	 * Auslesen von alle Raum Objekten
	 * @return Vector ausjeweiligen Raum Objekten 

	 */
	public Vector <Raum> gebeAlleRaeume (String bezeichung, int raumKapazitaet)
	throws IllegalArgumentException{
		
		return this.rMapper.findeAlle();
	}
	
/**
 * 

 * 
 */
	
	
	
	
	public Buchung anlegenBuchung (int t, int az, int ez, int r, int e)
			throws IllegalArgumentException{
		
		Thema thema = this.getThema(t);
		AnfangsZeit anfangszeit = this.getAnfangsZeit(az);// ?????
		EndZeit endzet = this.getEndZeit(ez);//?????
		Raum raum = this.getRaumById(r);
		Ersteller ersteller = this.getErstellerById(e);
		
		
		return this.bMapper.insert(b);
		
	}
	

	public Buchung bearbeitenBuchung(Buchung b)
			throws IllegalArgumentException{
		
		Thema thema = this.getThema(t);
		AnfangsZeit anfangszeit = this.getAnfangsZeit(az);// ?????
		EndZeit endzet = this.getEndZeit(ez);//?????
		Raum raum = this.getRaumById(r);
		Ersteller ersteller = this.getErstellerById(e);
		
		if (raum == null){
			
			throws IllegalArgumentException{
					"Dieser Raum existiert nicht "}
			else 										//????
		
	}
	
	public void Buchung loeschenBuchung(Buchung b)
			throws IllegalArgumentException {
		
		Vector<Buchung> alleBuchung= this.gebeAlleBuchungen(b);
		
		this.bMapper.delete(b);
	}
	


	public Benutzer einladenBenutzer (String vorname, String nachname,)
		    throws IllegaleArgumentException{
		    this.bMapper.insert();
	}
	
	/**
	 * Methoden um Einladung zu bestätigt oder abgelehnt 
	 * @return
	 * @throws IllegaleArgumentException
	 */
	public Einladung bestaetigenEinladung()	//noch zu klären
			throws IllegalArgumentException {
		return this.status("angenommen" + ANGENOMMEN);
	}
		
	
	public Einladung ablehnenEinladung()
			throws IllegaleArgumentException{
		return this.status("abgelehnt" + ABGENEHNT); 
	}

/**
 * Auslesen aller jeweiligen BO 
 * @return Vector aus allen jeweiligen BO's
 * @throws IllegalArgumentException
 */



public Vector<Benutzer> gebeAlleBenutzer() throws IllegalArgumentException{
	return this.uMapper.findeAlle();
}

public Vector<Raum> gebeAlleRaeume() throws IllegalArgumentException{
	return this.rMapper.findeAlle();
}

public Vector<Buchung> gebeAlleBuchungen() throws IllegalArgumentException{
	return this.bMapper.findeAlle();
			
}			
public Vector<Einladung> gebeAlleEinladung() throws IllegalArgumentException{

	return this.eMapper.findeAlle();
}

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

}






















