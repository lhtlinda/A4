
public class Node<T> {
	private int distFromStart=Integer.MAX_VALUE;
	private T data;
	private boolean visited;
	private ArrayList<Edge<T>> edges;
	private Node<T> prevInOptimal;
	private Node<T> next;

	public Node(T t){
		this.data=t;
		this.visited=false;
	}

	public int getDist(){
		return distFromStart;
	}

	public void setDist( int dist){
		this.distFromStart= dist;
	}

	public boolean Visited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public ArrayList<Edge<T>> getEdges() {
		return edges;
	}
	public void setEdges(ArrayList<Edge<T>> edges) {
		this.edges = edges;
	}

	public void increaseKarma(){
		for (int i=0;i<edges.size();i++){
			edges.get(i).increaseKarma();
		}
	}
	
	public void setKarma(){
		for (int i=0;i<edges.size();i++){
			edges.get(i).setKarma();
		}
	}
	

	public T getData(){
		return data;
	}

	public Node<T> getPrev(){
		return prevInOptimal;

	}

	public void setPrev(Node<T> prev){ // set the previous node in optimal path, used later to retrieve optimal path
		this.prevInOptimal=prev;
	}

	public void adjustWeight(){ 
		// weight is adjusted after initialization to avoid low karma routes
		for (int i=0;i<edges.size();i++){
			edges.get(i).adjustWeight();
		}
	}

	public Edge<T> findEdge(Node<T> t){ // find the edge leading to a particular node in current node's edge list
		for (int i=0; i<edges.size();i++){
			if (edges.get(i).to.equals(t)){
				return edges.get(i);
			}
		}
		return null;
	}

	// helper methods for stack
	public Node<T> getNext(){ 
		return next;
	}

	public void setNext(Node<T> nex){
		next=nex;
	}



}
