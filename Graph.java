public class Graph<T> {
	protected ArrayList<Node<T>> population; // Node holds general objects

	public Graph(){
		this.population=new ArrayList<Node<T>>();
	}

	/** method implements Dijkstra to find optimal path*/
	public ArrayList<Node<T>> Dijkstra(Node<T> start, Node<T> target){
		BinaryHeap<T> heap= new BinaryHeap<T>();
		for (int i=0;i<population.size();i++){
			heap.add(population.get(i));
		}
		heap.update(heap.find(start),0); // set dist of start from start to 0
		boolean found=false;
		while (!heap.isEmpty()&&!found){
			Node<T> temp=heap.remove(); // remove min value element
			temp.setVisited(true);
			if (temp.equals(target)){
				found=true;
			}

			// can't find target in current cluster (can't be reached), terminate
			if (temp.getDist()==Integer.MAX_VALUE){ 
				System.out.println("No possible route from "+((Person)start.getData()).getName()+" to "+((Person)target.getData()).getName()+" ! ");
				System.out.println("They belong in different clusters and don't have any connections!");
				clearVisited(); // clear data for future use
				initializeDist(); 
				return null;
			}

			// continue searching in current cluster
			for (int i=0;i<temp.getEdges().size()&&!found;i++){ 
				// check all unvisited neighbors to find if they have a better path than previous through current node 
				int alt= temp.getDist()+temp.getEdges().get(i).getWeight();
				if ((alt<temp.getEdges().get(i).to.getDist())&&(!temp.getEdges().get(i).to.Visited())&&(temp.getEdges().get(i).karma>0)){
					// can't use edge of karma smaller or equal to 0

					// update new optimal value for neighbor through current node
					Node<T> neighbor= temp.getEdges().get(i).to;
					heap.update(heap.find(neighbor),alt);
					neighbor.setPrev(temp); 
				}
			}
		}
		clearVisited(); // clear data for future use
		initializeDist();

		// retrieve and record path when target is found
		ArrayList<Node<T>> shortestPath= new ArrayList<Node<T>>(); 
		for (Node<T> temp=target;!temp.equals(start);temp=temp.getPrev()){
			shortestPath.add(0,temp);
		}
		shortestPath.add(0,start);
		System.out.println("Can be reached in "+ shortestPath.size()+" steps!");
		for (int i=0;i<shortestPath.size();i++){
			System.out.println(((Person)shortestPath.get(i).getData()).getName()); // cast to person to print name
		}
		return shortestPath;
	}

	/** makeFriends performs the operation of creating new friendship and change karma and weights accordingly after it's done*/
	public void makeFriends(Node<T> start, Node<T> finish){
		ArrayList<Node<T>> path= Dijkstra(start,finish);
		if (path!=null){ // target can be reached
			start.getEdges().add(new Edge<T>(start,finish)); // add friendship
			start.increaseKarma();
			for (int i=0; i<path.size()-1;i++){  // update karma and adjust weight accordingly
				path.get(i).findEdge(path.get(i+1)).decreaseKarma();
				path.get(i).findEdge(path.get(i+1)).adjustWeight();
			}
			System.out.println((((Person) start.getData()).getName())+ " has successfully made friends with "+ (((Person) finish.getData()).getName()));
		}
		else // target can't be reached
		{
			System.out.println("Can't make friends!");
		}
	}

	/** clearVisited sets visited status to false, called after every search to permit new searches*/
	private void clearVisited(){
		for (int i=0;i<population.size();i++){
			population.get(i).setVisited(false);
		}
	}

	/** initializeDist sets all distances to max integer values, called after every search to permit new searches*/
	private void initializeDist(){
		for (int i=0; i<population.size();i++){
			population.get(i).setDist(Integer.MAX_VALUE);
		}
	}


}
