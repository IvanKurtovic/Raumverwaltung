package de.hdm.raumverwaltung.shared;

import de.hdm.raumverwaltung.shared.bo.*;

import de.hdm.raumverwaltung.shared.report.erstelleReportVonRaumFuerZeitraum;
import de.hdm.raumverwaltung.shared.report.erstelleReportVonBenutzerFuerZeitraum;
import de.hdm.raumverwaltung.shared.report.erstelleReportOfBuchungenFuerZeitraum;
import de.hdm.raumverwaltung.shared.report.erstelleListeMitAlleRaeume;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * <p>
 * Synchrone Schnittstelle für eine RPC-fähige Klasse zur Erstellung von
 * Reports. Diese Schnittstelle benutzt die gleiche Realisierungsgrundlage wir
 * das Paar {@link Raumverwaltung} und {@link RaumverwaltungImpl}. 
 * Zu technischen Erläuterung etwa bzgl. GWT RPC bzw. {@link RemoteServiceServlet}
 * siehe {@link Raumverwaltung} und {@link RaumverwaltungImpl}.
 * </p>
 * <p>
 * Ein ReportGenerator bietet die Möglichkeit, eine Menge von Berichten
 * (Reports) zu erstellen, die Menge von Daten bzgl. bestimmter Sachverhalte des
 * Systems zweckspezifisch darstellen.
 * </p>
 * <p>
 * Die Klasse bietet eine Reihe von <code>erstelle...</code>-Methoden, mit deren
 * Hilfe die Reports erstellt werden können. Jede dieser Methoden besitzt eine
 * dem Anwendungsfall entsprechende Parameterliste. Diese Parameter benötigt der
 * der Generator, um den Report erstellen zu können.
 * </p>
 * <p> 
 * Bei neu hinzukommenden Bedarfen an Berichten, kann diese Klasse auf einfache
 * Weise erweitert werden. Hierzu können zusätzliche <code>erstelle...</code>
 * -Methoden implementiert werden. Die bestehenden Methoden bleiben davon
 * unbeeinflusst, so dass bestehende Programmlogik nicht verändert werden muss.
 * </p>
 * 
 * @author thies @ author Galina Schmidt
 */

@RemoteServiceRelativePath("reportgenerator")
public interface ReportGenerator extends RemoteService {

	public void init() throws IllegalArgumentException;
	/** 
	 * in Unseren Use Cases möchten wir auf der Report Generator Seite die 
	 * Möglichkeiten haben Raum,-Benutzer,- und Buchungen in einen bestimmtem 
	 * Zeitraum auszugeben, dazu verwenden wir die entsprechende Parameter 
	 * der jeweilige Objekte
	 * 
	 * @see ReportVonRaumFuerZeitraum
	 * @param raum +
	 * @param anfangsZeit +
	 * @param endZeit sind die Refenzent auf das Raum und Zeitraum Objekte
	 * @return
	 * @throws IllegalArgumentException
	 */
	public abstract ReportVonRaumFuerZeitraum
		erstelleReportVonRaumFuerZeitraum
			(Raum raum, Date anfangsZeit, Date endZeit)
		throws IllegalArgumentException;
	
	/**
	 * @param benutzer,anfangsZeit und endZeit sind die Refenrzen auf das report 
	 *um zu erfahren wo ein Benutzer seine Termine hat.
	  */
	
	
	public abstract ReportVonBenutzerFuerZeitraum 
		erstelleReportVonBenutzerFuerZeitraum
			(Benutzer benutzer, Date anfangsZeit, Date endZeit)
		throws IllegalArgumentException;
	
	/**
	 * @param benutzer,anfangsZeit und endZeit sind die Refenrzen auf das report 
	 *um zu erfahren wo ein Benutzer seine Termine hat.
	  */
	
	
	public abstract ReportVonBuchungenFuerZeitraum 
		erstelleReportOfBuchungenFuerZeitraum(Date anfangsZeit, Date endZeit)
		throws IllegalArgumentException;
	
	
	/**
	 * Erstellen eines Report-Liste mit allen bestehenden  Räumen 
	 * @return ein fertiges Reportobjekt
	 * @author Galina Schmidt
	  */
	public abstract ListeMitAlleRaeume <Raum > erstelleListeMitAlleRaeume()
			throws IllegalArgumentException;
}




