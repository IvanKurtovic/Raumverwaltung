package de.hdm.raumverwaltung.client.gui;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

import de.hdm.thies.bankProjekt.shared.bo.Account;

/**
 * Klasse zur Darstellung von Konto-Objekten.
 * Solche Erweiterungen von <code>AbstractCell<T></code> dienen zur Erzeugung von
 * HTML-Code für benutzerdefinierte Objekte. In diesem Fall wird die <code>id</code>
 * eines Kontoobjekts mit einem vorangestellten "Kontonnr. " in einem <code>div-</code>Element
 * erzeugt.
 * 
 * @author rathke
 *
 */
public class AccountCell extends AbstractCell<Account> {
	@Override
    public void render(Context context, Account value, SafeHtmlBuilder sb) {
      // Value can be null, so do a null check..
      if (value == null) {
        return;
      }

      sb.appendHtmlConstant("<div>Kontonr. ");
      sb.append(value.getId());
      sb.appendHtmlConstant("</div>");
    }
}
