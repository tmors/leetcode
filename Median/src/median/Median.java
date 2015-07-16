package median;

import java.util.Random;

public class Median {

	/**
	 * @param args
	 */
	//对每一列进行插入排序
	public static int[] InsertSort(int[] s){
		for(int i=1;i<s.length;i++){
			int key=s[i];
			for(int j=i-1;j>=0;j--){
				if(key>=s[j]){
					s[j+1]=key;
					break;
				}
				s[j+1]=s[j];
				if(j==0){
					s[0]=key;
				}
			}
		}
		return s;
	}
	//对二维数组按中位数排序
	public static void InsertSort(int[][] s){
		int[] median=new int[s.length];
		for(int i=0;i<s.length;i++){
			median[i]=s[i][(s[i].length-1)/2];
		}
		for(int i=1;i<s.length;i++){
			int key=median[i];
			int[] key_array=s[i];
			for(int j=i-1;j>=0;j--){
				if(key>=median[j]){
					median[j+1]=key;
					s[j+1]=key_array;
					break;
				}
				median[j+1]=median[j];
				s[j+1]=s[j];
				if(j==0){
					median[0]=key;
					s[0]=key_array;
				}
			}
		}
	}
	public static void SwapArray(int[][] table,int col_1,int col_2){
		
	}
	public static int select(int[][] table,int k){
		int row=table.length;
		for(int i=0;i<row;i++){
			InsertSort(table[i]);
		}
		return 0;
	}
	//如何区分高区 低区
	//把高区 低区重新整合成需要的形式
	//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd=new Random();
	
		int[] s=new int[]{3,2,4,4,5,2,3,7};
//		InsertSort(s);
//		int k=5;
		int row=s.length/5+1;
		int last=s.length%5;
		int[][] table=new int[row][];
		for(int i=0;i<row;i++){
			if(i==row-1){
				table[i]=new int[last];
				break;
			}
			table[i]=new int[5];
		}
		int r = 0,c=0;
		for(int i:s){
			table[r][c]=i;
			c++;
			if(c==5){
				r++;
				c=0;
			}
		}
		for(int[] i:table){
			InsertSort(i);
		}
		InsertSort(table);
		for(int[] i:table){
			for(int j:i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
//		select(table,k);
//		for(int i:s){
//			System.out.println(i);
//		}
	}

}
