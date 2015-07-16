package validPalindrome;

public class ValidPalindrome {

	/**
	 * @param args
	 */
    public static boolean isPalindrome(String s) {
    	if(s==""||s==null){
    		return true;
    	}
        int start_pos=startnext(s,0);
        if(start_pos==-1){
        	return false;
        }
        for(int end_pos=s.length()-1,i=0;start_pos<end_pos;i++){
        	if(compare(s.charAt(start_pos),s.charAt(end_pos))){
        		start_pos=startnext(s,start_pos+1);
        		end_pos=endnext(s,end_pos-1);
        	}
        	else{
        		return false;
        	}
        }
		return true;
    }
    public static int startnext(String s,int start){
        if(start>=s.length()){
            return -1;
        }
    	while(!judge(s.charAt(start))){
    		start=start+1;
    		if(start>=s.length()){
    			return -1;
    		}
    	}
    	return start;
    }
    public static int endnext(String s,int end){
    	
    	while(!judge(s.charAt(end))){
    		end=end-1;
    		if(end<0){
    			return -1;
    		}
    	}
    	return end;
    }
    public static boolean judge(char s){
    	if((s>=65&&s<=90)||(s>=97&&s<=122)||(s>=48&&s<=57)){
    		return true;
    	}
    	return false;
    }
    public static boolean compare(char s,char p){
    	char min=(char) Math.min(s, p);
    	char max=(char) Math.max(s, p);
    	s=min;
    	p=max;
    	if((s>=65&&s<=90)||(s>=97&&s<=122)){ 
			if(s==p||s==(p-32)){
				return true;
			}
    	}
    	if(p>=48&&p<=57){
    		if(p==s){
    			return true;
    		}
    	}
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="";
		System.out.println(isPalindrome(str));
	}

}
