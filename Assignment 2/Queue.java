package sq;

public class Queue<T> {

	private CLL<T> queue;  // the circular linked list that
	//                        represents the queue
	
	// constructor - new Queue( ) returns a
	// reference to an empty Queue
	public Queue( ){
	    // fill in here
		queue = new CLL<T>();
	}
	public void enqueue(T data){
	    // fill in here
		queue.addAtRear(data);
	    
	}
	public T dequeue( ){
	    // fill in here
		if(queue.isEmpty()==true)
			return null;
		else
			return queue.removeFront();
	    
	}
	public boolean isEmpty( ){
	    // fill in here
		return queue.isEmpty() == true;
	    
	}	
}
