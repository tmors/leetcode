package minstack;
import java.util.*;
//2015-03-11 
public class MinStack {

	/**
	 * @param args
	 */
	static class MinStack1 {
	
		Stack<Integer> stack=new Stack<Integer>();
		Stack<Integer> minstack=new Stack<Integer>();
	    int min;
		public void push(int x) {
	    	if(minstack.isEmpty()||minstack.peek()>=x){
	    		minstack.add(x);
	    	}
	    	
	        stack.add(x);
	    }

	    public void pop() {
	        if(stack.peek().equals(minstack.peek())){
	        	minstack.pop();
	        }
	    	stack.pop();
	        
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	    	return minstack.peek();
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={512,-1024,-1024,512};
		MinStack1 mst=new MinStack1();
		for(int i=0;i<input.length;i++){
			mst.push(input[i]);
		}
		mst.pop();
		System.out.println(mst.getMin());
		mst.pop();
		System.out.println(mst.getMin());
		mst.pop();
		System.out.println(mst.getMin());
		
	}

}
