package jumpGame;
//ac 2015-5-15 ps.明天要加班( ▼-▼ )
public class JumpGame {

	/**
	 * @param args
	 */
    public static boolean canJump(int[] nums) {
        int len=nums.length;
        int loc=len-1;
        for(int i=len-2;i>=0;i--){
        	if(nums[i]<loc-i){
        		if(i==0){
        			return false;
        		}
        		else{
        			continue;
        		}
        	}
        	else{
        		loc=i;
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i=new int[]{2,0,0};
		
		System.out.println(canJump(i));
	}

}
