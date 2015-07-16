package median;

import java.util.Arrays;
//ps.û���õ������������Ѿ�������˵��������
//��ֱfd�ˣ�����ac�ˣ����ʼ��leetcode�������������Ŀ
//�����Ҿ���ʱ�临�Ӷ�Ӧ�ó����ˣ������ύʱ�䲻�ܹ�ͨ������ύ����ȥ0.0
//2015-5-12 �Ǹ�iskyshop��Ŀ(��������)...
//done����������ΪӦ�ý���άtableȥ��
public class Median_Select {

	/**
	 * @param args
	 */
	public static void swap(int[][] s,int i,int j){
		int[] temp=s[i];
		s[i]=s[j];
		s[j]=temp;
	}
	public static void swap(int[] s,int i,int j){
		int temp=s[i];
		s[i]=s[j];
		s[j]=temp;
	}
	/*
	 * ������λ���Ŀ������򷽷��Զ�ά�����������
	 * 1.�ڶԸ�����в�����������
	 * 2.�ҵ���λ��֮������ҵ���λ��Ϊ���ֵ����������п���
	 */
	public static int QuickSort_Group(int[][] s,int[] median){
		int p=0,q=median.length-1;
		int i=p-1,j=p;
		int key=median[q];
		while(j<=q){
			if(median[j]<=key){
				i++;
				swap(s,i,j);
				swap(median,i,j);
			}
			j++;
		}
		return (s.length-1)/2*5+s[(s.length-1)/2].length/2;
	}
	/*
	 * ÿ����в�������
	 */
	public static void Median_Group(int[] s,int p,int q){
		
		for(int j=p+1;j<=q;j++){
			int key=s[j];
			int i=j-1;
			while(i>=0&&s[i]>key){
				s[i+1]=s[i];
				i--;
			}
			s[i+1]=key;
		}
	}
	public static int[] Median_Median(int[][] s){
		int[] median=new int[s.length];
		int row=s.length;
		for(int i=0;i<s.length-1;i++){
			median[i]=s[i][2];
		}
		median[row-1]=s[row-1][s[row-1].length/2];
		return median;
		//������λ������
	}
	public static int Partition(int[] s,int mid){
		int p=0,q=s.length-1;
		swap(s,mid,s.length-1);
		int key=s[s.length-1];
		int i=-1;
		while(p<=q-1){
			if(s[p]<=key){
				i++;
				swap(s,i,p);
			}
			p++;
		}
		swap(s,i+1,s.length-1);
		return i+1;
		//������λ��
	}
	public static int[] PartInt(int[] s,int p,int q){
		int[] r=new int[q-p+1];
		for(int i=0;i<r.length;i++){
			r[i]=s[p+i];
		}
		return r;
	}
	public static double Median(int[] s,int loc){
		if(s.length<=5){
			Median_Group(s,0,s.length-1);
			
			return s[loc-1];
		}
		int group=s.length/5;
		int rest=s.length%5;
		int len=s.length;
		for(int i=0;i<group;i++){
			int start=i*5;
			int end=(i+1)*5-1;
			Median_Group(s,start,end);
		}
		Median_Group(s,s.length-rest,s.length-1);
		//���ϳɹ���s��ÿ������˲�������
		//��������Ҫ��ÿ�����λ���������������λ������λ��
		//��Ҫ��1.����λ�����п�������ʱ���������ݵ�ͬʱ��Ҫ����ͬ��λ��
		//�ں���Median_Median��ʵ��
		int[][] table=Table_Output(s,0,s.length-1);
		int[] median=Median_Median(table);
		int mid=QuickSort_Group(table,median);
		s=Array_Output(table,len);
		int r=Partition(s,mid);
		if(r==loc-1){
			return s[r];
		}
		else if(r<loc-1){
			s=PartInt(s,r+1,s.length-1);
			return Median(s,loc-r-1);
		}
		else{
			s=PartInt(s,0,r-1);
			return Median(s,loc);
		}
	}
	/*
	 * һλ����תΪ��ά�������ʽ
	 */
	public static int[][] Table_Output(int[] s,int p,int q){
		//��һά����ת��Ϊ��ά����
		//ÿ��5�����ݣ����һ��Ϊʣ������
		//ÿ�еĵ���������Ϊ��λ����ÿ�зǽ�������
//		int row=s.length/5+1;
//		int rest=s.length%5;
//		int[][] table=new int[row][];
//		int loc=0;
//		for(int i=0;i<row-1;i++){
//			table[i]=new int[5];
//			for(int j=0;j<5;j++){
//				table[i][j]=s[loc++];
//			}
//		}
//		table[row-1]=new int[rest];
//		for(int i=0;i<rest;i++){
//			table[row-1][i]=s[s.length-rest+i];
//		}
		int loc=0;
		int len=q-p+1;
		int row=(len-1)/5+1;
		int rest=(len-1)%5+1;
		int[][] table=new int[row][];
		for(int i=0;i<row-1;i++){
			table[i]=new int[5];
			for(int j=0;j<5;j++){
				table[i][j]=s[p+loc++];
			}
		}
		table[row-1]=new int[rest];
		for(int i=0;i<rest;i++){
			table[row-1][i]=s[s.length-rest+i];
		}
		return table;
	}
	/*
	 * ��tableתΪһά����
	 * next���������Ƕ�һά���鰴�յõ�����λ������λ�����п�������
	 */
	public static int[] Array_Output(int[][] s,int len){
		int row=s.length;
		
		int[] array=new int[len];
		int loc=0;
		for(int[] i:s){
			for(int j:i){
				array[loc++]=j;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] s=new int[]{1,3,9,11,8,4,12,6,5,17,0,7,9};
//		int loc=1;
//		int i=Median(s,loc);
//		Median_Group(s,0,s.length-1);
//		System.out.println(i);
//		PrintArray(s);
//		int[][] table=Table_Output(s,0,s.length-1);
//		int[] median=Median_Median(table);
//		QuickSort_Group(table,median);
//		PrintTable(table);
//		PrintArray(median);
//		Partition(s,4);
//		PrintArray(s);
//		int[] s=new int[]{1,3,5,4,2,6};
//		float i=Median(s,2);
//		System.out.println(i);
		int[] s1=new int[]{2,3,4,6,7};
		int[] s2=new int[]{1,5};
		double i=findMedianSortedArrays(s1,s2);
		System.out.println(i);
	}
	
	//��ӡ��ά����
	public static void PrintTable(int[][] s){
		for(int[] i:s){
			for(int j:i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	public static void PrintArray(int[] s){
		for(int i:s){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//������median of two sorted array�Ľӿ�
	//���������������ƴ����һ��Ȼ���ύ
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length+nums2.length;
    	int[] merge=new int[len];
        System.arraycopy(nums1, 0, merge, 0, nums1.length);
        System.arraycopy(nums2, 0, merge, nums1.length, nums2.length);
        float i=0;
        if(len%2==0){
        	return (Median(merge,len/2)+Median(merge,len/2+1))/2;
        }
        else{
        	return Median(merge,len/2+1);
        }
       
    }
}
