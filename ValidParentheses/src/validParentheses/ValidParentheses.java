package validParentheses;

import java.util.ArrayList;
import java.util.Iterator;
//2015-02-21 easy but cost me so much time;
//最好找到其它好点的方法
//173ms
public class ValidParentheses {

	/**
	 * @param args
	 */
	public static boolean isValid(String s) {
		String str;
		char[] ar=s.toCharArray();
		
		int len=0;
		
		
        for(int i=0;i<s.length();i++){
        	switch((int)s.charAt(i)){
        	case 40:
	        	ar[len++]=s.charAt(i);
	        	break;
        	case 41:
	        	ar[len++]=s.charAt(i);
	        	break;
        	case 91:
	        	ar[len++]=s.charAt(i);
	        	break;
        	case 93:
	        	ar[len++]=s.charAt(i);
	        	break;
        	case 123:
	        	ar[len++]=s.charAt(i);
	        	break;
        	case 125:
	        	ar[len++]=s.charAt(i);
	        	break;
        	}
        }
        str=String.valueOf(ar);
        str=str.substring(0, len);
        if(str.length()==0){
        	return true;
        }
        
        for(int i=0;i<str.length();i++){
        	if((int)str.charAt(i)==41||(int)str.charAt(i)==93||(int)str.charAt(i)==125){
        		if(i==0){
        			return false;
        		}
        		if(Math.abs((int)(str.charAt(i)-str.charAt(i-1)))<=2&&str.charAt(i)!=str.charAt(i-1)){
        			ar=str.toCharArray();
        			ar[i]='C';
        			ar[i-1]='C';
        			str=String.valueOf(ar);
        			return isValid(str.substring(0, len));
        		}
        		else
        			return false;
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="[]]";
		System.out.println(isValid(str));
	}

}
