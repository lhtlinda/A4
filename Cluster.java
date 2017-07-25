
public class Cluster<T> {
	private ArrayList<Node<T>> array;
	private Stack<T> stack;
	private int[] lowlink; // stores the smallest index reachable from this index in array
	private int preOrder; // initial smallest index for each index in array is set to be itself
	ArrayList<ArrayList<Node<T>>> clusters;

	/**Clusters implements Tarjan's Algorithm to find clusters (strongly connected components)*/
	public ArrayList<ArrayList<Node<T>>> Clusters(ArrayList<Node<T>> array){ 
		this.array=array;
		this.stack=new Stack<T>();
		this.clusters= new ArrayList<ArrayList<Node<T>>>();
		this.lowlink=new int[array.size()];
		this.preOrder=0;
		for (int i=0;i<array.size();i++){
			if (!array.get(i).Visited()){
				dfs(i);
			}
		}
		for (int i=0;i<array.size();i++){  // clear visited for future use
			array.get(i).setVisited(false);
		}
		return clusters;
	}

	// helper DFS 
	private void dfs(int i){
		lowlink[i]=preOrder++;
		array.get(i).setVisited(true);
		stack.push(array.get(i));
		boolean isRoot=true;
		for (int k=0;k<array.get(i).getEdges().size();k++){
			if (!array.get(i).getEdges().get(k).to.Visited()){ 
				dfs(find(array.get(i).getEdges().get(k).to));
			}
			if (lowlink[i]>lowlink[find(array.get(i).getEdges().get(k).to)]){  // update link to earlier elements
				lowlink[i]=lowlink[find(array.get(i).getEdges().get(k).to)];
				isRoot=false;
			}
		}

		if (isRoot){ // no link to earlier elements, a group of strongly connected elements found
			ArrayList<Node<T>> cluster= new ArrayList<Node<T>>();
			while (!array.get(i).equals(stack.peek())){
				lowlink[find(stack.peek())]=Integer.MAX_VALUE; // prevent cluster overlap
				cluster.add(stack.pop());
			}
			cluster.add(stack.pop());
			clusters.add(cluster);
		}
	}

	/** displayClusters displays the clusters present in the array and prints out elements of each group separately*/
	public void displayClusters(ArrayList<Node<T>> array){
		ArrayList<ArrayList<Node<T>>> disp= Clusters(array);
		System.out.println(disp.size() + " cluster(s) found!");
		for (int i=0;i<disp.size();i++){
			System.out.println("Cluster "+ (i+1) + " : ");
			for (int j=0; j<disp.get(i).size();j++){
				System.out.println(((Person)disp.get(i).get(j).getData()).getName());
			}
		}
	}

	/** find finds the index of a particular element in array, to be used in detecting strongly connected elements*/
	private int find(Node<T> n){
		int i=0;
		while (i<array.size()&&!array.get(i).equals(n)){
			i++;
		}
		return i;
	}

}
