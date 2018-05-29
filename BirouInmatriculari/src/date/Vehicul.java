package date;

import java.sql.Date;

public class Vehicul {

	private String nrInmatriculare;
	private String serieSasiu;
	private int putere;
	private int capacitateCilindrica;
	private Persoana proprietar;
	private Date d;
	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public String getTip_vehicul() {
		return tip_vehicul;
	}

	public void setTip_vehicul(String tip_vehicul) {
		this.tip_vehicul = tip_vehicul;
	}

	private String tip_vehicul;
	private String raport;

	/*public Vehicul(String nrInmatriculare, String serie, int putere, int cap, Persoana p) {
		this.nrInmatriculare = nrInmatriculare;
		this.serieSasiu = serie;
		this.putere = putere;
		this.capacitateCilindrica = cap;
		this.proprietar = p;
	}
*/
	public String getNrInmatriculare() {
		return nrInmatriculare;
	}

	public void setNrInmatriculare(String nrInmatriculare) {
		this.nrInmatriculare = nrInmatriculare;
	}

	public String getSerieSasiu() {
		return serieSasiu;
	}

	public void setSerieSasiu(String serieSasiu) {
		this.serieSasiu = serieSasiu;
	}

	public int getPutere() {
		return putere;
	}

	public void setPutere(int putere) {
		this.putere = putere;
	}

	public int getCapacitateCilindrica() {
		return capacitateCilindrica;
	}

	public void setCapacitateCilindrica(int capacitateCilindrica) {
		this.capacitateCilindrica = capacitateCilindrica;
	}

	public Persoana getProprietar() {
		return proprietar;
	}

	public void setProprietar(Persoana proprietar) {
		this.proprietar = proprietar;
	}

	public String getRaport() {
		return raport;
	}

	public void setRaport(String raport) {
		this.raport = raport;
	}
}
