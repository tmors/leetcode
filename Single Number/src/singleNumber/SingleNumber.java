package singleNumber;
//2015-03-26
//一个不知道为什么放在hashtable里面的题目
//不过有一个hashtable的通过了，不明所以
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumber {

	/**
	 * @param args
	 */
    public static int singleNumber(int[] A) {
/*    	HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=0;i<A.length;i++){
        	if(!hs.add(A[i])){
        		hs.remove(A[i]);
        	};
        }
        Iterator itr=hs.iterator();
        while(itr.hasNext()){
        	int temp=(Integer) itr.next();
        	return temp;
        }
		return 0;*/
        int ans=0;
        for(int i=0;i<A.length;i++ ){
            ans^=A[i];
        }
        return ans;
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={1,1,2,2,3,4,3,6,4};
		System.out.println(singleNumber(A));
	}

}
