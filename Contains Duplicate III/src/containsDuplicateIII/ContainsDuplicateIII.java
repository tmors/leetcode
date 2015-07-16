package containsDuplicateIII;
//插入排序超时了
//把这里换成快速排序
public class ContainsDuplicateIII {

	/**
	 * @param args
	 * @return 
	 */
	//交换位置
	public static void exchange(int[] nums,int i,int j){

			int temp=nums[i];
			nums[i]=nums[j];
			nums[j]=temp;  
	  

	}
	//快速排序
	public static void quicksort(int[] nums,int p,int r){
		if(p<r){
			int middle=partion(nums,p,r);
			quicksort(nums,p,middle-1);
			quicksort(nums,middle+1,r);	
		}
		
	}
	public static int partion(int[] nums,int p,int r){
		int x=nums[r];
		int i=p-1;
		for(int cur=p;cur<r;cur++){
			if(nums[cur]<x){
				i=i+1;
				exchange(nums,i,cur);
			}
		}
		exchange(nums,i+1,r);
		return i+1;
	}
	
	//插入排序
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
	public static boolean isSame(int[] nums,int begin,int len,int t){
		if(nums[nums.length-1]-nums[0]>t){
			return false;
		}
		else{
			return true;
		}
	
	}
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	k++;
		int[] k_length=new int[k];
		if(nums.length==0){
			return false;
		}
		if(nums.length<=k){
			quicksort(nums,0,nums.length-1);
			return isSame(nums,0,nums.length,t);
		}
		for(int i=0;i<k;i++){
			k_length[i]=nums[i];
		}
		int i=0;
		while(i<nums.length-k+1){
			
			//1.插入排序
			quicksort(k_length,0,k_length.length-1);
			//2.是否有相同数据
			if(isSame(k_length,0,k_length.length,t)){
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
		int[] nums=new int[]{1,3,1};
//		quicksort(nums,0,nums.length-1);
//		for(int i:nums){
//			System.out.println(i);
//		}
		System.out.println(containsNearbyAlmostDuplicate(nums,2,1));
	}

}
