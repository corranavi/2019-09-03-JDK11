package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model=new Model();
		model.creaGrafo(200);
		
		List<String> cammino=new ArrayList<>();
		cammino.add("6 oz container");
		cammino.add("ounce");
		cammino.add("8 oz container");
		System.out.println("Il peso del cammino è: "+model.calcolaPeso(cammino));
	}

}
