package implementstrStr;
//2015-02-22
//305ms
public class ImplementstrStr {

	/**
	 * @param args
	 */
	
    public static int strStr(String haystack, String needle) {
		int len1=haystack.length(),len2=needle.length();
		
		for(int i=0;i<len1-len2+1;i++){
			if(haystack.substring(i, i+len2).equals(needle)){
				return i;
			}
		}
    	return -1;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("b","asse"));
	}

}
