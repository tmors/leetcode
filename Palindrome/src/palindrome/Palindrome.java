package palindrome;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Palindrome {

	/**
	 * @param args
	 */
    public static boolean isPalindrome(int x) {
        String str=x+"";
    	char[] temp;
    	int i=0;
    	System.out.println(str);
    	temp=str.toCharArray();
    	while(i<str.length()/2+1){
    		if(temp[i]!=temp[str.length()-1-i])
    			return false;
    			i++;
    	}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=0;
		System.out.println(isPalindrome(x));
	}

}
