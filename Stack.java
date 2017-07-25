

public class Stack<T> {
	private Node<T> top;
	private int length;

	public void push(Node<T> n) {
		if (!isEmpty()) {
			n.setNext(top);
			top=n;
		} 
		else
		{
			top=n;
		}
		length++;
	}

	public Node<T> pop() {
		if (!isEmpty()) {
			Node<T> temp = top;
			top = top.getNext();
			length--;
			return temp;
		} 
		else 
		{
			System.out.println("Stack is empty!");
			return null;
		}
	}

	public Node<T> peek(){
		if(!isEmpty())
			return top;
		else
		{
			System.out.println("Stack is empty!");
			return null;
		}
	}

	public int getLength() {
		return this.length;
	}

	public boolean isFull() {
		return false;
	}

	public boolean isEmpty() {
		return (length == 0);
	}

	public Stack() {
		length = 0;
	}



}


