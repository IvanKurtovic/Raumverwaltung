package de.hdm.raumverwaltung.shared;

public class Einladung extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Status status;
	private Benutzer teilnehmer;
	private Buchung veranstatltung;
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Benutzer getTeilnehmer() {
		return teilnehmer;
	}
	public void setTeilnehmer(Benutzer teilnehmer) {
		this.teilnehmer = teilnehmer;
	}
	public Buchung getVeranstatltung() {
		return veranstatltung;
	}
	public void setVeranstatltung(Buchung veranstatltung) {
		this.veranstatltung = veranstatltung;
	}
}
