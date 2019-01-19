package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//  represents a weighted undirected graph

public class Graph {
	Vertex[ ] adjLists;   // array of all vertices in the graph

	public Graph(String file) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));

		// read number of vertices
		adjLists = new Vertex[sc.nextInt()];

		// read vertex names & create vertices
		for (int v=0; v < adjLists.length; v++) {
			adjLists[v] = new Vertex(sc.next(), null);
		}

		// read edges
		while (sc.hasNext()) {
			// read vertex names and translate to vertex numbers
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			int weight = sc.nextInt( );

			// add v2 to front of v1's adjacency list and
			// add v1 to front of v2's adjacency list
			adjLists[v1].adjList = new AdjacencyNode(v2, adjLists[v1].adjList, weight);
			adjLists[v2].adjList = new AdjacencyNode(v1, adjLists[v2].adjList, weight);
		}
		sc.close( );
	}

	int indexForName(String name) {
		for (int v=0; v < adjLists.length; v++) {
			if (adjLists[v].name.equals(name)) {
				return v;
			}
		}
		return -1;
	}	
	
	// returns the number of vertices in the graph 
	public int numberOfVertices( ){
		return adjLists.length;
	}

	// print a summary of the graph
	public void summarize( ){
		for(int j = 0; j<numberOfVertices( ); j++){
			Vertex vj = adjLists[j];
			System.out.print(vj.name+": ");
			for(AdjacencyNode e = vj.adjList; e != null; e = e.next){
				System.out.print(adjLists[e.vertexNum].name+" "+e.weight+",  ");
			}
			System.out.println();
		}
	}
	
	public int shortestPath(String nameFrom, String nameTo){
		
		
		// Dijkstra's algorithm
		// start at nameFrom
		// add change inTree to true (add to fringe)
		// check the neighbors of nameFrom
		// record the shortest path to the fringe from each path 
		// add the shortest path to the fringe 
		// continue until nameTo is added to the fringe
		// backtrack the shortest paths in order to find the over shortest distance from nameFrom to nameTo, sum
		//SPRecord tells us if the vertex is in the fringe, the shortest path to a neighbor, and the distance from nameFrom
		// returns the length of the shortest path
		// create an array SPRecord to store information on vertices 
		// look through the graph until all vertices inTree are marked true
		if(nameFrom.equals(nameTo))
			return 0;
		int sum = 0; // total length of the shortest path
		Vertex curr = adjLists[indexForName(nameFrom)];
		SPRecord list[] = new SPRecord[numberOfVertices()];
		int place = indexForName(nameFrom);
		int prev = 0;
		int temp= 0;
		// this is going to the be fringe that holds the information of the graph //builds the record of all the vertices 
		for(int i=0; i<numberOfVertices(); i++){
			list[i] = new SPRecord(false,0,0);
		}
		while(list[place].inTree!=true){
			int small = 99999999;// value of the smallest link
			for(AdjacencyNode e = curr.adjList; e != null; e = e.next){// goes trough the neighbors
				if(small>e.weight && list[e.vertexNum].inTree==false){// finds the shortest link between neighbors
					
					small = e.weight;
					temp = e.vertexNum;
	
				}
			}	
			list[place].inTree = true;
			list[place].link = small;
			sum +=small;
			list[place].distance = sum;
			prev =place;
			place = temp;
			curr = adjLists[place];
			if(place == indexForName(nameTo)){
				break;
			}
			
		
		}
		if(place!=indexForName(nameTo)){
			//took the wrong path
			sum = 0;
			Vertex redo = adjLists[indexForName(nameFrom)];
			int small = 999999;
			for(AdjacencyNode r = redo.adjList; r != null; r = r.next){
				if(small>r.weight && list[r.vertexNum].inTree == false);
				small = r.weight;
				temp = r.vertexNum;
			}
			list[place].inTree = true;
			list[place].inTree = true;
			list[place].link = small;
			sum +=small;
			list[place].distance = sum;
			prev =place;
			place = temp;
			curr = adjLists[place];
			if(place == indexForName(nameTo))
					return list[prev].distance;
		}
		
		return list[prev].distance;  // replace this line with your code.
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {		
		Graph g =  new Graph("smallGraph.txt");
		g.summarize( );
		System.out.println(g.shortestPath("Cat", "Dog"));
	}
}