package swapNodesinPairs;
//2015-02-24
//222ms the runtime is more than the normal a little
//200ms the second time
public class SwapNodesinPairs {

	/**
	 * @param args
	 */
	public static class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) {
	    	val = x;
	        next = null;
	    }
	}
	public static ListNode swapPairs(ListNode head) {
		/*int temp=head.val;
		if(head.next==null){
			return head;
		}
		head.val=head.next.val;
		head.next.val=temp;
		if(head.next.next!=null){
			swapPairs(head.next.next);	
		}
		return head;*/
		//modify the value of the node above
	
/*		ListNode top=null,next=null;
		if(head==null){
			return null;
		}
		if(head.next==null){
			return head;
		}
		top=head.next;        //move the top List to top
		next=head.next.next;  //var next is the next List i must judge
		head.next.next=head;
		if(next==null){
			head.next=null;
			return top;
		}
		else if(next.next==null){
			head.next=next;
			return top;
			}
		else{
			head.next=next.next;
			swapPairs(next);
			return top;
		}*/
		//my code above 
		//the time of the two method is close
		  if(head == null || head.next == null)
	            return head;
	        ListNode newHead = new ListNode(-1);
	        ListNode pre = newHead;
	        ListNode curr = head;
	        while(curr != null && curr.next != null){
	            ListNode temp = curr.next.next; //this will be the next current
	            pre.next = curr.next;
	            pre = pre.next;
	            pre.next = curr;
	            curr.next = null;
	            pre = pre.next;
	            curr = temp;
	        }
	        if(curr != null)
	            pre.next = curr;
	        return newHead.next;   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode lst1=new ListNode(1);
		ListNode lst2=new ListNode(2);
		ListNode lst3=new ListNode(3);
		ListNode lst4=new ListNode(4);
		ListNode lst5=new ListNode(5);
		ListNode out= null;
		lst1.next=lst2;
		lst2.next=lst3;
		lst3.next=lst4;
		lst4.next=lst5;
		out=swapPairs(lst1);
		for(ListNode lst=out;lst!=null;lst=lst.next){
			System.out.print(lst.val+"  ");
		}
		
		
		
		
		
	}

}
