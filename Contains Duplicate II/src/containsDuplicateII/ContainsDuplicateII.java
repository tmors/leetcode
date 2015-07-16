package containsDuplicateII;
//做个easy做了一个半小时，我也是哔了
//20150616 
public class ContainsDuplicateII {

	/**
	 * @param args
	 */
	//1.先将len个数进行插入排序
	public static void insertsort(int[] nums,int begin,int len){
		int loc=0,cur=0,loc_val;
		while(loc<len){
			cur=loc-1;
			loc_val=nums[loc];
			while(cur>=0&&loc_val<nums[cur]){
				nums[cur+1]=nums[cur];
				cur--;
			}
			nums[cur+1]=loc_val;
			loc++;
		}
	}
	//3.当2不存在相同的数字时，插入新的数字
	public static void replacenum(int[] nums,int replaced,int insert){
		for(int i=0;i<nums.length;i++){
			if(nums[i]==replaced){
				nums[i]=insert;
				return;
			}
		}
	}
	//2.判断len长度内是否有相同的数据
	public static boolean isSame(int[] nums,int begin,int len){
		len--;
		while(len>0){
			if(nums[begin]==nums[begin+1]){
				return true;
			}
			else{
				begin++;
			}
			len--;
		}
		return false;
	}
	//ps.新建一个数组，长度为k
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		k++;
		
		int[] k_length=new int[k];
		if(nums.length<=k){
			insertsort(nums,0,nums.length);
			return isSame(nums,0,nums.length);
		}
		for(int i=0;i<k;i++){
			k_length[i]=nums[i];
		}
		int i=0;
		while(i<nums.length-k+1){
			
			//1.插入排序
			insertsort(k_length,0,k_length.length);
			//2.是否有相同数据
			if(isSame(k_length,0,k_length.length)){
				return true;
			}
			else{
				if(i==nums.length-k){
					return false;
				}
				replacenum(k_length,nums[i],nums[i+k]);
			}
			//3.不存在相同时 代替新的数字
			i++;
		}

        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{4,1,2,3,1,5};
		System.out.println(containsNearbyDuplicate(nums,3));
		
	}

}
