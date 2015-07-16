package removeDuplicatesfromSortedList;
import leetcode.ListNode;;
//ac 2015-5-16 竟然过了12点了，前面一个题目是Jump Game
//把ListNode 打成包还是不好用
public class RemoveDuplicatesfromSortedList {

	/**
	 * @param args
	 */
	  public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
    public static ListNode deleteDuplicates(ListNode head) {
		ListNode ls=head;
		ListNode pre=new ListNode(-1);
		ListNode temp=pre;
		pre.next=ls;
		if(head==null){
			return head;
		}
		while(ls.next!=null){
			if(ls.val==ls.next.val){
				pre.next=ls.next;
			}
			else{
				pre=pre.next;
			}
			ls=ls.next;
			
		}
		return temp.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s=new int[]{1};
		ListNode ls=new ListNode(1);
		ls.next=new ListNode(1);
		ListNode temp=ls.next;
		for(int i=3;i>0;i--){
			temp.next=new ListNode(4-i);
			temp=temp.next;
		}
		ls=deleteDuplicates(ls);
		while(ls!=null){
			System.out.print(ls.val+" ");
			ls=ls.next;
		}
	}

}
