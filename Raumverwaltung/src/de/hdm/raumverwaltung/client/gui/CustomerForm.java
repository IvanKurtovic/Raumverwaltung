package de.hdm.raumverwaltung.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.thies.bankProjekt.client.ClientsideSettings;
import de.hdm.thies.bankProjekt.shared.BankAdministrationAsync;
import de.hdm.thies.bankProjekt.shared.bo.Customer;

/**
 * Formular für die Darstellung des selektierten Kunden
 * 
 * @author Christian Rathke
 */
public class CustomerForm extends VerticalPanel {
	BankAdministrationAsync bankVerwaltung = ClientsideSettings
			.getBankVerwaltung();
	Customer customerToDisplay = null;
	CustomerAccountsTreeViewModel catvm = null;

	/*
	 * Widgets, deren Inhalte variable sind, werden als Attribute angelegt.
	 */
	TextBox firstNameTextBox = new TextBox();
	TextBox lastNameTextBox = new TextBox();
	Label idValueLabel = new Label();

	/*
	 * Im Konstruktor werden die anderen Widgets erzeugt. Alle werden in
	 * einem Raster angeordnet, dessen Größe sich aus dem Platzbedarf
	 * der enthaltenen Widgets bestimmt.
	 */
	public CustomerForm() {
		Grid customerGrid = new Grid(3, 2);
		this.add(customerGrid);

		Label idLabel = new Label("ID");
		customerGrid.setWidget(0, 0, idLabel);
		customerGrid.setWidget(0, 1, idValueLabel);

		Label firstNameLabel = new Label("Vorname");
		customerGrid.setWidget(1, 0, firstNameLabel);
		customerGrid.setWidget(1, 1, firstNameTextBox);

		Label lastNameLabel = new Label("Nachname");
		customerGrid.setWidget(2, 0, lastNameLabel);
		customerGrid.setWidget(2, 1, lastNameTextBox);

		HorizontalPanel customerButtonsPanel = new HorizontalPanel();
		this.add(customerButtonsPanel);

		Button changeButton = new Button("Ändern");
		changeButton.addClickHandler(new ChangeClickHandler());
		customerButtonsPanel.add(changeButton);

		Button searchButton = new Button("Suchen");
		customerButtonsPanel.add(searchButton);

		Button deleteButton = new Button("Löschen");
		deleteButton.addClickHandler(new DeleteClickHandler());
		customerButtonsPanel.add(deleteButton);

		Button newButton = new Button("Neu");
		newButton.addClickHandler(new NewClickHandler());
		customerButtonsPanel.add(newButton);
	}

	/*
	 * Click Handlers.
	 */

	/**
	 * Die Änderung eines Kunden bezieht sich auf seinen Vor- und/oder
	 * Nachnamen. Es erfolgt der Aufruf der Service-Methode "save".
	 * 
	 */
	private class ChangeClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			if (customerToDisplay != null) {
				customerToDisplay.setFirstName(firstNameTextBox.getText());
				customerToDisplay.setLastName(lastNameTextBox.getText());
				bankVerwaltung.save(customerToDisplay, new SaveCallback());
			} else {
				Window.alert("kein Kunde ausgewählt");
			}
		}
	}

	private class SaveCallback implements AsyncCallback<Void> {
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Die Namensänderung ist fehlgeschlagen!");
		}

		@Override
		public void onSuccess(Void result) {
			// Die Änderung wird zum Kunden- und Kontenbaum propagiert.
			catvm.updateCustomer(customerToDisplay);
		}
	}

	/**
	 * Das erfolgreiche Löschen eines Kunden führt zur Aktualisierung des
	 * Kunden- und Kontenbaumes.
	 * 
	 */
	private class DeleteClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			if (customerToDisplay == null) {
				Window.alert("kein Kunde ausgewählt");
			} else {
				bankVerwaltung.delete(customerToDisplay,
						new deleteCustomerCallback(customerToDisplay));
			}
		}
	}

	class deleteCustomerCallback implements AsyncCallback<Void> {

		Customer customer = null;

		deleteCustomerCallback(Customer c) {
			customer = c;
		}

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Das Löschen des Kunden ist fehlgeschlagen!");
		}

		@Override
		public void onSuccess(Void result) {
			if (customer != null) {
				setSelected(null);
				catvm.removeCustomer(customer);
			}
		}
	}

	/**
	 * Auch wenn ein neuer Kunde hinzukommt, muss der Kunden- und Kontenbaum
	 * aktualisiert werden.
	 * 
	 */
	private class NewClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			String firstName = firstNameTextBox.getText();
			String lastName = lastNameTextBox.getText();
			bankVerwaltung.createCustomer(firstName, lastName,
					new CreateCustomerCallback());
		}
	}

	class CreateCustomerCallback implements AsyncCallback<Customer> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Das Anlegen eines neuen Kunden ist fehlgeschlagen!");
		}

		@Override
		public void onSuccess(Customer customer) {
			if (customer != null) {
				// Das erfolgreiche Hinzufügen eines Kunden wird an den Kunden- und
				// Kontenbaum propagiert.
				catvm.addCustomer(customer);
			}
		}
	}

	// catvm setter
	void setCatvm(CustomerAccountsTreeViewModel catvm) {
		this.catvm = catvm;
	}

	/*
	 * Wenn der anzuzeigende Kunde gesetzt bzw. gelöscht wird, werden die
	 * zugehörenden Textfelder mit den Informationen aus dem Kundenobjekt
	 * gefüllt bzw. gelöscht.
	 */
	void setSelected(Customer c) {
		if (c != null) {
			customerToDisplay = c;
			firstNameTextBox.setText(customerToDisplay.getFirstName());
			lastNameTextBox.setText(customerToDisplay.getLastName());
			idValueLabel.setText(Integer.toString(customerToDisplay.getId()));
		} else {
			firstNameTextBox.setText("");
			lastNameTextBox.setText("");
			idValueLabel.setText("");
		}
	}

}
