package containsDuplicate;
//有一定的几率超时
//leetcode 用不了Hashtable，可以用HashMap
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ContainsDuplicate {

	/**
	 * @param args
	 */
	public static void insertsort(int[] nums){
		int len=nums.length;
		for(int i=0;i<len;i++){
			int save=nums[i];
			for(int k=i-1;k>=0;k--){
				if(nums[k]>save){
					nums[k+1]=nums[k];
					if(k==0){
						nums[0]=save;
					}
				}
				else{
					nums[k+1]=save;
					break;
				}
			}
		}
	}
    public static boolean containsDuplicate(int[] nums) {
//hashtable未引包
//    	Hashtable<Integer, Integer> ht=new Hashtable(); 
//    	for(int i:nums){
//    		if(ht.get(i)!=null){
//    			return true;
//    		}
//    		else{
//    			ht.put(i, i);
//    		}
//    	}
//    	return false;
//
//		排序的方法    	
/*    	insertsort(nums);
    	for(int i=0;i<nums.length-1;i++){
    		if(nums[i]==nums[i+1]){
    			return true;
    		}
    	}
    	return false;*/
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i], nums[i]);
        }
        return false;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{3,1};
		insertsort(nums);
		for(int i:nums){
			System.out.print(i+" ");
		}
		System.out.println(containsDuplicate(nums));
	}

}
