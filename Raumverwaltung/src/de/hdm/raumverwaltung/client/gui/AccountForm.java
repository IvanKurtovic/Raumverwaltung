package de.hdm.raumverwaltung.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.NumberFormat;
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
import de.hdm.thies.bankProjekt.shared.bo.Account;
import de.hdm.thies.bankProjekt.shared.bo.Customer;
import de.hdm.thies.bankProjekt.shared.bo.Transaction;

/**
 * Formular für die Darstellung des selektierten Kunden
 */

public class AccountForm extends VerticalPanel {
	BankAdministrationAsync bankVerwaltung = ClientsideSettings
			.getBankVerwaltung();
	Account accountToDisplay = null;
	CustomerAccountsTreeViewModel catvm = null;
	NumberFormat decimalFormatter = NumberFormat.getDecimalFormat();

	/*
	 * Widgets, deren Inhalte variable sind, werden als Attribute angelegt.
	 */
	Label idValueLabel = new Label();
	Label balanceValueLabel = new Label();
	TextBox amountTextBox = new TextBox();

	/*
	 * Im Konstruktor werden die Widgets z.T. erzeugt. Alle werden in
	 * einem Raster angeordnet, dessen Größe sich aus dem Platzbedarf
	 * der enthaltenen Widgets bestimmt.
	 */
	public AccountForm() {
		/**
		 * Das Grid-Widget erlaubt die Anordnung anderer Widgets in einem Gitter.
		 */
		Grid customerGrid = new Grid(4, 2);
		this.add(customerGrid);

		Label idLabel = new Label("Kontonummer");
		customerGrid.setWidget(1, 0, idLabel);
		customerGrid.setWidget(1, 1, idValueLabel);

		Label balanceLabel = new Label("Kontonstand");
		customerGrid.setWidget(2, 0, balanceLabel);
		customerGrid.setWidget(2, 1, balanceValueLabel);

		Label amountLabel = new Label("Betrag");
		customerGrid.setWidget(3, 0, amountLabel);
		customerGrid.setWidget(3, 1, amountTextBox);

		HorizontalPanel accountButtonsPanel = new HorizontalPanel();
		this.add(accountButtonsPanel);

		Button depositButton = new Button("Einzahlen");
		depositButton.addClickHandler(new DepositClickHandler());
		accountButtonsPanel.add(depositButton);

		Button withdrawButton = new Button("Abheben");
		withdrawButton.addClickHandler(new WithdrawClickHandler());
		accountButtonsPanel.add(withdrawButton);

		Button deleteButton = new Button("Löschen");
		deleteButton.addClickHandler(new DeleteClickHandler());
		accountButtonsPanel.add(deleteButton);

		Button newButton = new Button("Neu");
		newButton.addClickHandler(new NewClickHandler());
		accountButtonsPanel.add(newButton);
	}

	/*
	 * Click handlers und abhängige AsyncCallback Klassen.
	 */

	/**
	 * Aktivierung der "Einzahlen"-Schaltfläche führt zum Aufruf der Service
	 * Methode "createDeposit". Danach muss das Konto aktualisiert werden. Dies
	 * geschieht durch einen erneuten asynchronen Methodenaufruf, in dem das
	 * Kontoobjekt abgefragt wird.
	 * 
	 * Dies ist ein Beispiel dafür, dass im GUI keine Anwendungslogik
	 * stattfindet, da nicht immer davon auszugehen ist, dass eine Einzahlung
	 * den Kontostand um genau diesen Betrag erhöht (es könnten z.B. Gebühren
	 * angefallen sein, die gleich wieder abgezogen werden).
	 * 
	 * @author Christian Rathke
	 * 
	 */
	private class DepositClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			float amount = 0.0F;
			try {
				amount = (float) decimalFormatter
						.parse(amountTextBox.getText());
			} catch (NumberFormatException nfe) {
				Window.alert("ungültiger Wert!");
				return;
			}

			if (accountToDisplay == null) {
				Window.alert("kein Konto ausgewählt!");
				return;
			}

