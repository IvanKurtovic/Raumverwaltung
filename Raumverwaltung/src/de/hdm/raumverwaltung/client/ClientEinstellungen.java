package de.hdm.raumverwaltung.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.raumverwaltung.shared.*;
import de.hdm.raumverwaltung.client.*;


public class ClientEinstellungen extends AllgemeineEinstellungen {

	
	 private static RaumVerwaltungAsync raumVerwaltung = null;

	 
	  private static final String LOGGER_NAME = "Raum Verwaltung Web Client";
	  
	
	  private static final Logger log = Logger.getLogger(LOGGER_NAME);

	 
	  public static Logger getLogger() {
	    return log;
	  }

	  
	  public static RaumVerwaltungAsync getRaumVerwaltung() {
	  
	    if (raumVerwaltung == null) {
	  
	      raumVerwaltung = GWT.create(RaumVerwaltung.class);
	    }

	 
	    return raumVerwaltung;
	  }

	 
	  public static ReportGeneratorAsync getReportGenerator() {
	    
	    if (reportGenerator == null) {
	     
	      reportGenerator = GWT.create(ReportGenerator.class);

	      final AsyncCallback<Void> initReportGeneratorCallback = new AsyncCallback<Void>() {
	        public void onFailure(Throwable caught) {
	          AllgemeineEinstellungen.getLogger().severe(
	              "Der ReportGenerator konnte nicht initialisiert werden!");
	        }

	        public void onSuccess(Void result) {
	        	AllgemeineEinstellungen.getLogger().info(
	              "Der ReportGenerator wurde initialisiert.");
	        }
	      };

	      reportGenerator.init(initReportGeneratorCallback);
	    }


	    return reportGenerator;
	  }

	
	
}
