package de.hdm.raumverwaltung.shared;

import de.hdm.raumverwaltung.shared.bo;
import de.hdm.raumverwaltung.shared.bo.Customer;
import de.hdm.raumverwaltung.shared.report;
import de.hdm.raumverwaltung.shared.report;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("reportgenerator")
public interface ReportGenerator extends RemoteService {

  public void init() throws IllegalArgumentException;

  public void set() throws IllegalArgumentException;


  public abstract () throws IllegalArgumentException;

  public abstract ()
      throws IllegalArgumentException;
}