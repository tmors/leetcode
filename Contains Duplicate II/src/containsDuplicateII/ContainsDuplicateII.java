package containsDuplicateII;
//����easy����һ����Сʱ����Ҳ������
//20150616 
public class ContainsDuplicateII {

	/**
	 * @param args
	 */
	//1.�Ƚ�len�������в�������
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
	//3.��2��������ͬ������ʱ�������µ�����
	public static void replacenum(int[] nums,int replaced,int insert){
		for(int i=0;i<nums.length;i++){
			if(nums[i]==replaced){
				nums[i]=insert;
				return;
			}
		}
	}
	//2.�ж�len�������Ƿ�����ͬ������
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
	//ps.�½�һ�����飬����Ϊk
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
			
			//1.��������
			insertsort(k_length,0,k_length.length);
			//2.�Ƿ�����ͬ����
			if(isSame(k_length,0,k_length.length)){
				return true;
			}
			else{
				if(i==nums.length-k){
					return false;
				}
				replacenum(k_length,nums[i],nums[i+k]);
			}
			//3.��������ͬʱ �����µ�����
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
