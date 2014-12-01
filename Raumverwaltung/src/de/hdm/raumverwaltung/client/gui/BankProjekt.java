package de.hdm.raumverwaltung.client.gui;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.thies.bankProjekt.client.ClientsideSettings;
import de.hdm.thies.bankProjekt.shared.BankAdministrationAsync;
import de.hdm.thies.bankProjekt.shared.bo.Bank;

/**
 * Entry-Point-Klasse des Projekts <b>BankProjekt</b>.
 */
public class BankProjekt implements EntryPoint {
	
	static interface BankTreeResources extends CellTree.Resources {
		@Override
		@Source("cellTreeClosedItem.gif")
	    ImageResource cellTreeClosedItem();

	    @Override
		@Source("cellTreeOpenItem.gif")
	    ImageResource cellTreeOpenItem();

	    @Override
		@Source("BankCellTree.css")
	    CellTree.Style cellTreeStyle(); 
	}

	BankAdministrationAsync bankVerwaltung = null;

	/**
	 * Da diese Klasse die Implementierung des Interface <code>EntryPoint</code>
	 * zusichert, benötigen wir eine Methode
	 * <code>public void onModuleLoad()</code>. Diese ist das GWT-Pendant der
	 * <code>main()</code>-Methode normaler Java-Applikationen.
	 */
	@Override
	public void onModuleLoad() {
		
		/*
		 * Zunächst weisen wir der BankAdministration eine Bank-Instanz zu, die
		 * das Kreditinstitut repräsentieren soll, für das diese Applikation
		 * arbeitet.
		 */
		if (bankVerwaltung == null) {
			bankVerwaltung = ClientsideSettings.getBankVerwaltung();
		}
		Bank bank = new Bank();
		bank.setName("HdM Bank");
		bank.setStreet("Nobelstr. 10");
		bank.setZip(70569);
		bank.setCity("Stuttgart");
		bankVerwaltung.setBank(bank, new SetBankCallback());

		/*
		 * Die Bankanwendung besteht aus einem Navigationsteil mit Baumstruktur
		 * und einem Datenteil mit Formularen für den ausgewählten Kunden und das
		 * ausgewählte Konto.
		 */
		AccountForm af = new AccountForm();
		CustomerForm cf = new CustomerForm();
		CustomerAccountsTreeViewModel catvm = new CustomerAccountsTreeViewModel();
		
		/*
		 * Die Formulare und der Kunden- und Kontobaum werden miteinander verlinkt.
		 */
		catvm.setCustomerForm(cf);
		cf.setCatvm(catvm);
		
		catvm.setAccountForm(af);
		af.setCatvm(catvm);
		
				
		/*
		 * Die Panels und der CellTree werden erzeugt und angeordnet und in das RootPanel eingefügt.
		 */
		VerticalPanel detailsPanel = new VerticalPanel();
		detailsPanel.add(cf);
		detailsPanel.add(af);

		CellTree.Resources bankTreeResource = GWT.create(BankTreeResources.class);
		CellTree cellTree = new CellTree(catvm, "Root", bankTreeResource);
		cellTree.setAnimationEnabled(true);
		
		RootPanel.get("Navigator").add(cellTree);
		RootPanel.get("Details").add(detailsPanel);
	}

	/**
	 * Diese Nested Class wird als Callback für das Setzen des Bank-Objekts bei
	 * der BankAdministration und bei dem ReportGenerator benötigt.
	 * 
	 * @author thies
	 * @version 1.0
	 */
	class SetBankCallback implements AsyncCallback<Void> {

		@Override
		public void onFailure(Throwable caught) {
			/*
			 * Wenn ein Fehler auftritt, dann geben wir eine kurze Log Message
			 * aus.
			 */
			ClientsideSettings.getLogger().severe(
					"Setzen der Bank fehlgeschlagen!");
		}

		@Override
		public void onSuccess(Void result) {
			/*
			 * Wir erwarten diesen Ausgang, wollen aber keine Notifikation
			 * ausgeben.
			 */
		}

	}

}
