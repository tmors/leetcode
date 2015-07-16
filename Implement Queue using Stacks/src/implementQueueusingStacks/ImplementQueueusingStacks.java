package implementQueueusingStacks;
//20150708
import java.util.Stack;

class MyQueue {
    // Push element x to the back of queue.
	private Stack<Integer> st1=new Stack<Integer>();
	private Stack<Integer> st2=new Stack<Integer>();
    public void push(int x) {
        st1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(st2.empty()){
        	transfer();
        }
        st2.pop();
    }

    // Get the front element.
    public int peek() {
    	if(!st2.empty()){
    		return st2.peek();
    	}
    	else{
    		transfer();
    		return st2.peek();
    	}
        
    }
    private void transfer(){
    	while(!st1.empty()){
    		st2.push(st1.pop());
    	}
    }
    // Return whether the queue is empty.
    public boolean empty() {
    	transfer();
		return st2.empty();
        
    }
}
public class ImplementQueueusingStacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue mq=new MyQueue();
		int[] s=new int[]{};
		int i=0;
		while(i<s.length){
			mq.push(s[i]);
			i++;
		}
		
		System.out.println(mq.peek());
	}

}
