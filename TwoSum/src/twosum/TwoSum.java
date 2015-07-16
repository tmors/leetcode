package twosum;

import java.util.HashMap;
//accept 2015-02-12

public class TwoSum {

	/**
	 * @param args
	 */
    public static int[] twoSum(int[] numbers, int target) {
		HashMap hashmap=new HashMap();
		int len;
		int index1,index2;
		int[] index = new int[2];
		len=numbers.length;
		for(int i=0;i<len;i++){
	        hashmap.put(String.valueOf(numbers[i]),String.valueOf(i+1));
		}
        for(int i=0;i<len;i++){
        	String str=target-numbers[i]+"";
        	String temp;
        	if((temp=(String) hashmap.get(str))!=null&&Integer.parseInt(temp)!=(i+1)){
        		index1=i+1;
        		index2=Integer.parseInt(temp);
        		index[0]=index1;
        		index[1]=index2;
        		return index;
        	}
        
        }
    	return index;
        
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  a={3,2,4};
		int    target=6;
		for(int i=0;i<twoSum(a,target).length;i++){
			System.out.println(twoSum(a,target)[i]);
		}
		
	}

}
