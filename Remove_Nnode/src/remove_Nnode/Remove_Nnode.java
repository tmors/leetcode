package remove_Nnode;

import java.util.List;
//2015-02-11-15:05
//254ms
public class Remove_Nnode {

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
	  public static ListNode generateList(int n){   //Éú³ÉListNode£¬
		  ListNode list=new ListNode(0);
		  ListNode tempList1,tempList2=list;
		  for(int i=1;i<n;i++){
			  tempList1=new ListNode(i);
			  tempList2.next=tempList1;
			  tempList2=tempList2.next;
		  }
		  return list;
	  }
    public static  ListNode removeNthFromEnd(ListNode head, int n) {
    	int len=1;
    	ListNode list=head;
    	while(list.next!=null){
    		len++;
    		list=list.next;
    	}
    	list=head;
    	for(int i=len-n-1;i>0;i--){
    		list=list.next;
    	}
    	if(len==1){
    		head=null;
    		return head;
    	}
    	if(n==1){
    		list.next=null;
    		return head;
    	}
    	if(n==len){
    		head=head.next;
    		return head;
    	}
    	list.next=list.next.next;
    	return head;
    }
	public static boolean output(ListNode list){
		if(list==null){
			return false;
		}
		while(list.next!=null){
			System.out.println(list.val);
			list=list.next;
		}
		System.out.println(list.val);
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list=null;
		int len=3;
		list=generateList(len);
		output(list);
		System.out.println("-------------");
		list=removeNthFromEnd(list,1);
		output(list);
		System.out.println();
		
	}

}
