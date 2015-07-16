package findPeakElement;
//ac
import java.util.ArrayList;
import java.util.List;

public class FindPeakElement {

	/**
	 * @param args
	 */
    public static int findPeakElement(int[] nums) {
        int pre=Integer.MIN_VALUE,loc=0;
      if(nums.length==1){
    	  return 0;
      }
    	for(int i:nums){
    		
    		if(i>=pre){	
        		pre=i;
        		loc++;
        		continue;
        	}
        	else{
        		return loc-1;
        	}
        }
		return loc-1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE+1};
		List<Integer> lst=new ArrayList<Integer>();
		for(int i:nums){
			lst.add(i);
		}
		System.out.println(findPeakElement(nums));
	}

}
