package removeLinkedListElements;
//2015-06-26
public class RemoveLinkedListElements {

	/**
	 * @param args
	 */
	public static class ListNode {
		int val;  
        ListNode next;
		ListNode(int x) { val = x; }
	}
    public static ListNode removeElements(ListNode head, int val) {
    	//��head֮ǰ��һ��pre_head�����ó���List�е�һ������Ҫ�Ƴ�ʱ��headָ���λ�ò���ȷ
        ListNode cur=head;
        ListNode pre_head=new ListNode(-1);
        pre_head.next=head;
        ListNode pre_cur=pre_head;
        pre_cur.next=cur;
        while(cur!=null){
        	if(cur.val==val){
        		cur=cur.next;
        		pre_cur.next=cur;
        		continue;
        	}
        	cur=cur.next;
        	pre_cur=pre_cur.next;
        	
        }
    	return pre_head.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums=new int[]{1};
		ListNode head=new ListNode(-1);
		ListNode cur=head;
		for(int i:nums){
			cur.next=new ListNode(i);
			cur=cur.next;
		}
		int val=1;
		removeElements(head,val);
		while(head.next!=null){
			System.out.print(head.next.val+" ");
			head=head.next;
		}
	}

}
