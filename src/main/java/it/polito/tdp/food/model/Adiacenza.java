package it.polito.tdp.food.model;

public class Adiacenza {
	private String portionType1;
	private String portionType2;
	private int peso;
	public Adiacenza(String portionType1, String portionType2, int peso) {
		super();
		this.portionType1 = portionType1;
		this.portionType2 = portionType2;
		this.peso = peso;
	}
	public String getPortionType1() {
		return portionType1;
	}
	public void setPortionType1(String portionType1) {
		this.portionType1 = portionType1;
	}
	public String getPortionType2() {
		return portionType2;
	}
	public void setPortionType2(String portionType2) {
		this.portionType2 = portionType2;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public String toString() {
		return this.portionType1+" - "+this.portionType2+" = "+this.peso;
	}
}
