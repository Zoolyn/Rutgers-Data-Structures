package sq;

public class Client<T>{

    // prints the contents of stack of Integers s, in
    // top-to-bottom order. This mthod may change s
    // temporarily, but by the time it exits, s must be
    // set back to the contens it had when printStack was
    // called.
	public static void printStack(Stack<Integer> s){
	    // fill in here
		//use another stack
		int result;
		Stack<Integer> sTemp = new Stack<Integer>();
		while(!s.isEmpty()){
			result = s.pop();
			System.out.println(result);
			sTemp.push(result);
		}
		while(!sTemp.isEmpty()){
			s.push(sTemp.pop());
		}
	}

    // this method reverses the order of the items in the
    // stack.  What was the top Integer becomes the bottom,
    // next-to-top become next-to-bottom, etc.
	public static void flipStack(Stack<Integer> s){
	    //fill in here
		//use another queue
		Queue<Integer> qTemp = new Queue<Integer>();
		while(!s.isEmpty()){
			qTemp.enqueue(s.pop());
		}
		while(!qTemp.isEmpty()){
			s.push(qTemp.dequeue());
		}
	    
	}
}
