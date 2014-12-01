package de.hdm.raumverwaltung.client.gui;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

import de.hdm.thies.bankProjekt.shared.bo.Customer;

/**
 * Klasse zur Darstellung von Customer-Objekten.
 * Solche Erweiterungen von <code>AbstractCell<T></code> dienen zur Erzeugung von
 * HTML-Code für benutzerdefinierte Objekte. In diesem Fall werden die Werte der Attribute
 * <code>lastName</code> und <code>firstName</code> eines Kundenobjekts mit einem Komma
 * und einer Leerstelle in einem <code>div-</code>Element
 * erzeugt.
 * 
 * @author rathke
 *
 */public class CustomerCell extends AbstractCell<Customer> {
	@Override
    public void render(Context context, Customer value, SafeHtmlBuilder sb) {
      // Value can be null, so do a null check..
      if (value == null) {
        return;
      }

      sb.appendHtmlConstant("<div>");
      sb.appendEscaped(value.getLastName());
      sb.appendHtmlConstant(", ");
      sb.appendEscaped(value.getFirstName());
      sb.appendHtmlConstant("</div>");
    }
}
