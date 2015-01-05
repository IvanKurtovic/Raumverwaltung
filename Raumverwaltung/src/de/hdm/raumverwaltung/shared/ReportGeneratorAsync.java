package de.hdm.raumverwaltung.shared;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.raumverwaltung.shared.bo.*;
import de.hdm.raumverwaltung.shared.report.erstelleReportVonRaumFuerZeitraum;
import de.hdm.raumverwaltung.shared.report.erstelleReportVonBenutzerFuerZeitraum;
import de.hdm.raumverwaltung.shared.report.erstelleReportOfBuchungenFuerZeitraum;
import de.hdm.raumverwaltung.shared.report.erstelleListeMitAlleRaeume;


/**
 * Das asynchrone Gegenstück des Interface {@link ReportGenerator}. Es wird
 * semiautomatisch durch das Google Plugin erstellt und gepflegt. Daher erfolgt
 * hier keine weitere Dokumentation. Für weitere Informationen siehe das
 * synchrone Interface {@link ReportGenerator}.
 * 
 * @author thies
 */

public interface ReportGeneratorAsync {

	 void erstelleReportVonRaumFuerZeitraum(Raum raum, Date anfangsZeit, 
			 Date endZeit, AsyncCallback<ReportVonRaumFuerZeitraum> callback);

	 void erstelleReportVonBenutzerFuerZeitraum
	 		(Benutzer benutzer, Date anfangsZeit, Date endZeit,
			 AsyncCallback<ReportVonBenutzerFuerZeitraum> callback);

	 void erstelleReportOfBuchungenFuerZeitraum(Date anfangsZeit, Date endZeit,
		      AsyncCallback<ReportVonBuchungenFuerZeitraum> callback);
	 
	 void erstelleListeMitAlleRaeume(AsyncCallback<ListeMitAlleRaeume> callback);
	 
	 void init (AsyncCallback <Void> callback);
	 
}
