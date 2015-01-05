package src.de.hdm.raumverwaltung.server.report;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.thies.bankProjekt.server.report.BankAdministrationImpl;
import de.hdm.thies.bankProjekt.shared.BankAdministration;
import src.de.hdm.raumverwaltung.server.RaumverwaltungImpl;
import src.de.hdm.raumverwaltung.shared.Raumverwaltung;
import src.de.hdm.raumverwaltung.shared.ReportGenerator;
import src.de.hdm.raumverwaltung.shared.bo.*;
import src.de.hdm.raumverwaltung.shared.report;


/**
 * Implementierung des <code>ReportGenerator</code>-Interface. Die technische
 * Realisierung bzgl. <code>RemoteServiceServlet</code> bzw. GWT RPC erfolgt
 * analog zu {@link RaumverwaltungImpl}.
 * Für Details zu GWT RPC siehe dort: @see ReportGenerator
 * @author Galina Schmidt
 */

public class ReportGeneratorImpl extends RemoteServiceServlet
implements ReportGenerator { 
	  /**
	   * Ein ReportGenerator benötigt Zugriff auf die Raumverwaltung,
	   * da diese die essentiellen Methoden für die Koexistenz von Datenobjekten 
	   * (vgl.bo-Package) bietet.
	   */
	private Raumverwaltung verwaltung= null;
	  
	 /**
	   * <p>
	   * Ein <code>RemoteServiceServlet</code> wird unter GWT mittels
	   * <code>GWT.create(Klassenname.class)</code> Client-seitig erzeugt. 
	   * Hierzu ist ein solcher No-Argument-Konstruktor anzulegen.
	   * Ein Aufruf eines anderen Konstruktors ist durch die Client-seitige 
	   * Instantiierung durch <code>GWT.create(Klassenname.class)</code> 
	   * nach derzeitigem Stand nicht möglich.
	   * </p>
	   * <p>
	   * Es bietet sich also an, eine separate Instanzenmethode zu erstellen, die
	   * Client-seitig direkt nach <code>GWT.create(Klassenname.class)</code>
	   * aufgerufen wird, um eine Initialisierung der Instanz vorzunehmen.
	   * </p>
	   */
	/**
	   * Initialsierungsmethode. ( No-Argument-Konstruktor)
	   * @see @ReportGeneratorImpl()
	   */
	  @Override
	public void init() throws IllegalArgumentException {

		    /**
		     * Ein ReportGeneratorImpl-Objekt instanziert für seinen Eigenbedarf eine
		     * RaumverwaltungImpl-Instanz.
		     */
		RaumverwaltungImpl v = new RaumverwaltungImpl();
		    v.init();
		    this.administration = v;
		    
		  }

	  
	  
	  
	  
	  
	  
	  
}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  