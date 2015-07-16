package implementStackusingQueues;
//2015-07-08 ²Î¿¼ÁËstackoverflow
//http://stackoverflow.com/questions/688276/implement-stack-using-two-queues
import java.util.LinkedList;
import java.util.Queue;


class MyStack {
    // Push element x onto stack.
	private Queue<Integer> q1=new LinkedList<Integer>();
	private Queue<Integer> q2=new LinkedList<Integer>();
	private Queue<Integer> temp=new LinkedList<Integer>();
	private int save;
    public void push(int x) {
    	q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(q1.size()>1){
        	q2.offer(q1.poll());
        }
        swap();
        this.save=q2.peek();
        q2.clear();
    }
    public void swap(){
    	temp=q1;
    	q1=q2;
    	q2=temp;
    }
    // Get the top element.
    public int top() {
    	pop();
    	q1.offer(save);
        return this.save;
    }
    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
public class ImplementStackusingQueues {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack ms=new MyStack();
		int[] s=new int[]{1,2,3};
		int i=0;
		while(i<s.length){
			ms.push(s[i]);
			i++;
		}
		ms.top();
		
		ms.pop();
		System.out.println(ms.top()+""+ms.empty());
	}

}
