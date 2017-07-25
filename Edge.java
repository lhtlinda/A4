
public class Edge<T> {
	protected Node<T> from;
	protected Node<T> to;
	protected int karma;
	protected int weight;

	public Edge(Node<T> from, Node<T> to) {
		this.from = from;
		this.to = to;
		this.weight=1;
	}

	public Node<T> getFrom() {
		return from;
	}

	public Node<T> getTo() {
		return to;
	}

	public int getWeight() {
		return weight;
	}

	public void adjustWeight(){ // increase weight to discourage continual use of one edge
		weight+=1/karma;
	}

	public void decreaseKarma(){ // called after edge is leveraged to decrease karma by 1
		karma--;
	}
	
	public void increaseKarma(){ // called after starting node makes a friend to increase karma by 1
		karma++;
	}

	public void setKarma(){ // set karma to be the number of friends of the outgoing node plus a random number
		this.karma = from.getEdges().size()+(int)(-2*Math.random()+2); // partial randomness of karma points, gives range from 0 to 4
	}




}
