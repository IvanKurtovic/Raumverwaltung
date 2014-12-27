package de.hdm.raumverwaltung.server;


import java.util.ArrayList;
import java.util.Vector;
import de.hdm.raumverwaltung.server.db;
import de.hdm.raumverwaltung.server.db.BenutzerMapper;
import de.hdm.raumverwaltung.server.db.BuchungMapper;
import de.hdm.raumverwaltung.server.db.EinladungMapper;
import de.hdm.raumverwaltung.server.db.RaumMapper;

import de.hdm.raumverwaltung.shared.Raumverwaltung;
import de.hdm.raumverwaltung.shared.bo;

import de.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RaumverwaltungImpl extends RemoteServiceServlet implements Raumverwaltung {
	
	private static final long serialVersionUID = ;
	
	
	private Benutzer benutzer=null;
	private Buchung buchung=null;
	private Einladung einladung= null;
	private Raum raum= null;
	
	
	
	/**Referenzen auf die DB Mapper, die die Objekte  mit Server DB abgleicht
	 * die Business Objekte
	 * 
	 */
	
	
	private BenutzerMapper uMapper=null;
	
	private BuchungMapper bMapper=null;
	
	private EinladungMapper eMapper=null;
	
	private RaumMapper rMapper=null;

	
	
	//
}