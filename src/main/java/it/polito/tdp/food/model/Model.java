package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	private FoodDao dao;
	Graph<String, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao=new FoodDao();
	}
	
	public void creaGrafo(double calories) {
		this.grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//creo i vertici
		for(String vertice: dao.getPortionWithMaximalCalories(calories)) {
			this.grafo.addVertex(vertice);
		}
		System.out.println(String.format("Grafo creato con %d vertici.", this.grafo.vertexSet().size()));
		
		//aggiungo gli archi.
		for(Adiacenza a: dao.getAdiacenze()) {
			String v1=a.getPortionType1();
			String v2=a.getPortionType2();
			if(this.grafo.containsVertex(v1)) {
				if(this.grafo.containsVertex(v2)) {
					if(this.grafo.getEdge(v1, v2)==null) {
						Graphs.addEdgeWithVertices(this.grafo, v1, v2, a.getPeso());
					}
				}
			}
		}
		System.out.println(String.format("Sono stati inseriti %d archi", this.grafo.edgeSet().size()));
	}
	
	public List<String> getVertices(){
		List<String> vertici=new ArrayList<>(this.grafo.vertexSet());
		return vertici;
	}
	
	public int numVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int numEdges() {
		return this.grafo.edgeSet().size();
	}
	
	public List<PorzionePeso> neighborsOf(String vertice){
		List<PorzionePeso> result=new ArrayList<>();
		List<String> vicini=new ArrayList<>();
		vicini=Graphs.neighborListOf(this.grafo, vertice);
		for(String vicino: vicini) {
			PorzionePeso pp=new PorzionePeso(vicino, (int) this.grafo.getEdgeWeight(this.grafo.getEdge(vertice, vicino)));
			result.add(pp);
		}
		Collections.sort(result);
		return result;
	}
	
	public int calcolaPeso(List<String> cammino) {
		int sum=0;
		for(int i=0; i<cammino.size()-1;i++) {
			sum+= grafo.getEdgeWeight(grafo.getEdge(cammino.get(i), cammino.get(i+1)));
		}
		return sum;
	}
	
}
