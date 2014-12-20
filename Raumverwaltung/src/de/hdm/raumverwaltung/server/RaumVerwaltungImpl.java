package de.hdm.raumverwaltung.server;


import java.util.ArrayList;
import java.util.Vector;

import de.hdm.raumverwaltung.server.db;
import de.hdm.raumverwaltung.shared.*;
import de.hdm.raumverwaltung.shared.bo;

import de.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RaumverwaltungImpl extends RemoteServiceServlet implements Raumverwaltung {
	
	
	
	
	
	
	/**Referenzen auf die DB Mapper, die die Obejkte mit mit Server DB abgleicht
	 * die Business Objekte
	 * 
	 */
	
	private BenutzerMapper uMapper=null;
	
	private BuchungMapper bMapper=null;
	
	private EinladungMapper eMapper=null;
	
	private RaumMapper rMapper=null;

	
	
	//
}