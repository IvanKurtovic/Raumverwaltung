package de.hdm.raumverwaltung.client;

import com.google.gwt.user.client.rpc.RemoteService;

public interface Sync extends RemoteService {
	 String greetServer(String name) throws IllegalArgumentException;
}
