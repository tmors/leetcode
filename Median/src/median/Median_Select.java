package median;

import java.util.Arrays;
//ps.没有用到两个数组是已经排序好了的这个条件
//简直fd了，终于ac了，从最开始在leetcode做就留着这个题目
//不过我觉得时间复杂度应该超过了，看来提交时间不能够通过多次提交降下去0.0
//2015-5-12 那个iskyshop项目(ˉ▽ˉ；)...
//done，但是我认为应该将二维table去除
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
	 * 按照中位数的快速排序方法对二维数组进行排序
	 * 1.在对各组进行插入排序后进行
	 * 2.找到中位数之后就以找的中位数为区分点对整个表进行快排
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
	 * 每组进行插入排序
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
		//返回中位数数组
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
		//分区点位置
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
		//以上成功对s内每组进行了插入排序
		//接下来需要对每组的中位数进行排序，求得中位数的中位数
		//需要：1.在中位数进行快速排序时，交换数据的同时需要交换同组位置
		//在函数Median_Median内实现
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
	 * 一位数组转为二维数组的形式
	 */
	public static int[][] Table_Output(int[] s,int p,int q){
		//将一维数组转化为二维数组
		//每行5个数据，最后一行为剩余数据
		//每行的第三个数据为中位数，每行非降序排列
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
	 * 将table转为一维数组
	 * next：接下来是对一维数组按照得到的中位数的中位数进行快速排序
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
	
	//打印二维数组
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
	//下面是median of two sorted array的接口
	//将输入的两个数组拼接在一起然后提交
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
