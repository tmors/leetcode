package addtwonumbers;

import java.util.ArrayList;
import java.util.List;

//2015-02-13 accept 451ms
public class AddTwoNumbers {

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
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode ls=new ListNode(0),ls2=ls;
	    int sum=0,carry=0;
		if(l1==null){							//��������ڵ�����һΪ���򷵻���һ�ڵ�
			return l2;
		}
		if(l2==null){
			return l1;
		}
		do{
			sum=l1.val+l2.val+carry;			//����ӣ�Ȼ���ж��Ƿ�Ϊ���һ����
			carry=sum/10;
			ls2.next=new ListNode(sum%10);
			ls2=ls2.next;
			if(l1.next==null&&l2.next==null){	//ͬʱΪ�����������
				if(carry==1){
					ls2.next=new ListNode(1);
				
				}
				return ls.next;
			}
			else if(l1.next==null||l2.next==null){//�����һ�ڵ�Ϊ��
				if(l1.next==null){
					l1.next=new ListNode(0);
				}
				if(l2.next==null){
					
					l2.next=new ListNode(0);
				}
			}
			l1=l1.next;
			l2=l2.next;
		}while(true);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ListNode> lst=new ArrayList<ListNode>();
		ListNode ls1,ls2,output;
		int l1=11,l2=4;
		lst=gene(l1,l2);
		ls1=lst.get(0);
		ls2=lst.get(1);
		for(int i=0;i<l1;i++){				//���������������������
			System.out.print(ls1.val+"  ");
			ls1=ls1.next;
		}
		System.out.println();
		System.out.println("--------------");
		for(int i=0;i<l2;i++){
			System.out.print(ls2.val+"  ");
			ls2=ls2.next;
		}
		System.out.println();
		output=addTwoNumbers(lst.get(0),lst.get(1));
		for(;output.next!=null;){
			System.out.print(output.val+"  ");
			output=output.next;
		}
		System.out.println(output.val);
	}
public static List<ListNode> gene(int l1,int l2){   //�����������飬��ListNode�洢

	ListNode lsn1=new ListNode(0),lsn2=lsn1;
	ListNode lsn3=new ListNode(0),lsn4=lsn3;
	double temp=0;
	List<ListNode> lst=new ArrayList<ListNode>();
	for(int i=0;i<l1;i++){
		temp=Math.random()*10;
		lsn1.next=new ListNode((int)temp);
		lsn1=lsn1.next;
	}
	lsn2=lsn2.next;
	for(int i=0;i<l2;i++){
		temp=Math.random()*10;
		lsn3.next=new ListNode((int)temp);
		lsn3=lsn3.next;
	}
	lsn4=lsn4.next;
	lst.add(lsn2);
	lst.add(lsn4);
	return lst;
	}
}
