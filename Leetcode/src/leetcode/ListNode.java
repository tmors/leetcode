package leetcode;

/*public class ListNode {
	    int val;
	    ListNode next;
	    public ListNode(int x) {
	        val = x;
	        next = null;
	    }
	  public  ListNode GenerateList(int[] s){
			 ListNode lst=new ListNode(s[0]);
			 ListNode top=lst;
			 for(int i=1;i<s.length;i++){
				 lst.next=new ListNode(s[i]);
				 lst=lst.next;
			 }
			 return top;
		  }
		  public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		     ListNode lst;
		     if(l1==null||l2==null){
		    	 return l1==null?l2:l1;
		     }
		     if(l1.val>l2.val){
		    	 l2.next=mergeTwoLists(l1,l2.next);
		    	 return l2;
		     }
		     else
		     {
		    	 l1.next=mergeTwoLists(l1.next,l2);
		    	 return l1;
		     }   
		  }
		  public  void PrintList(ListNode s){
			  while(s!=null){
				  System.out.print(s.val+" ");
			  s=s.next;
		  }
			  System.out.println();
	  }
		  //将一个节点d放在链表s首部
		  public ListNode InsertNode(ListNode s,ListNode d){
			  d.next=s;
			  return d;
		  }
}	*/

//abstract class
public  class ListNode extends Leetcode{
	 int val;
	 ListNode next;
	 public ListNode(int x) {
	     val = x;
	     next = null;
	 }
	 public ListNode(){
		 val = -1;
		 next=null;
	 }
	@Override
	public void Print(Object o) {
		// TODO Auto-generated method stub
		ListNode lst=(ListNode)o;
		while(lst!=null){
			System.out.print(lst.val+" ");
			lst=lst.next;
		}
	}

	@Override
	public Object Generate(int[] s) {
		// TODO Auto-generated method stub
		 ListNode lst=new ListNode(s[0]);
		 ListNode top=lst;
		 for(int i=1;i<s.length;i++){
			 lst.next=new ListNode(s[i]);
			 lst=lst.next;
		 }
		 return top;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	

}
