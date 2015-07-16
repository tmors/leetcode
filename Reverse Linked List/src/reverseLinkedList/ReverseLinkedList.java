package reverseLinkedList;
import leetcode.ListNode;
//ac 2015-5-7 我觉得leetcode里面结构还是要变一下
//当前的结构限制与如果ListNode类为空时，就不能成功的调用方法
//应该把方法和结构独立
public class ReverseLinkedList {

	/**
	 * @param args
	 */
    public static ListNode reverseList(ListNode head) {
        if(head==null){
        	return head;
        }
    	ListNode lst=new ListNode(head.val);
        ListNode top = lst;
    	while(head.next!=null){
        	ListNode temp=new ListNode(head.next.val);
        	temp.next=top;
        	top=temp;
        	head=head.next;
        }
    	return top;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s=new int[]{4,5,3,2,2,3};
		ListNode lst=new ListNode(1),lt = null;
		lst=lst.GenerateList(s);
		ListNode top=reverseList(null);
		
		lst.PrintList(top);
	}

}
