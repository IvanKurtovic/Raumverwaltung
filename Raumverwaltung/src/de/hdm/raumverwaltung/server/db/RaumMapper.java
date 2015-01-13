package de.hdm.raumverwaltung.server.db;

import de.hdm.thies.bankProjekt.server.db.AccountMapper;


public class RaumMapper {
	
	private static RaumMapper raumMapper = null;
	
	
	protected RaumMapper(){
		
	}
	
	 public static RaumMapper raumMapper() {
		    if (raumMapper == null) {
		      raumMapper = new RaumMapper();
		    }

		    return raumMapper;
		  }
	 
	 
	public Vector<Raum> findeAlle() {
}
}