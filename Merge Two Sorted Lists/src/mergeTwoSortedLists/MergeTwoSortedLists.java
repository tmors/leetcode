package mergeTwoSortedLists;
//ac 2015-4-29
//是时候建个自己的list类了
public class MergeTwoSortedLists {

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
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t=new int[]{1,2,3,4,15,16};
		ListNode lst1=GenerateList(t),lst2=GenerateList(t);
		PrintList(mergeTwoLists(lst1,lst2));
	}
	  public static ListNode GenerateList(int[] s){
			 
		 ListNode lst=new ListNode(s[0]);
		 ListNode top=lst;
		 for(int i=1;i<s.length;i++){
			 lst.next=new ListNode(s[i]);
			 lst=lst.next;
		 }
		 return top;
	  }
	  public static void PrintList(ListNode s){
		  while(s!=null){
			  System.out.print(s.val+" ");
			  s=s.next;
		  }
		  System.out.println();
	  }
}
