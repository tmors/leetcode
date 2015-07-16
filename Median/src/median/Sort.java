package median;

import java.util.Random;

public class Sort {

	/**
	 * @param args
	 */
	public static void swap(int[] s,int p,int q){
		int temp=s[q];
		s[q]=s[p];
		s[p]=temp;
	}
	public static int Partition(int[] s,int p,int q){
		int key=s[q];
		int i=p-1;
		for(int j=p;j<=q-1;j++){
			if(s[j]<=key){
				i++;
				swap(s,i,j);
			}
		}
		swap(s,i+1,q);
		return i+1;
	}
	public static int Random_Partition(int[] s,int p,int q){
		Random ran=new Random();
		int i=ran.nextInt(q-p+1)+p;
		swap(s,i,q);
		return Partition(s,p,q);
	}
	public static void QuickSort(int[] s,int p,int q){
		int mid;
		if(p<q){
			mid=Random_Partition(s,p,q);
			QuickSort(s,p,mid-1);
			QuickSort(s,mid+1,q);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s=new int[]{1,3,2,5,3,4};
		QuickSort(s,0,s.length-1);
		for(int i:s){
			System.out.println(i);
		}
	}
}
