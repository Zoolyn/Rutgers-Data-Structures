package sq;

public class Stack<T>{
    
	private CLL<T> stack;  // the circular linked list that
	//                        represents the stack
	
	// constructor - new Stack( ) returns a
	// reference to an empty Stack	
	public Stack( ){
	    // fill in here
		stack = new CLL<T>();
		
	}
	
	public void push(T data){
	    // fill in here
		stack.addAtFront(data);
	    
	}
	public T pop( ){
	    // fill in here
		if(stack.isEmpty())
			return null;
		else
			return stack.removeFront();
		
	    
	}
	public boolean isEmpty( ){
	    // fill in here
		return stack.isEmpty() == true;
	}
}
