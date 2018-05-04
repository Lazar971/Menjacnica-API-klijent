package menjacnica;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Transakcija {
	
	private GregorianCalendar datum;
	private String izValuta;
	private String uValuta;
	private String kurs;
	
	public GregorianCalendar getDatum() {
		return datum;
	}
	public void setDatum(GregorianCalendar datum) {
		this.datum = datum;
	}
	public String getIzValuta() {
		return izValuta;
	}
	public void setIzValuta(String izValuta) {
		this.izValuta = izValuta;
	}
	public String getuValuta() {
		return uValuta;
	}
	public void setuValuta(String uValuta) {
		this.uValuta = uValuta;
	}
	public String getKurs() {
		return kurs;
	}
	public void setKurs(String kurs) {
		this.kurs = kurs;
	}

	
	
}
