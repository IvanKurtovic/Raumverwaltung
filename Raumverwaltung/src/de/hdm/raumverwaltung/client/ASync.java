package de.hdm.raumverwaltung.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ASync {
	 void greetServer(String input, AsyncCallback<String> callback)
		      throws IllegalArgumentException;
}
