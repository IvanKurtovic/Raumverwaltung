package de.hdm.raumverwaltung.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;



public interface ReportGeneratorAsync {

  void createAllAccountsOfAllCustomersReport(
      AsyncCallback<AllAccountsOfAllCustomersReport> callback);

  void createAllAccountsOfCustomerReport(Customer c,
      AsyncCallback<AllAccountsOfCustomerReport> callback);

  void init(AsyncCallback<Void> callback);

  void setBank(Bank b, AsyncCallback<Void> callback);

}
