import java.util.Arrays;

public class ArrayList<T> {
	private int size=0;
	private Object [] ArrayList;

	protected ArrayList(){
		ArrayList= new Object[0];
	}

	@SuppressWarnings("unchecked")
	protected T get(int index){
		if(index < size && size>0){
			return (T) ArrayList[index];
		} 
		else 
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	protected void add(T t){
		increaseSize();
		ArrayList[size-1] = t;
	}

	protected void add(int index,T t){
		increaseSize();
		if (size==1){
			ArrayList[0]=t;
		}
		else
		{
			if(index < size-1){
				int temp = size-1;
				while(temp>index){
					ArrayList[temp] = ArrayList[temp-1];
					temp--;
				}
				ArrayList[temp]=t;
			} 
			else 
			{
				throw new ArrayIndexOutOfBoundsException();
			}
		}

	}

	protected void remove(int index){
		if(index < size){
			ArrayList[index] = null;
			int temp = index;
			while(temp < size-1){
				ArrayList[temp] = ArrayList[temp+1];
				ArrayList[temp+1] = null;
				temp++;
			}            
			decreaseSize(1);
		} 
		else 
		{
			throw new ArrayIndexOutOfBoundsException();
		}

	}

	protected void remove(T t){
		for (int i=0;i<size;i++){
			if (ArrayList[i].equals(t)){
				remove(i);
			}
		}	
	}

	protected boolean isEmpty(){
		if (size==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	protected int size(){
		return size;
	}

	@SuppressWarnings("unchecked")
	protected void swap(int oldIndex, int newIndex){
		T temp=(T) ArrayList[oldIndex];
		ArrayList[oldIndex]= ArrayList[newIndex];
		ArrayList[newIndex]=temp;

	}
	protected boolean contains(T t){
		if (size==0){
			return false;
		}
		else
		{
			int s=0;
			while ((s<=size-1)&&(!ArrayList[s].equals(t))){
				s++;
			}
			if (s==size){
				return false;
			}
			else
			{
				return true;
			}
		}
	}

	protected int find(T t){ // assuming it exists
		int s=0;
		while ((s<=size-1)&&(!(ArrayList[s]).equals(t))){
			s++;
		}
		return s;

	}

	protected void clear(){

		decreaseSize(ArrayList.length);
		size=0;	
	}

	private void increaseSize(){ 
		ArrayList = Arrays.copyOf(ArrayList, ArrayList.length+1);
		size++;
	}

	private void decreaseSize(int s){
		ArrayList = Arrays.copyOf(ArrayList, ArrayList.length-s);
		size--;
	}


}



