
public class BinaryHeap<T> {
	private ArrayList<Node<T>> array;

	public BinaryHeap(){
		this.array=new ArrayList<Node<T>>();
	}

	/** add element at the end*/
	public void add(Node<T> n){
		array.add(n);
		bubbleUp();
	}

	/** check if heap is empty*/
	public boolean isEmpty() {
		return array.size() == 0;
	}

	/** return the value of first element in heap*/
	public Node<T> peek() {
		if (this.isEmpty()) {
			throw new IllegalStateException();
		}
		return array.get(0);
	}

	/** remove the first element in heap*/
	public Node<T> remove() {
		Node<T> result = peek();
		array.remove(0);
		bubbleDown();
		return result;
	}

	/** find an element in array and return its index*/
	public int find(Node<T> n){
		int i=0;
		while (!array.get(i).equals(n)){
			i++;
		}
		return i;
	}

	/** update element's position in heap with decreased new priority*/
	public void update(int index, int key){
		//update priority
		array.get(index).setDist(key);

		// bubble up until heap property is maintained
		while (hasParent(index) && array.get(parentIndex(index)).getDist() > array.get(index).getDist()) {
			array.swap(index, parentIndex(index));
			index = parentIndex(index);
		}
	}


	// private helper methods
	private void bubbleUp() {
		int index = array.size()-1;

		// bubble up, swap with parent if child is smaller, until heap property is maintained
		while (hasParent(index) && (parent(index).getDist()>array.get(index).getDist())) {
			array.swap(index, parentIndex(index));
			index = parentIndex(index);
		}        
	}

	private void bubbleDown() {
		int index = 0;

		// bubble down until heap property is maintained
		while (hasLeftChild(index)) {
			int smallerChild = leftIndex(index);
			// get index of smaller child
			if (hasRightChild(index) && array.get(leftIndex(index)).getDist()>array.get(rightIndex(index)).getDist()) { 
				smallerChild = rightIndex(index);
			} 
			// swap parent and smaller child if child is smaller to maintain heap property
			if (array.get(index).getDist()>array.get(smallerChild).getDist()) {
				array.swap(index, smallerChild);
			} 
			else 
			{
				break;
			}
			index = smallerChild;
		}        
	}

	private boolean hasParent(int i) {
		return i > 0;
	}

	private boolean hasLeftChild(int i) {

		return leftIndex(i)<=array.size()-1;
	}

	private boolean hasRightChild(int i) {

		return rightIndex(i)<=array.size()-1;
	}

	private int leftIndex(int i) {
		return i*2 +1;
	}


	private int rightIndex(int i) {
		return i*2 + 2;
	}

	private int parentIndex(int i) {
		return (i-1)/2;
	}

	private Node<T> parent(int i) {
		return array.get(parentIndex(i));
	}

}
