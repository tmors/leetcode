package commonprefex;
//2015-02-11-13:24
//307ms
public class LongestCommonPrefix {

	/**
	 * @param args
	 */

	    public static String longestCommonPrefix(String[] strs) {
			int len,i=0,min_len;
			len=strs.length;
			String ans;
			
			if(strs.length==0){
				return "";
			}
			min_len=strs[i].length();
			for(;i<len;i++){
				if(min_len>strs[i].length()){
					min_len=strs[i].length();
				}
			}
			for(i=0;i<min_len;i++){
				for(int j=0;j<len-1;j++){
					if(strs[j].charAt(i)!=strs[j+1].charAt(i))			//1.遍历所有String得到最小的
					{													//2.每次比较字符时比较是否超出长度
						ans=strs[j].substring(0,i);
						return ans;
					}												
				}
			}
			ans=strs[0].substring(0,i);
	    	return ans;
	        
			
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str={"a"};//"abxcd","abxdd","abscc"};
		System.out.println(longestCommonPrefix(str));
	}

}