			// Aufruf der des Service
			bankVerwaltung.createDeposit(accountToDisplay, amount,
					new CreateDepositCallback());
		}
	}

	private class CreateDepositCallback implements AsyncCallback<Transaction> {
		@Override
		public void onFailure(Throwable caught) {
		}

		@Override
		public void onSuccess(Transaction trans) {
			if (trans != null) {
				// Von der Transaktion erhalten wird die Kontonummer des Kontos,
				// das auf der Anzeige aktualisiert werden soll.
				bankVerwaltung.getAccountById(trans.getTargetAccountID(),
						new updateAccountByIdCallback());
			}
		}
	}

	private class updateAccountByIdCallback implements AsyncCallback<Account> {
		@Override
		public void onFailure(Throwable caught) {
		}

		@Override
		public void onSuccess(Account a) {
			if (a != null) {
				setSelected(a);
				// Das Konto wird im Kunden- und Kontobaum ebenfalls aktualisiert.
				catvm.updateAccount(a);
			}
		}
	}

	/**
	 * Das gleich Spiel beim Abheben.
	 */
	private class WithdrawClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			float amount = 0.0F;
			try {
				amount = (float) decimalFormatter
						.parse(amountTextBox.getText());
			} catch (NumberFormatException nfe) {
				Window.alert("ungültiger Wert!");
				return;
			}

			if (accountToDisplay == null) {
				Window.alert("kein Konto ausgewählt!");
				return;
			}

			bankVerwaltung.createWithdrawal(accountToDisplay, amount,
					new CreateWithdrawalCallback());
		}
	}

	private class CreateWithdrawalCallback implements
			AsyncCallback<Transaction> {
		@Override
		public void onFailure(Throwable caught) {
		}

		@Override
		public void onSuccess(Transaction trans) {
			if (trans != null) {
				bankVerwaltung.getAccountById(accountToDisplay.getId(),
						new updateAccountByIdCallback());
			}
		}
	}

	/**
	 * Zum Löschen eines Kontos wird zunächst der Eigentümer abgefragt, bevor im
	 * Callback eine Löschung durchgeführt wird.
	 * 
	 */
	private class DeleteClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			if (accountToDisplay == null) {
				Window.alert("kein Konto ausgewählt");
			} else {
				bankVerwaltung
						.getCustomerById(accountToDisplay.getOwnerID(),
								new useCustomerForAccountDeletionCallback(
										accountToDisplay));
			}
		}
	}

	private class useCustomerForAccountDeletionCallback implements
			AsyncCallback<Customer> {

		Account account = null;

		useCustomerForAccountDeletionCallback(Account a) {
			account = a;
		}

		@Override
		public void onFailure(Throwable caught) {
		}

		@Override
		public void onSuccess(Customer customer) {
			if (customer != null && account != null) {
				bankVerwaltung.delete(account, new deleteAccountCallback(
						account, customer));
			}
		}
	}

	/*
	 * Da wir uns Kunde und Konto merken müssen, um den Kunden- und Kontobaum
	 * nach erfolgter Kontolöschung zu aktualisieren, hat diese Callback-Klasse
	 * private Attribute und einen Konstruktor, in dem diese Wert abgespeichert
	 * bzw. übergeben werden.
	 * 
	 * Nach erfolgter Löschung werden diese Werte verwendet.
	 */
	private class deleteAccountCallback implements AsyncCallback<Void> {

		private Customer customer = null;
		private Account account = null;

		deleteAccountCallback(Account a, Customer c) {
			account = a;
			customer = c;
		}

		@Override
		public void onFailure(Throwable caught) {

		}

		@Override
		public void onSuccess(Void result) {
			setSelected(null);
			if (customer != null) {
				catvm.removeAccountOfCustomer(account, customer);
			}
		}
	}

	/**
	 * Ein neues Konto wird mit Hilfe der Service-Methode "createAccountFor"
	 * erzeugt.
	 * 
	 */
	private class NewClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			Customer selectedCustomer = catvm.getSelectedCustomer();
			if (selectedCustomer == null) {
				Window.alert("kein Kunde ausgewählt");
			} else {
				bankVerwaltung.createAccountFor(selectedCustomer,
						new CreateAccountCallback(selectedCustomer));
			}
		}
	}

	/*
	 * Auch hier muss nach erfolgreicher Kontoerzeugung der Kunden- und
	 * Kontobaum aktualisiert werden. Dafür dient ein privates Attribut und der
	 * Konstruktor.
	 * 
	 * Wir benötigen hier nur einen Parameter für den Kunden, da das Konto als
	 * ergebnis des asynchronen Aufrufs geliefert wird.
	 */
	private class CreateAccountCallback implements AsyncCallback<Account> {

		Customer customer = null;

		CreateAccountCallback(Customer c) {
			customer = c;
		}

		@Override
		public void onFailure(Throwable caught) {
			// this.showcase.append("Fehler bei der Abfrage " +
			// caught.getMessage());
		}

		@Override
		public void onSuccess(Account account) {
			if (account != null && customer != null) {
				catvm.addAccountOfCustomer(account, customer);
			}
		}
	}

	/*
	 * catvm setter
	 */
	void setCatvm(CustomerAccountsTreeViewModel catvm) {
		this.catvm = catvm;
	}

	/*
	 * Wenn das anzuzeigende Konto gesetzt bzw. gelöscht wird, werden die zugehörenden
	 * Textfelder mit den Informationen aus dem Kontoobjekt gefüllt bzw. gelöscht. Dabei wird
	 * der Kontostand als Ergebnis eines Service-Aufrufs erhalten.
	 */
	void setSelected(Account a) {
		if (a != null) {
			accountToDisplay = a;
			idValueLabel.setText(Integer.toString(accountToDisplay.getId()));
			bankVerwaltung.getBalanceOf(accountToDisplay, new GetBalanceCallback());
		} else {
			accountToDisplay = null;
			this.amountTextBox.setText("");
			this.balanceValueLabel.setText("");
			this.idValueLabel.setText("");
		}
	}

	private class GetBalanceCallback implements AsyncCallback<Float> {
		@Override
		public void onFailure(Throwable caught) {
		}

		@Override
		public void onSuccess(Float result) {
			if (result != null) {
				balanceValueLabel.setText(decimalFormatter.format(result)
						+ " Euro");
			}
		}
	}

}
