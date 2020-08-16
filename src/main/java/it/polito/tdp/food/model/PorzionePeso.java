package it.polito.tdp.food.model;

public class PorzionePeso implements Comparable<PorzionePeso>{
	private String porzione;
	private Integer peso;
	public PorzionePeso(String porzione, Integer peso) {
		super();
		this.porzione = porzione;
		this.peso = peso;
	}
	public String getPorzione() {
		return porzione;
	}
	public void setPorzione(String porzione) {
		this.porzione = porzione;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public String toString() {
		return this.porzione+" - "+this.peso;
	}
	@Override
	public int compareTo(PorzionePeso o) {
		return o.peso.compareTo(this.peso);
	}
}
