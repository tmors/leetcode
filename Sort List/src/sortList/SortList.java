package sortList;



public class SortList {

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
	//πÈ≤¢≈≈–Ú
    public static ListNode sortList(ListNode head) {
		return head;
        
    }
    public static void merge_sort(int[] s,int start,int end){
    	int q=0;
    	if(start<end){
    		q=(start+end)/2;
    		merge_sort(s,start,q);
        	merge_sort(s,q+1,end);
        	merge(s,start,q,end);
    	}
    	
    }
    private static void merge(int[] s, int start, int q, int end) {
		// TODO Auto-generated method stub
		int[] L=new int[q-start+2];
		int[] R=new int[end-q+1];
		int pos1=0,pos2=0;
		for(int i=0;i<q-start+1;i++){
			L[i]=s[start+i];
		}
		L[q-start+1]=Integer.MAX_VALUE;
		for(int i=0;i<end-q;i++){
			R[i]=s[q+1+i];
		}
		R[end-q]=Integer.MAX_VALUE;
		for(int i=start;i<end+1;i++){

			if(L[pos1]>R[pos2]){
				s[i]=R[pos2];
				pos2++;
			}
			else{
				s[i]=L[pos1];
				pos1++;
			}	
		}
	}
	public static int GetLength(ListNode ln){
    	int i=0;
    	while(ln!=null){
    		i=i+1;
    		ln=ln.next;
    	}
    	return i;
    }
    public void merge_sort(ListNode ln,int start,int end){
    	
    }
    public void merge(ListNode ln1,ListNode ln2){
    	int len1=GetLength(ln1),len2=GetLength(ln2);
    	int L[]=new int[len1+1];
    	int R[]=new int[len2+1];
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s=new int[]{1,5,3,4};
		/*merge_sort(s,0,s.length-1);
	//	merge(s,0,(s.length-1)/2,s.length-1);
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]+" ");
		}*/
		ListNode lst=new ListNode(1);
		ListNode temp=lst;
		for(int i=0;i<s.length;i++){
			lst.next=new ListNode(s[i]);
			lst=lst.next;
		}
		sortList(temp);
		temp=temp.next;
		while(temp!=null){
			System.out.println(temp.val);
			temp=temp.next;
		}
	}

}
